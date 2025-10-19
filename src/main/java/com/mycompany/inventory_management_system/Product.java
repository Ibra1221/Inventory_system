/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory_management_system;

/**
 *
 * @author YoussefHisham
 */
public class Product implements Info {

    private String productID;
    private String productName;
    private String manufacturerName;
    private String supplierName;
    private int quantity;
    private float price;

    public Product(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) {
        setProductId(productID);
        setProductName(productName);
        setManufacturerName(manufacturerName);
        setSupplierName(supplierName);
        setQuantity(quantity);
        setPrice(price);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            System.out.println("Invalid quantity. It cannot be negative.");
        } else {
            this.quantity = quantity;
        }
    }

    @Override
    public String lineRepresentation() {
        return productID + "," + productName + "," + manufacturerName + "," + supplierName + "," + quantity + "," + price;
    }

    @Override
    public String getSearchKey() {
        return productID;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public float getPrice() {
        return price;
    }
    public  void setPrice(float price){
        if(price<0){
            System.out.println("Invalid price");
        }
        else{
            this.price=price;
        }
    }
    public void setProductId(String productId){
        this.productID=productId;
    }
    public void setProductName(String productName){
        if(productName== null || productName.trim().isEmpty()){
            System.out.println("Invalid productName");
        }
        else{
            this.productName=productName;
        }
    }
    public void setManufacturerName(String manufacturerName){
        if(manufacturerName== null || manufacturerName.trim().isEmpty()){
            System.out.println("Invalid manufacturerName");
        }
        else{
            this.manufacturerName=manufacturerName;
        }
    }
    public void setSupplierName(String SupplierName){
        if(SupplierName== null || SupplierName.trim().isEmpty()){
            System.out.println("Invalid SupplierName");
        }
        else{
            this.supplierName=supplierName;
        }
    }
    
    
    

}
