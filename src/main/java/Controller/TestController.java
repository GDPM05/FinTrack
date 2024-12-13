/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Views.TestView;

/**
 *
 * @author gdpm
 */
public class TestController implements ControllerInterface{
    
    public TestController(){
        System.out.println("Controller Incializado!");
    }
    
    public void index(){
        String pageTitle = "Test Controller";
                
        TestView testeview = new TestView(pageTitle);
    }
    /*
    public void test(){
        System.out.println("Test executed");
        TestView testeview = new TestView();
    }
    */
    public void test2(){
        System.out.println("Test2 executed");
    }

    public void test3(String[] data){
        
        System.out.println("Test 3 executed.");
        
        for(int i = 0; i < data.length; i++){
            System.out.println("\nData: "+data[i]);
        }
        
    }
    
}
