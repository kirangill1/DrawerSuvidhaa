package com.example.drawersuvidha;

public class CustomerDataProvider {
    private String customers_name;
    private  String email;
    private  String customers_address;
    private String aadhar;

    public String getCustomers_name() {
        return customers_name;
    }

    public void setCustomers_name(String customers_name) {
        this.customers_name = customers_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomers_address() {
        return customers_address;
    }

    public void setCustomers_address(String customers_address) {
        this.customers_address = customers_address;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public CustomerDataProvider(String customers_name, String email, String customers_address, String aadhar)

    {
        this.customers_name=customers_name;
        this.email=email;
        this.customers_address=customers_address;
        this.aadhar=aadhar;

    }
}
