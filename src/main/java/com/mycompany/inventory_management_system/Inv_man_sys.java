/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inv_man_sys;


import com.mycompany.inventory_management_system.Info; //interface
import java.util.Scanner;

/**
 *
 * @author Ahmed Walaa
 */

class EmployeeUser implements Info{
    
    private String employeeId;
    private String Name;
    private String Email;
    private String Address;
    private String PhoneNumber;
    
    // Constructor
    public EmployeeUser(String employeeId, String name, String email, String address, String phoneNumber){
        this.employeeId = employeeId;
        this.Name = name;
        this.Email = email;
        this.Address = address;
        this.PhoneNumber = phoneNumber;
    }
    
    //setters
    
    public void setEmployeeId(String employeeId){
        this.employeeId = employeeId;
    }
    
    public void setName(String Name){
        this.Name = Name;
    }
    
    public void setEmail(String Email){
        this.Email = Email;
    }
    
    public void setAddress(String Address){
        this.Address = Address;
    }
    
    public void setPhoneNumber(String PhoneNumber){
        this.PhoneNumber = PhoneNumber;
    }
    ////////////
    
    //getters
    
    public String getEmployeeId(){
        return this.employeeId;
    }
    
    public String getName(){
        return this.Name;
    }
    
    public String getEmail(){
        return this.Email;
    }
    
    public String getAddress(){
        return this.Address;
    }
    
    public String getPhoneNumber(){
        return this.PhoneNumber;
    }
    
    ////////////
    
    //methods
    
    @Override
    public String lineRepresentation(){
        String EmployeeData = this.employeeId + "," + this.Name + "," + this.Email + "," + this.Address + "," + this.PhoneNumber;
        return EmployeeData;
    }
    
    @Override
    public String getSearchKey(){
        return employeeId;
    }
}

public class Inv_man_sys {

    public static void main(String[] args) {
        System.out.println("--Inventory Management System--");
        System.out.println("1. Employee");
        System.out.println("2. Admin");
        System.out.println("3. Products");
        System.out.println("4. Exit");
        System.out.println("Choose 1 or 2 or 3 or 4");
        
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        scan.nextLine();
        
        switch(choice){
            case 1:
                System.out.println("\n\nEmployee:");
                System.out.println("Adding new Employee:");
                String id,name,email,address,phone;
                int num = 0;
                do{
                    System.out.println("Enter employee id:");
                    id = scan.nextLine();
                    num = Integer.parseInt(id);
                    if (num <= 0)
                        System.out.println("Employee id must be positive! Please try again.");
                } while(num <= 0);
                
                System.out.println("Enter employee name:");
                name = scan.nextLine();
                System.out.println("Enter employee email:");
                email = scan.nextLine();
                System.out.println("Enter employee address:");
                address = scan.nextLine();
                System.out.println("Enter employee phone number");
                phone = scan.nextLine();
                
                EmployeeUser account = new EmployeeUser(id, name, email,address, phone);
                System.out.println("\nEmployee added successfully!");
                System.out.println("Employee Data: " + account.lineRepresentation());
                break;
        }
        
        
        
        
        
        
    }
}
