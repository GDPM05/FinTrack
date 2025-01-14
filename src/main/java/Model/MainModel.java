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
    
    public int insert(String columns, Object... values){
        String placeholders = "?,".repeat(values.length).replaceAll(",$", "");
        String query = "INSERT INTO " + table + " (" + columns + ") VALUES (" + placeholders + ")";
        return db.executeUpdate(query, values);
    }
    
}
