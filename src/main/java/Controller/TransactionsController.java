/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CategoryModel;
import Model.TransactionsModel;
import java.util.Arrays;

/**
 *
 * @author jpfa0
 */
public class TransactionsController extends MainController implements ControllerInterface {
    
    private TransactionsModel transactionsModel;
    private CategoryModel categoryModel;
    
    public TransactionsController(){
        transactionsModel = new TransactionsModel();
        categoryModel = new CategoryModel();
    }
    
    public void index(){
        loadView("Transactions", null);
    }
    
    public void newTransactionsMenu(){
        
        String[][] categoriesRaw = categoryModel.fetchAll("name");
        
        String[] categories = new String[categoriesRaw.length];
        
        for(int i = 0; i < categories.length; i++){
            categories[i] = categoriesRaw[i][0];
        }
        
        loadView("NewTransaction", categories);
    }
    
    public void newTransaction(String[] params){
        System.out.println("Data: "+Arrays.toString(params));
        
        transactionsModel.insert(null, params);    
        
        redirect("transactions", null);
    }
    
    public void myTransactionsMenu(){
        
        
        
    }
    
    public void sayHello(String[] params){
        
        System.out.println("Hello!");
        
        String[] data = transactionsModel.findById(1);
        System.out.println("Data 0: "+data[0]);
        //System.out.println("Returned data: "+Arrays.deepToString(data));
        
        redirect("transactions", null);
        
    }
    
    public void sayGoodBye(String[] params){
        System.out.println("Goddbye!");
        
        redirect("transactions", null);
    }
    
}
