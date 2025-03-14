/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Helpers.Paginator.Paginator;
import Model.CategoryModel;
import Model.TransactionsModel;
import Objects.Transaction;
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
        
        String[][] categoriesRaw = categoryModel.fetchAll("name", null, null);
        
        String[] categories = new String[categoriesRaw.length];
        
        for(int i = 0; i < categories.length; i++){
            categories[i] = categoriesRaw[i][0];
        }
        
        loadView("NewTransaction", categories);
    }
    
    public void newTrannsaction(String[] params){
        System.out.println("Data: "+Arrays.toString(params));
        
        transactionsModel.insert(null, params);    
        
        redirect("transactions", null);
    }
    
    public void myTransactionsMenu(){
        
        int maxPerPage = 20;
        
        int totalTransactions = transactionsModel.fetchCount();
        
        Paginator paginator = new Paginator(maxPerPage, totalTransactions);
        
        String[][] transactionsArr = transactionsModel.fetchAll("id, description, value, date, type, category_id", paginator.calculateOffset(), paginator.getEnd());
        
        Transaction[] transactions = new Transaction[transactionsArr.length];
        
        for(int i = 0; i < transactions.length; i++){
            transactions[i] = new Transaction(transactionsArr[i][0], transactionsArr[i][1], transactionsArr[i][2], transactionsArr[i][3], transactionsArr[i][4],transactionsArr[i][5]);;
        }
        
        System.out.println("Transactions: \n"+Arrays.deepToString(transactions));
        
        loadView("MyTransactionsMenu", transactions);
    }
   
    
}
