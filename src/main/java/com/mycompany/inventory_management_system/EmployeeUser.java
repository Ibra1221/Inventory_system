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
        this.employeeId = employeeId;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setPhoneNumber(String PhoneNumber) {
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

