/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory_management_system;

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

    }
}
