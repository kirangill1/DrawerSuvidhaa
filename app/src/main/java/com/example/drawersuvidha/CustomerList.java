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
        if(cursor.moveToFirst()){
            do {
                String customer_name, email, customer_address,aadhar;
                customer_name=cursor.getString(0);
                email=cursor.getString(1);
                customer_address=cursor.getString(2);
                aadhar=cursor.getString(3);
                CustomerDataProvider customerDataProvider =new CustomerDataProvider(customer_name,email,customer_address,aadhar);
                customerDataAdapter.add(customerDataProvider);

            }while (cursor.moveToNext());
            }
    }
}
