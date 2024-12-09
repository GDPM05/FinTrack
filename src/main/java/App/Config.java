/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author gdpm
 */
public class Config {
    /**
     * Routes array
     * 
     * This array will store all the routes of the system. 
     * 
     * To define a route, you simply have to indicate it's type, name and what method from wich controller will be executed.
     */
    static public String[][] routes = {
        {"teste", "GET", "TestController/test"},
        {"test2", "GET", "TestController/test2"}
    };
    
}