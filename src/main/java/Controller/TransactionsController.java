/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author gdpm
 */
public class TransactionsController extends MainController implements ControllerInterface{
    
    public TransactionsController(){
        
    }
    
    public void index(){
        this.loadView("Transactions");
    }
    
}
