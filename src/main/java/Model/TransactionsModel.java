/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gdpm
 */
public class TransactionsModel extends MainModel{
    
    public TransactionsModel(){
        super();
        this.table = "transactions";
        this.key = "id";
        this.attributes = new String[]{"description", "value", "date", "type", "category_id"};
    }
    
}
