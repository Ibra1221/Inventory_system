/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory_management_system;

/**
 *
 * @author Ibrahim
 */
public class AdminRole {

    private EmployeeUserDatabase database;

    public AdminRole() {
        database = new EmployeeUserDatabase("Employees.txt");   
    }

    public void addEmployee(String employeeId, String name, String email, String address, String phoneNumber) {
        EmployeeUser newUser = new EmployeeUser(employeeId, name, email, address, phoneNumber);
        System.out.println("Adding Employee to the database...");
        database.insertRecord(newUser);
        
    }
    
    public void removeEmployee(String key){
        System.out.println("Removing Employee from the database...");
        database.deleteRecord(key);
    }
    
    public EmployeeUser[] getListOfEmployees(){
        System.out.println("Fetching the list of Employees...");
        return database.records.toArray();
    }
    public void logout(){
        System.out.println("Saving...");
        database.saveToFile();
    }
}
