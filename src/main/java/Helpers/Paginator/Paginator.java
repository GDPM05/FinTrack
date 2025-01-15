/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers.Paginator;

/**
 *
 * @author gdpm
 */
public class Paginator {
    
    private int page;
    private final int limit;
    private final int nItems;
    
    private int nPages;
    
    public Paginator(int page, int limit, int nItems){
        this.page = page;
        this.limit = limit;
        this.nItems = nItems;
        this.getNumPages();
    }
    
    private void getNumPages(){
        nPages = (int)Math.ceil((double)nItems / limit);
    }
    
    public void nextPage(){
        page = (page < nPages) ? page + 1 : page;
    }
    
    public void prevPage(){
        page = (page > 0) ? page - 1 : 0;
    }
    
    public int getCurrentPage(){
        return page;
    }
    
    public int calculateOffset(){
        int offset = (page - 1) * limit;
        
        return offset;
    }
    
}
