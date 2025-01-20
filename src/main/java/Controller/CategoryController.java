/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CategoryModel;

/**
 *
 * @author jpfa0
 */
public class CategoryController extends MainController implements ControllerInterface{
    
    CategoryModel model;
    
    public CategoryController(){
        model = new CategoryModel();
    }
    
    public void index(){
        loadView("CategoriesMenu", null);
    }
    
    public void newCategoryMenu(){       
        loadView("NewCategoryMenu", null);
    }
    
    public void newCategory(String[] params){
        
        params[1] = (params[1].equals("Income")) ? "1" : "0";
        
        model.insert(null, params);
        
    }
    
}
