/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author jpfa0
 */
public class TransactionsController extends MainController implements ControllerInterface {
    
    public TransactionsController(){
        
    }
    
    public void index(){
        loadView("Transactions");
    }
 
    public void sayHello(){
        
        System.out.println("Hello!");
        
        redirect("transactions", null);
        
    }
    
}
