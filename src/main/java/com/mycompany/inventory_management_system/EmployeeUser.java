/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inventory_management_system;

/**
 *
 * @author Mohamed Walaa
 */

public class EmployeeUser implements Info {

    private String employeeId;
    private String Name;
    private String Email;
    private String Address;
    private String PhoneNumber;

    // Constructor
    public EmployeeUser(String employeeId, String Name, String Email, String Address, String PhoneNumber) {
        this.employeeId = employeeId;
        this.Name = Name;
        this.Email = Email;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
    }

    // Setters
    public void setEmployeeId(String employeeId) {
        try{
            int id = Integer.parseInt(employeeId);
            if (id <= 0)
                System.out.println("Employee ID must be positive.");
            else
                this.employeeId = employeeId;
        } catch(NumberFormatException e){
            System.out.println("Warning: Employee ID must be a number.");
        }
    }

    public void setName(String Name) {
        boolean hasNumber = false;
        for(int i = 0; i < Name.length(); i++){
            if(Character.isDigit(Name.charAt(i))) {
                hasNumber = true;
                break;
            }
        }

        if (Name.equals(""))
            System.out.println("Name cannot be empty.");
        else if (hasNumber)
            System.out.println("Name cannot have numbers.");
        else
            this.Name = Name;
        
    }

    public void setEmail(String Email) {
        if(Email == null || !Email.contains("@")) {
        System.out.println("Invalid email.");
        return;
    }

    int atIndex = Email.indexOf("@");
    
    if(atIndex == 0){
        System.out.println("Invalid email: nothing before '@'.");
        return;
    }

    String afterAt = Email.substring(atIndex + 1);
    if(!afterAt.contains(".")){
        System.out.println("Invalid email: must contain a dot after '@'.");
        return;
    }

    this.Email = Email;
    }

    public void setAddress(String Address) {
        if(Address.equals(""))
            System.out.println("Address cannot be empty.");
        else
            this.Address = Address;
       
    }

    public void setPhoneNumber(String PhoneNumber) {
        boolean allDigits = true;
        int i;
        for(i = 0; i < PhoneNumber.length(); i++)
            if (!Character.isDigit(PhoneNumber.charAt(i))){
                allDigits = false;
                break;
            }
       

        if(!allDigits)
            System.out.println("Phone number must have only digits.");
        else
            this.PhoneNumber = PhoneNumber;
       
    }
    

    // Getters
    public String getEmployeeId() {
        return this.employeeId;
    }

    public String getName() {
        return this.Name;
    }

    public String getEmail() {
        return this.Email;
    }

    public String getAddress() {
        return this.Address;
    }

    public String getPhoneNumber() {
        return this.PhoneNumber;
    }

    // Methods
    @Override
    public String lineRepresentation() {
        return this.employeeId + "," + this.Name + "," + this.Email + "," + this.Address + "," + this.PhoneNumber;
    }

    @Override
    public String getSearchKey() {
        return this.employeeId;
    }
}
