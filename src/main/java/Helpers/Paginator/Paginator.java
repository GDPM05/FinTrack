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
        this.itemsPerPage = itemsPerPage;
        this.totalItems = totalItems;
        this.currentPage = 0;
    }
    
    public int calculateOffset(){
        return (currentPage - 1 )* itemsPerPage;
    }
    
    public void nextPage(){
        this.currentPage += 1;
    }
    
    public void prevPage(){
        this.currentPage -= 1;
    }
    
    public void goToPage(int page){
        this.currentPage = page;
    }
    
    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    
}
