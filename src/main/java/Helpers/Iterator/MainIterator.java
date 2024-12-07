/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers.Iterator;

/**
 *
 * @author gdpm
 */
public class MainIterator implements IteratorInterface{

    Object[] data;
    
    Object current_item;
    int current_index;
    int last_index;
    
    
    public void insertData(Object[] data) {
        if(data.length > 0){
            this.data = data;
        }else
            System.out.println("Empty data array.");
    }
    

    public Object iterate(boolean simple, Operation operation) {
        for(int i = 0; i < data.length; i++){
            if(simple && operation == null)
               return this.data[i]; 
        }
        
        return 0;
    }
    
}
