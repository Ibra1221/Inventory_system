/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inv_man_sys;

import java.util.Scanner;

/**
 *
 * @author Ahmed Walaa
 */
public class main {
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
                
                
            case 2:
                //Admin stuff
                //break;
                
            case 3:
                System.out.println("\n\nProduct::");
                System.out.println("Adding new Product:");
                String pid,pname,mname,sname;
                int pquantity;
                float pprice;
                int num2 = 0;
                do{
                    System.out.println("Enter product id:");
                    pid = scan.nextLine();
                    num = Integer.parseInt(pid);
                    if (num <= 0)
                        System.out.println("product id must be positive! Please try again.");
                } while(num <= 0);
                
                System.out.println("Enter product name:");
                pname = scan.nextLine();
                System.out.println("Enter manufacturer name:");
                mname = scan.nextLine();
                System.out.println("Enter supplier name:");
                sname = scan.nextLine();
                System.out.println("Enter quantity:");
                pquantity = scan.nextInt();
                System.out.println("Enter price:");
                pprice = scan.nextFloat();
                
                Product product = new Product(pid,pname,mname,sname,pquantity,pprice);
                System.out.println("\nProduct added successfully!");
                break;
                
                
            case 4:
                System.exit(0);
}




    }
