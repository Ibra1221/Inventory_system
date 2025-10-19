/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.inventory_management_system;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author YoussefHisham
 */

public class CustomerProduct implements Info {

    private String customerSSN;
    private String productID;
    private LocalDate purchaseDate;
    private boolean paid;

    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        setCustomerSSN(customerSSN);
        setProductID(productID);
        setPurchaseDate(purchaseDate);
        this.paid = false;
    }

    public String getCustomerSSN() {
        return customerSSN;
    }

    public String getProductID() {
        return productID;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String lineRepresentation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return customerSSN + "," + productID + "," + purchaseDate.format(formatter) + "," + paid;
    }

    @Override
    public String getSearchKey() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return customerSSN + "," + productID + "," + purchaseDate.format(formatter);
    }
    public void setCustomerSSN(String customerSSN){
        try{
        Long.parseLong(customerSSN);    
        if(customerSSN.length()!=14){
            System.out.println("Invalid SSN: must be 14 digits long");
        return;
    }
       else if(customerSSN.startsWith("0")){
            System.out.println("Invalid SSN: cannot start with 0");
            return;
        }
            this.customerSSN=customerSSN;
        System.out.println("Valid SSN: " + customerSSN);
        }catch(NumberFormatException e){
            System.out.println("Invalid SSN: must contain digits only ");
        }
}
    public void setProductID(String productID){
        this.productID=productID;
    }
    public void setPurchaseDate(LocalDate purchaseDate){
         if(purchaseDate == null){
            System.out.println("Error: Purchase date cannot be null.");
            return;
        }
         else if(purchaseDate.isAfter(LocalDate.now())){
            System.out.println("Error: Purchase date cannot be in future.");
            return;}
        else if(purchaseDate.isBefore(LocalDate.of(2000, 1, 1))){
            System.out.println("Warning: Purchase date seems too old.set to default date(01-01-2000)");
            return;
        }
        else{
            this.purchaseDate=purchaseDate;
        }
    }
        
    }
