/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory_management_system;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Ibrahim
 */
public class EmployeeRole {

    private ProductDatabase productsDatabase;
    private CustomerProductDatabase customerProductDatabase;

    public EmployeeRole() {
        productsDatabase = new ProductsDatabase("Products.txt");
        customerProductDatabase = new CustomerProductDatabase("CustomersProducts.txt");
    }

    public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity) {
        Product newProduct = new Product(productID, productName, manufacturerName, supplierName, quantity);
        System.out.println("Adding Product...");
        productsDatabase.insertRecord(newProduct);
    }

    public Product[] getListOfProducts(){
        System.out.println("Fetching the list of Products...");
        ArrayList<Product> records = productsDatabase.returnAllRecords();
        return records.toArray(new Product[records.size()]);
    }

    public CustomerProduct[] getListOfPurchasingOperations(){
        System.out.println("Fetching history of purchasing operations...");
        ArrayList<CustomerProduct> records = customerProductDatabase.returnAllRecords();
        return records.toArray(new CustomerProduct[records.size()]);
    }
    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate){
        Product product = productsDatabase.getRecord(productID);
        if(product != null){
            if(product.quantity == 0){
                System.out.println("Product out of stock");
                return false;
            }
            else{
                System.out.println("Successfully purchased " + product.name +"!");
                product.quantity--;
                CustomerProduct record = new CustomerProduct(customerSSN,productID, purchaseDate);
                System.out.println("Adding the purchase to the database...");
                customerProductDatabase.insertRecord(record);
                return true;
            }
        }
        else {
            System.out.println("Product not in the database!");
            return false;
        }
    }
    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate ,LocalDate returnDate){
        if(returnDate.compareTo(purchaseDate) > 0){
            return -1;
        }
        else {
            Product product = productsDatabase.getRecord(productID);
            if(product != null){
                CustomerProduct cProduct = customerProductDatabase.getRecord(productID);
                if (cProduct != null){
                    if(returnDate.compareTo(purchaseDate) < -14){
                        System.out.println("Non-refundable. More than 14 days have passed.");
                        return -1;
                    }
                    else {
                        product.quantity++;
                        customerProductDatabase.deleteRecord(productID);
                        customerProductDatabase.saveToFile();
                        return product.price;
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
        CustomerProduct cProduct = customerProductDatabase.getRecord(productID);
        if(cProduct != null){
            if (cProduct.paid != true){
                cProduct.paid = true;
                System.out.println("Transaction successful!");
                System.out.println("Saving...");
                customerProductDatabase.saveToFile();
                return true;
            }
        }
        else {
            System.out.println("Product not in purchase history");
        }
    }
    public void logout(){
        System.out.println("Logging out. Saving...");
        productsDatabase.saveToFile();
        customerProductDatabase.saveToFile();
    }

}