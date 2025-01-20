/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author gdpm
 */
public class Log {
    
    private int level;
    private String title;
    private String description;
    private String time;

    public Log(int level, String title, String description, String time) {
        this.level = level;
        this.title = title;
        this.description = description;
        this.time = time;
    }
    
}
