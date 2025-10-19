/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inventory_management_system;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Mohamed Walaa
 */
public class Inventory_management_system {
    
    
    public static String validateID(Scanner scan) {
        String id;
        do {
            System.out.print("Enter ID: ");
            id = scan.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("ID cannot be empty! Please try again.");
            } else {
                break;
            }
        } while (true);
        return id;
    }

    
    
    
    
    public static String validateEmail(Scanner scan){
        String email;
        System.out.println("Enter employee email:");
                    boolean validEmail = false;
                    do{
                        System.out.print("Enter employee email: ");
                        email = scan.nextLine();

                        if(email.contains("@")){
                            int atIndex = email.indexOf("@");
                            String afterAt = email.substring(atIndex + 1);
                            if(atIndex > 0 && afterAt.contains(".")) {
                                validEmail = true;
                            }else
                                System.out.println("Invalid email format! Please try again.");
                        } else 
                            System.out.println("Email must contain '@'! Please try again.");

                    } while (!validEmail);
                    return email;
    }
    
    
    
    
    
    public static String validateName(Scanner scan){
        String name;
        System.out.println("Enter employee name:");
                    boolean validName = false;
                    do {
                        System.out.print("Enter employee name: ");
                        name = scan.nextLine();
                        validName = true;

                        if(name.isEmpty()){
                            System.out.println("Name cannot be empty! Please try again.");
                            validName = false;
                        } else {
                            for(int i = 0; i < name.length(); i++) {
                                if (Character.isDigit(name.charAt(i))) {
                                    System.out.println("Name cannot contain numbers! Please try again.");
                                    validName = false;
                                    break;
                                }
                            }
                        }

                    }while(!validName);
                    return name;
    }
    
    
    
    
    public static String validateAddress(Scanner scan){
        String address;
        System.out.println("Enter employee address:");
                    do {
                        System.out.print("Enter employee address: ");
                        address = scan.nextLine();
                        if (address.isEmpty()) {
                            System.out.println("Address cannot be empty! Please try again.");
                        }
                    }while(address.isEmpty());
                    return address;
    }
    
    
    
    
    public static String validatePhoneNumber(Scanner scan){
        String phone;
        System.out.println("Enter employee phone number");
                    boolean validPhone ;
                    do{
                        System.out.print("Enter employee phone number: ");
                        phone = scan.nextLine();
                        validPhone = true;

                        if(phone.isEmpty()){
                            System.out.println("Phone number cannot be empty! Please try again.");
                            validPhone = false;
                        }else{
                            for(int i = 0; i < phone.length(); i++) {
                                if(!Character.isDigit(phone.charAt(i))) {
                                    System.out.println("Phone number must contain only digits! Please try again.");
                                    validPhone = false;
                                    break;
                                }
                            }
                        }
                        
    }while(!validPhone);
                    return phone;
    
                    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    
    public static void main(String[] args) {
        System.out.println("--Inventory Management System--");
        System.out.println("1. Admin");
        System.out.println("2. Employee");
        System.out.println("3. Exit");
        System.out.println("Choose 1 or 2 or 3");
        
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        scan.nextLine();
        
        
        
        if(choice == 1){
            System.out.println("\n\n--Admin--");
            AdminRole admin = new AdminRole();
            System.out.println("1. Add new employee");
            System.out.println("2. Remove Existing employee");
            System.out.println("3. Get list of employees");
            System.out.println("4. Logout");
            choice = scan.nextInt();
            scan.nextLine();
            switch(choice){
                case 1:{
                    String id = validateID(scan);
                    String name = validateName(scan);
                    String email = validateEmail(scan);
                    String address = validateAddress(scan);
                    String phone = validatePhoneNumber(scan);
                    EmployeeUser employee = new EmployeeUser(id, name, email,address, phone);
                    admin.addEmployee(id, name, email,address, phone);
                    System.out.println("Employee Data: " + employee.lineRepresentation());
                    break;
                }
                case 2:
                    String id = validateID(scan);
                    admin.removeEmployee(id);
                    break;
                case 3:
                    System.out.println("The list of employees is: " + admin.getListOfEmployees());
                    break;
                case 4:
                    admin.logout();
            }
                
           
                
        
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        }else if(choice == 2){
                System.out.println("\n\n--Employee--");
                System.out.println("1. Add product");
                System.out.println("2. Get list of products");
                System.out.println("3. Get list of purchasing operations");
                System.out.println("4. Purchase product");
                System.out.println("5. Return product");
                System.out.println("6. Apply payment");
                System.out.println("7. Logout");
                
                System.out.println("Choose 1 -> 7");

                int subchoice = scan.nextInt();
        
                switch(subchoice){
                    case 1:
                        System.out.println("\n--- Add Product ---");
                        System.out.println("\n\nAdding new Product:");

                        String pid, pname, mname, sname;
                        int pquantity = 0;
                        float pprice = 0.0f;
///////////////////////////////

                        System.out.println("Enter product id:");
                        pid = validateID(scan);


                        do {
                            System.out.println("Enter product name:");
                            pname = scan.nextLine();
                            if (pname == null || pname.trim().isEmpty())
                                System.out.println("Invalid product name! Please try again.");
                            else
                                break;
                        } while (true);
                      

                        do {
                            System.out.println("Enter manufacturer name:");
                            mname = scan.nextLine();
                            if (mname == null || mname.trim().isEmpty())
                                System.out.println("Invalid manufacturer name! Please try again.");
                            else
                                break;
                        } while (true);

                        
                        do {
                            System.out.println("Enter supplier name:");
                            sname = scan.nextLine();
                            if (sname == null || sname.trim().isEmpty())
                                System.out.println("Invalid supplier name! Please try again.");
                            else
                                break;
                        } while (true);


                        
                        int num = 0;
                        do{
                        try {
                            System.out.println("Enter quantity:");
                            pquantity = scan.nextInt();
                            num = pquantity;
                            if (num <= 0)
                                System.out.println("Product quantity must be positive! Please try again.");

                        } catch (NumberFormatException e) {
                            System.out.println("Product quantity must be a number! Please try again.");
                            num = 0;
                        }

                    }while(num<=0);
                    scan.nextLine();


                        float num2;
                        do{
                        try {
                            System.out.println("Enter price:");
                            pprice = scan.nextFloat();
                            num2 = pprice;
                            if (num2 <= 0)
                                System.out.println("Product price must be positive! Please try again.");

                        } catch (NumberFormatException e) {
                            System.out.println("Product price must be a number! Please try again.");
                            num2 = 0;
                        }

                    }while(num2<=0);




                        scan.nextLine(); //clear buffer

                        Product product = new Product(pid, pname, mname, sname, pquantity, pprice);
                        System.out.println("\nProduct added successfully!");

                        break;
/////////////////////////
      
                    case 2:
                        System.out.println("\n--- Product List ---");
                        EmployeeRole emp = new EmployeeRole();
                        Product[] products = emp.getListOfProducts();
                        for (Product p : products)
                            System.out.println(p.lineRepresentation());
                        
                        break;
                        
                    
                    case 3:
                        System.out.println("\n--- List purchasing operations ---");
                        EmployeeRole emp = new EmployeeRole();
                        CustomerProduct[] records = emp.getListOfPurchasingOperations();
                        for (CustomerProduct c : records) {
                            System.out.println(c.lineRepresentation());
                        }
                        break;
                        
                        
                        
                    case 4:
                        System.out.println("\n--- Purchase Product ---");
                        System.out.print("Enter customer SSN: ");
                        String ssn = scan.nextLine();
                        System.out.print("Enter product ID: ");
                        String prodId = scan.nextLine();
                        LocalDate date = LocalDate.now();
                        EmployeeRole.purchaseProduct(ssn, prodId, date);
                        break;
                        
                        
                        
                     case 5:
                        System.out.println("\n--- Return Product ---");
                        System.out.print("Enter customer SSN: ");
                        ssn = scan.nextLine();
                        System.out.print("Enter product ID: ");
                        prodId = scan.nextLine();
                        System.out.print("Enter purchase date (DD-MM-YYYY): ");
                        LocalDate purchaseDate = LocalDate.parse(scan.nextLine());
                        LocalDate returnDate = LocalDate.now();
                        EmployeeRole emp = new EmployeeRole();
                        emp.returnProduct(ssn, prodId, purchaseDate, returnDate);
                        break;
                        
                        
                        
                    case 6:
                        System.out.println("\n--- Apply Payment ---");
                        System.out.print("Enter customer SSN: ");
                        ssn = scan.nextLine();
                        System.out.print("Enter product ID: ");
                        prodId = scan.nextLine();
                        System.out.print("Enter purchase date (DD-MM-YYYY): ");
                        purchaseDate = LocalDate.parse(scan.nextLine());
                        EmployeeRole emp = new EmployeeRole();
                        emp.applyPayment(ssn, prodId, purchaseDate);
                        break;
                        
                        
                        
                        
                    case 7:
                        EmployeeRole emp = new EmployeeRole();
                        emp.logout();
                        System.out.println("Logged out successfully.");
                        break;
                        
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                        break;
                    
                    }
                
                
                }else if(choice == 3){
                System.out.println("Exiting system...");
                scan.close();
                System.exit(0);
                }
    }
}



