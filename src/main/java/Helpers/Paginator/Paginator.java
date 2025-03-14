/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers.Paginator;

/**
 *
 * @author jpfa0
 */
public class Paginator {
    
    private int itemsPerPage;
    private int totalItems;
    
    private int currentPage;
    
    public Paginator(int itemsPerPage, int totalItems){
        this.itemsPerPage = Math.max(1, itemsPerPage);
        this.totalItems = Math.max(0, totalItems);
        this.currentPage = 1;
    }
    
    public int calculateOffset(){
        return (currentPage - 1 )* itemsPerPage;
    }
    
    public void nextPage(){
        if(currentPage < getTotalPages())
            this.currentPage++;
        
    }
    
    public void prevPage(){
        if(currentPage > 1)
            this.currentPage -= 1;
    }
    
    public void goToPage(int page){
        if(page >= 1 && page <= getTotalPages())
            this.currentPage = page;
    }
    
    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        if(itemsPerPage > 0)
            this.itemsPerPage = itemsPerPage;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public int getTotalPages(){
        return (int) Math.ceil((double) totalItems / itemsPerPage);
    }
    
    public void setTotalItems(int totalItems) {
        if(totalItems > 0)
            this.totalItems = totalItems;
    }
    
    public int getEnd(){
        return Math.min(this.calculateOffset() + itemsPerPage, totalItems);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    
}
