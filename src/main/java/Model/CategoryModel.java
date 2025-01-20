/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jpfa0
 */
public class CategoryModel extends MainModel{
    
    public CategoryModel(){
        super();
        this.key = "id";
        this.table = "categories";
        this.attributes = new String[]{"name", "type"};
    }
    
}
