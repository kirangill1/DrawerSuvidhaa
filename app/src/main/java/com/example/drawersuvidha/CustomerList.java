package com.example.drawersuvidha;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

public class CustomerList extends AppCompatActivity {
ListView listView;
SQLiteDatabase sqLiteDatabase;
UserDbHelper userDbHelper;
Cursor cursor;
CustomerDataAdapter customerDataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);

        listView=(ListView) findViewById(R.id.list_view);
        customerDataAdapter = new CustomerDataAdapter(getApplicationContext(),R.layout.activity_customer_row);
        listView.setAdapter(customerDataAdapter);
        userDbHelper=new UserDbHelper(getApplicationContext());
        sqLiteDatabase=userDbHelper.getReadableDatabase();
        cursor=userDbHelper.getinformations(sqLiteDatabase);
        if(cursor!=null && cursor.getCount() > 0)
        {
                if(cursor.moveToFirst()){
            do {
                String customer_name, email, customer_address,aadhar,application_number,pan,bank_name,bank_account,ifsc,amount,payment_details,ref1_name,ref1_contact,ref1_email,ref2_name,ref2_contact,ref2_email;
                customer_name=cursor.getString(0);
                email=cursor.getString(1);
                customer_address=cursor.getString(2);
                aadhar=cursor.getString(3);
              application_number=cursor.getString(4);
                pan=cursor.getString(5);
                bank_name=cursor.getString(6);
                bank_account=cursor.getString(7);
                ifsc=cursor.getString(8);
                amount=cursor.getString(9);
                payment_details=cursor.getString(10);
                ref1_name=cursor.getString(11);
                ref1_contact=cursor.getString(12);
                ref1_email=cursor.getString(13);
                ref2_name=cursor.getString(14);
                ref2_contact=cursor.getString(15);
                ref2_email=cursor.getString(16);
                CustomerDataProvider customerDataProvider =new CustomerDataProvider(customer_name,email,customer_address,aadhar ,application_number,pan,bank_name,bank_account,ifsc,amount,payment_details,ref1_name,ref1_contact,ref1_email,ref2_name,ref2_contact,ref2_email);
                customerDataAdapter.add(customerDataProvider);

            }while (cursor.moveToNext());
            }
    }
}}
