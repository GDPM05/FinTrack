package App;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    
    public static Database instance;
    
    private String PATH;
    
    private Connection conn;
    
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
    
    private Database(){
        getPath();
        connect();
        System.out.println("Path: "+PATH);
    }

    private void initializeDatabase(){
        
        try{
            Statement stmt = conn.createStatement();
            
            for(int i = 0; i < tables.length; i++){
                String tableName = tables[i];
                
                String checkTableQuery = "SELECT name FROM sqlite_master WHERE type='table' AND name='"+tableName+"';";
                ResultSet rs = stmt.executeQuery(checkTableQuery);
                
                if(!rs.next()){
                    System.out.println("Creating table: "+tableName);
                    stmt.execute(tables_sql[i]);
                }else
                    System.out.println("Table already exists: "+tables[i]);
                
                rs.close();
            }
            stmt.close();
            System.out.println("Database Initialized");
        }catch(SQLException e){
            System.out.println("SQL Error: "+e.getMessage());
        }
        
    }
    
    private void getPath(){
        
        String basePath;
        String os = System.getProperty("os.name").toLowerCase();
        
        if(os.contains("win"))
            basePath = System.getProperty("user.home") + "/AppDdata/Local/Fintrack/";
        else if(os.contains("mac"))
            basePath = System.getProperty("user-home") + "/Library/Application Support/Fintrack/";
        else if(os.contains("nix") || os.contains("nux") || os.contains("aix"))
            basePath = System.getProperty("user.home") + "/.fintrack/";
        else
            throw new UnsupportedOperationException("Unsupported Operating System: "+os);
        
        File dir = new File(basePath);
        if(!dir.exists())
            dir.mkdirs();
        
        System.out.println("Basepath: "+basePath);
        
        PATH = "jdbc:sqlite:"+basePath+"fintrack.db";
    }
    
    public int executeUpdate(String query, Object... params){
        try{
            
            System.out.println("Query: " + query);
            System.out.println("Params: " + Arrays.toString(params));
            
            PreparedStatement stmt = conn.prepareStatement(query);
            setParameters(stmt, params);
            
            return stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error while executing update query: "+e.getMessage());
            return 0;
        }
    }
    
    public ResultSet executeQuery(String query, Object... params){
        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            setParameters(stmt, params);
            
            return stmt.executeQuery();
        }catch(SQLException e){
            System.out.println("Error while executing query: "+e.getMessage());
            return null;
        }
    }
    
    private void setParameters(PreparedStatement pstmt, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            pstmt.setObject(i + 1, params[i]);
        }
    }
    
    public static synchronized Database getInstance(){
        
        if(instance == null) {
            synchronized (App.class) {
                if(instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }
    
    private void connect(){
        try{
            conn = DriverManager.getConnection(PATH);
            System.out.println("Connection established.");
            initializeDatabase();
        }catch(SQLException e){
            System.out.println("Error while trying to connect: "+e.getMessage());
        }
        
    }
    
}
