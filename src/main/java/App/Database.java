/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author gdpm
 */
public class Database {
    
    private static Database instance;
    
    // Default database file
    private String url = "jdbc:sqlite:fintrack.db";
    private Connection conn;
    
    // List of tables for our database
    private String[] tables = {"categories", "transactions", "accounts", "account_transactions", "goals"};
    private String[] tables_sql = {"""
                                    CREATE TABLE IF NOT EXISTS categories (
                                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                                        name TEXT NOT NULL,
                                        type INTEGER NOT NULL
                                    );
                                   """, 
                                   """
                                   CREATE TABLE IF NOT EXISTS transactions (
                                       id INTEGER PRIMARY KEY AUTOINCREMENT,
                                       description TEXT NOT NULL,
                                       value REAL NOT NULL,
                                       date DATE NOT NULL,
                                       type INTEGER NOT NULL,
                                       category_id INTEGER NOT NULL,
                                       FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE
                                   );
                                   """,
                                   """
                                    CREATE TABLE IF NOT EXISTS accounts (
                                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                                        name TEXT NOT NULL,
                                        description TEXT NOT NULL
                                    );
                                   """,
                                   """
                                    CREATE TABLE IF NOT EXISTS account_transactions (
                                        id_account INTEGER NOT NULL,
                                        id_transaction INTEGER NOT NULL
                                    );
                                   """,
                                   """
                                    CREATE TABLE IF NOT EXISTS goals (
                                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                                        name TEXT NOT NULL,
                                        description TEXTE NOT NULL,
                                        goal_value REAL NOT NULL,
                                        actual_value REAL NOT NULL,
                                        limit_date DATE DEFAULT NULL
                                    );
                                   """
                                   
    };
    
    
    private Database() {
            
        // Database connection
        this.connect();
        
        // Inicializes the database
        this.inicializeDatabase();
        
    }

    private void inicializeDatabase(){
        /**
         * This method is responsible for initializing the database, only if necessary.
         * As we're using SQLite, there's no need for a server to support our database.
         */
        
        // Checks if the connection was successfull before advancing
        if(this.conn != null){
            // Goes through every table
            for(int i = 0; i < tables.length; i++){
                String table = this.tables[i];
                System.out.println("Table: "+table);
                /*
                 * The sqlite_master tables, stores every table in our database.
                 */
                String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='"+table+"'";
                
                try{
                    ResultSet rs = this.fetch(sql);
                    
                    if(rs.next()){
                        System.out.println("Table "+table+" already exists, no process needed.");
                    }else{
                        sql = this.tables_sql[i];
                        System.out.println("Current query: "+sql);
                        try{
                            boolean ct = this.executeNonQuery(sql);
                            if(!ct){
                                System.out.println("There was an error while trying to creat the table \""+table+"\"");
                                return;
                            }
                        }catch(Exception e){
                            System.out.println("There was an error while creating one of the tables.");
                            return;
                        }
                    }
                }catch(Exception e){
                    System.out.println("There was an error while verifying if the table "+table+" already exists... \n"+e.getMessage());
                    return;
                }
                
            }
        }
    }
        
    public static Database getInstance(){
        if(instance == null) {
            synchronized (Database.class) {
                if(instance == null) {
                    instance = new Database();
                    System.out.println("Db instance: "+(instance != null));
                }
            }
        }
        return instance;
    }

    
    private boolean executeNonQuery(String query){
        if(query == null || query.equals(""))
            return false;
        
        try(PreparedStatement pstmt = this.conn.prepareStatement(query)){
            pstmt.executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println("Query error: "+e.getMessage());
            return false;
        }
    }
    
    public ResultSet fetch(String query){
        if(query == null)
            return null;
       
        System.out.println("Database query: "+query);
        
        try (PreparedStatement pstmt = this.conn.prepareStatement(query)){
            ResultSet rs = pstmt.executeQuery();
            
            return rs;
        }catch(Exception e){
            System.out.println("Query error: "+e.getMessage());
        }
        
        return null;
    }
    
    private void connect(){
        try {
            this.conn = DriverManager.getConnection(this.url);
            if(conn != null)
                System.out.println("Connected successfully!");
            
            if (this.conn == null || this.conn.isClosed()) {
                System.out.println("Connection is closed. Reconnecting...");
                this.connect();
            }

        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    
}
