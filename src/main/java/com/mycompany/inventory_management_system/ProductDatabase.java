/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory_management_system;

/**
 *
 * @author pola-nasser13
 */
public class ProductDatabase extends Database<Product> {

    public ProductDatabase(String filename) {
        super(filename);
    }

    @Override
    protected Product createRecordFrom(String line) {
        String[] parts = line.split(",");
        if (parts.length == 6) {
            int quantity = Integer.parseInt(parts[4].trim());
            float price = Float.parseFloat(parts[5].trim());
            return new Product(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim(), quantity, price);
        } else {
            System.out.println("Invalid format for: " + line);
            return null;
        }
    }
}
