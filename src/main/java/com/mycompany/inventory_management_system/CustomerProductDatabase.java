/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory_management_system;
import java.time.LocalDate;
/**
 *
 * @author pola-nasser13
 */
public class CustomerProductDatabase extends Database<CustomerProduct> {

    public CustomerProductDatabase(String filename) {
        super(filename);
    }

    @Override
    protected CustomerProduct createRecordFrom(String line) {
        String[] parts = line.split(",");
        if (parts.length >= 3) {
            LocalDate date = LocalDate.parse(parts[2].trim()); // (YYYY-MM-DD)
            CustomerProduct cp = new CustomerProduct(parts[0].trim(), parts[1].trim(), date);
            if (parts.length == 4) {
                cp.setPaid(Boolean.parseBoolean(parts[3].trim()));
            }
            return cp;
        } else {
            System.out.println("Invalid record format for CustomerProduct: " + line);
            return null;
        }
    }
    @Override
    public void insertRecord(CustomerProduct record) {
        if (!contains(record.getSearchKey())) {
            records.add(record);
        } else {
            System.out.println("CustomerProduct ID " + record.getSearchKey() + " already exists in the database");
        }
    }
}
