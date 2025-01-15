package Model;

import App.Database;
import com.sun.istack.Nullable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author GDPM
 * 
 * Classe fully planned following the DRY principle. 
 */

public class MainModel {
    private Database db;
    
    public String table;
    public String key;    
    public String[] attributes;
    
    public MainModel(){
        db = Database.getInstance();
    }
    
    public String[] findById(int id){
        
        String attributes = String.join(", ", this.attributes);
        
        String query = "SELECT "+attributes+" FROM "+table+" WHERE "+key+" = ?";
        
        try{
            
            String[] data = new String[this.attributes.length];
            
            ResultSet rs = db.executeQuery(query, id);
            
            for(int i = 0; i < this.attributes.length; i++){
                data[i] = rs.getString(i+1);
            }
            
            return data;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        
    }
    
    public String[][] fetchAll(){
        String attributes = String.join(", ", this.attributes);
        
        String query = "SELECT "+attributes+" FROM "+table+";";
        
        try{
            String[][] data = new String[this.fetchCount()][this.attributes.length];
            
            ResultSet rs = db.executeQuery(query, null);
            
            int index = 0;
            
            while(rs.next()){
                for(int i = 0; i < this.attributes.length; i++){
                    data[index][i] = (String)rs.getObject(i+1);
                }
            }
            return data;
        }catch(SQLException e){
            System.out.println("Error while trying to fetch all: "+e.getMessage());
            return null;
        }
    }
    
    public int insert(String columns, Object... values){
        String placeholders = "?,".repeat(values.length).replaceAll(",$", "");
        String query = "INSERT INTO " + table + " (" + columns + ") VALUES (" + placeholders + ")";
        return db.executeUpdate(query, values);
    }
    
    public int deleteById(int id){
        String query = "DELETE FROM "+table+" WHERE id = ?";
        
        return db.executeUpdate(query, key);
    }
    
    public int delete(String attribute, Object... value){
        String query = "DELETE FROM "+table+" WHERE "+attribute+" = ?";
        
        return db.executeUpdate(query, value);
    }
    
    public int fetchCount(){
        
        String query = "SELECT COUNT(*) FROM"+table;
        
        try{
            int data;
            
            ResultSet rs = db.executeQuery(query, null);
            
            data = rs.getInt(0);
            
            return data;
        }catch(SQLException e){
            System.out.println("Error couting: "+e.getMessage());
            return 0;
        }
        
    }
    
    public int update(int id, String[] columns, Object... values){
        
        String query = "UPDATE "+table+" SET ";
        
        for(int i = 0; i < columns.length; i++){
            columns[i] = columns[i] + " = ?";
        }
        
        query += String.join(", ", columns);
        
        return db.executeUpdate(query, values);
    }
    
    //public String[] fetchAll(String order, int offset){
        
    //}
}
