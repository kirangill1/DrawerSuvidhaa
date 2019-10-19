package com.example.drawersuvidha;

public class CustomerDataProvider {
    private String customers_name;
    private  String email;
    private  String customers_address;
    private String aadhar;
   private String application_number;
    private  String pan;
    private  String bank_name;
    private String bank_account;
    private String ifsc;
    private  String amount;
    private  String payment_details;
    private String ref1_name;
    private  String ref1_contact;
    private  String ref1_email;
    private String ref2_name;
    private  String ref2_contact;
    private  String ref2_email;

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

    public void setCustomers_address(String customers_address) { this.customers_address = customers_address; }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String adhaar) { this.aadhar = aadhar; }



    public String getApplication_number() { return application_number; }

    public void setApplication_number(String application_number) { this.application_number = application_number; }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) { this.pan = pan; }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) { this.bank_name = bank_name; }

    public String getBank_account() {
        return bank_account;
    }

    public void setBank_account(String bank_account) { this.bank_account = bank_account; }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) { this.ifsc = ifsc; }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) { this.amount = amount; }


    public String getPayment_details() {
        return payment_details;
    }

    public void setPayment_details(String payment_details) {
        this.payment_details = payment_details; }


    public String getRef1_name() {
        return ref1_name;
    }

    public void setRef1_name(String ref1_name) {
        this.ref1_name = ref1_name; }


    public String getRef1_contact() {
        return ref1_contact;
    }

    public void setRef1_contact(String ref1_contact) {
        this.ref1_contact = ref1_contact; }


    public String getRef1_email() {
        return ref1_email;
    }

    public void setRef1_email(String ref1_email) {
        this.ref1_email = ref1_email; }


    public String getRef2_name() { return ref2_name; }
        public void setRef2_name(String ref2_name) {
        this.ref2_name = ref2_name; }

    public String getRef2_contact() {
        return ref2_contact;
    }

    public void setRef2_contact(String ref2_contact) {
        this.ref2_contact = ref2_contact; }


    public String getRef2_email() {
        return ref2_email;
    }

    public void setRef2_email(String ref2_name) {
        this.ref2_email = ref2_email; }

    public CustomerDataProvider(String customers_name, String email, String customers_address, String aadhar,String application_number , String pan, String bank_name, String bank_account, String ifsc, String amount, String payment_details, String ref1_name, String ref1_contact, String ref1_email, String ref2_name, String ref2_contact, String ref2_email)

        {
        this.customers_name=customers_name;
        this.email=email;
        this.customers_address=customers_address;
        this.aadhar=aadhar;
            this.application_number=application_number;
            this.pan=pan;
            this.bank_name=bank_name;
            this.bank_account=bank_account;
            this.ifsc=ifsc;
            this.amount=amount;
            this.payment_details=payment_details;
            this.ref1_name=ref1_name;
            this.ref1_email=ref1_email;
            this.ref1_contact=ref1_contact;
            this.ref2_name=ref2_name;
            this.ref2_email=ref2_email;
            this.ref2_contact=ref2_contact;
        }
}
