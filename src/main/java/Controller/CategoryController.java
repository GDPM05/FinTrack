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
public class CategoryController extends MainController{
    
    CategoryModel model;
    
    public CategoryController(){
        model = new CategoryModel();
    }
    
    public void index(){
        loadView("CategoriesMenuView");
    }
    
    public void newCategory(){       
        loadView("NewCategoryMenu");
    }
    
}
