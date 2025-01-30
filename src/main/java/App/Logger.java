/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author gdpm
 */
public class Logger {
    
    private static Logger instance;
    
    private String PATH;
    
    /*
    *   Each log has a level.
    *   This levels represent how important this log is. 
    *   A level 5 log is more important than a level 1 log.

    *   0 -> Note
    *   1 -> Important Note
    *   2 -> Warning
    *   3 -> Important Warning
    *   4 -> Error 
    *   5 -> Fatal Error
    */
    private int[] levels = {0, 1, 2, 3, 4, 5};
    
    private Logger(){
        getPath();
    }
    
    public static synchronized Logger getInstance(){
        
        if(instance == null) {
            synchronized (Logger.class) {
                if(instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    
    public void newLog(int level, String title, String description){
        
        LocalTime now = LocalTime.now(); 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        Log log = new Log(level, title, description, now.format(formatter).toString());
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        try(FileWriter writer = new FileWriter(PATH, true)){
            gson.toJson(log, writer);
            writer.write(System.lineSeparator()); // Adiciona uma nova linha para separar os logs
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    
    private void getPath(){
        
        String basePath;
        String os = System.getProperty("os.name").toLowerCase();
        
        if(os.contains("win"))
            basePath = System.getProperty("user.home") + "/AppDdata/Local/Fintrack/Logs/";
        else if(os.contains("mac"))
            basePath = System.getProperty("user-home") + "/Library/Application Support/Fintrack/Logs/";
        else if(os.contains("nix") || os.contains("nux") || os.contains("aix"))
            basePath = System.getProperty("user.home") + "/.fintrack/Logs/";
        else
            throw new UnsupportedOperationException("Unsupported Operating System: "+os);
        
        File dir = new File(basePath);
        if(!dir.exists())
            dir.mkdirs();
        
        System.out.println("Basepath: "+basePath);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
        Date date = new Date();
        
        PATH = basePath+dateFormat.format(date)+".json";
    }
    
}
