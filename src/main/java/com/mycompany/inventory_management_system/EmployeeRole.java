/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory_management_system;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Ibrahim
 */
public class EmployeeRole {

    private ProductDatabase productsDatabase;
    private CustomerProductDatabase customerProductDatabase;

    public EmployeeRole() {
        productsDatabase = new ProductDatabase("Products.txt");
        customerProductDatabase = new CustomerProductDatabase("CustomersProducts.txt");
        productsDatabase.readFromFile();
        customerProductDatabase.readFromFile();
    }

    public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity) {
        final float PRICE = 100.00f;
        Product newProduct = new Product(productID, productName, manufacturerName, supplierName, quantity, PRICE);
        System.out.println("Adding Product...");
        productsDatabase.insertRecord(newProduct);
        productsDatabase.saveToFile();
    }
    
    public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) {
        Product newProduct = new Product(productID, productName, manufacturerName, supplierName, quantity, price);
        System.out.println("Adding Product...");
        productsDatabase.insertRecord(newProduct);
        productsDatabase.saveToFile();
    }
    

    public Product[] getListOfProducts(){
        System.out.println("Fetching the list of Products...");
        ArrayList<Product> records = productsDatabase.returnAllRecords();
        if(records.size() == 0){
        System.out.println("Database is empty");
                }
        return records.toArray(new Product[records.size()]);
    }

    public CustomerProduct[] getListOfPurchasingOperations(){
        System.out.println("Fetching history of purchasing operations...");
        ArrayList<CustomerProduct> records = customerProductDatabase.returnAllRecords();
        if(records.size() == 0){
        System.out.println("Database is empty");
                }
        return records.toArray(new CustomerProduct[records.size()]);
    }
    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate){
        Product product = productsDatabase.getRecord(productID);
        if(product != null){
            if(product.getQuantity() == 0){
                System.out.println("Product out of stock");
                return false;
            }
            else{
                CustomerProduct record = new CustomerProduct(customerSSN,productID, purchaseDate);
                System.out.println("Successfully purchased " + product.getProductName() +"!");
                product.setQuantity(product.getQuantity() - 1);
                System.out.println("Adding the purchase to the database...");
                customerProductDatabase.insertRecord(record);
                productsDatabase.saveToFile();
                customerProductDatabase.saveToFile();
                return true;
            }
        }
        else {
            System.out.println("Product not in the database!");
            return false;
        }
    }
    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate ,LocalDate returnDate){
        if(returnDate.isBefore(purchaseDate)){
            return -1;
        }
        else {
            Product product = productsDatabase.getRecord(productID);
            if(product != null){
                 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String key = customerSSN + "," + productID + "," + purchaseDate.format(formatter);
                CustomerProduct cProduct = customerProductDatabase.getRecord(key);
                if (cProduct != null){
                    long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(purchaseDate, returnDate);
                    if(daysBetween > 14){
                        System.out.println("Non-refundable. More than 14 days have passed.");
                        return -1;
                    }
                    else {
                        product.setQuantity(product.getQuantity() + 1);
                        String recordKey = customerSSN + "," + productID + ',' + purchaseDate.format(formatter);
                        customerProductDatabase.deleteRecord(recordKey);
                        customerProductDatabase.saveToFile();
                        productsDatabase.saveToFile();
                        System.out.println("Return successful!");
                        return product.getPrice();
                    }
                }
                else {
                    System.out.println("Product not in purchase history");
                    return -1;
                }

            }
            else {
                System.out.println("Product not in the database!");
                return -1;
            }
        }
    }
    public boolean applyPayment(String customerSSN, String productID, LocalDate purchaseDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String recordKey = customerSSN + "," + productID + ',' + purchaseDate.format(formatter);
        CustomerProduct cProduct = customerProductDatabase.getRecord(recordKey);
        if(cProduct != null){
            if (!cProduct.isPaid()){
                cProduct.setPaid(true);
                System.out.println("Transaction successful!");
                System.out.println("Saving...");
                customerProductDatabase.saveToFile();
                return true;
            }
            else {
                System.out.println("Product already paid for");
                return false;
            }
        }
        else {
            System.out.println("Product not in purchase history");
            return false;
        }
    }
    public void logout(){
        System.out.println("Logging out. Saving...");
        productsDatabase.saveToFile();
        customerProductDatabase.saveToFile();
    }

}