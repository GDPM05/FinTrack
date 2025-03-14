/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author gdpm
 */
public class Transaction {
    
    public String id;
    public String description;
    public String value;
    public String date;
    public String type;
    public String category;
    
    public Transaction(String id, String desc, String value, String date, String type, String category){
        this.id = id;
        this.description = desc;
        this.value = value;
        this.date = date;
        this.type = type;
        this.category = category;
    }
    
}

