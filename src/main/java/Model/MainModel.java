/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import App.Database;
import com.sun.istack.Nullable;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gdpm
 */
public class MainModel {
    // This class is responsible for housing the main methods for interacting with the database.
    // These methods include: insert, fetch, fetch_all, update, and delete.
    
    private Database db = Database.getInstance();
    
    public String table;
    public String key;    
    
    public void insert(){
        
    }
    
    public Object[][] fetch(@Nullable String[] data, @Nullable String where){
        
        // By default, it will fetch eveything from the table
        String columns = "*";
        if(data != null){
            columns = "";
            for(int i = 0; i < data.length; i++){
                columns += data[i];
                
                // If it's not the last column, add a ,
                if(i < data.length - 1)
                    columns += ", ";
            }
        }
        
        System.out.println("table: "+table); 
        
        String query = "SELECT " + columns + " FROM " + table + ((where != null) ? " " + where : "");
        
        System.out.println("Query: "+query);
        
        Object[][] resultArray = new Object[0][0];
        
        try(ResultSet result = db.fetch(query)){
            
            List<Object[]> resultList = new ArrayList<>();
            
            if(result.next()){
            
                while(result.next()){

                    int columnCount = result.getMetaData().getColumnCount();

                    Object[] row = new Object[columnCount];

                    for(int i = 0; i < columnCount; i++){
                        row[i] = result.getObject(i+1);
                        System.out.println("Current row: "+row[i].toString());
                    }
                    resultList.add(row);   
                }            

                resultArray = resultList.toArray(new Object[0][0]);
            }else{
                System.out.println("No data to return");
            }
        }catch(SQLException e){
            System.out.println("Erro while fetching: "+e.getMessage());
        }
        
        return resultArray;
    }
    
    public void fetch_all(){
        
    }
    
    public void update(){
        
    }
    
    public void delete(){
        
    }
    
}
