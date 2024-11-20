package storeManagement;

import java.time.LocalDate;
class Transaction{
    private String category;  
    private double price; 
    private LocalDate date;  

    public Transaction(String category, double price, LocalDate date) {
        this.category = category;
        this.price = price;
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;  
    }

    public LocalDate getDate() {
        return date;
    }
    @Override
    public String toString() {
        return category + ": " + price + " on " + date;  
    }
}
