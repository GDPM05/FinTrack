/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.TransactionsModel;
import java.util.Arrays;

/**
 *
 * @author jpfa0
 */
public class TransactionsController extends MainController implements ControllerInterface {
    
    private TransactionsModel model;
    
    public TransactionsController(){
        model = new TransactionsModel();;
    }
    
    public void index(){
        loadView("Transactions");
    }
 
    public void sayHello(String[] params){
        
        System.out.println("Hello!");
        
        String[] data = model.findById(1);
        System.out.println("Data 0: "+data[0]);
        //System.out.println("Returned data: "+Arrays.deepToString(data));
        
        redirect("transactions", null);
        
    }
    
    public void sayGoodBye(String[] params){
        System.out.println("Goddbye!");
        
        redirect("transactions", null);
    }
    
}
