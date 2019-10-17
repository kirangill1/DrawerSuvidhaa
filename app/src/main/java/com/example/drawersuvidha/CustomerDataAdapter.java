package com.example.drawersuvidha;

import android.content.Context;
import android.icu.util.ValueIterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomerDataAdapter extends ArrayAdapter {
    List list= new ArrayList();

    public CustomerDataAdapter( Context context, int resource) {
        super(context, resource);
    }

  static class LayoutHandler{
        TextView NAME, EMAIL, ADDRESS, AADHAR;

    }
    @Override
    public void add( Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public Object getItem(int position) {
        return list.get(position);
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View row= convertView;
        LayoutHandler layoutHandler;
        if(row==null){
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.activity_customer_row,parent,false);
            layoutHandler =new LayoutHandler();
            layoutHandler.NAME = (TextView)row.findViewById(R.id.text_customer_name);
            layoutHandler.EMAIL=(TextView)row.findViewById(R.id.text_customer_email);
            layoutHandler.ADDRESS=(TextView)row.findViewById(R.id.text_customer_address);
            layoutHandler.AADHAR=(TextView)row.findViewById(R.id.text_customer_aadhar);
            row.setTag(layoutHandler);

        }
        else {
            layoutHandler=(LayoutHandler)row.getTag();
        }
        CustomerDataProvider customerDataProvider=(CustomerDataProvider)this.getItem(position);
         layoutHandler.NAME.setText(customerDataProvider.getCustomers_name());
         layoutHandler.EMAIL.setText(customerDataProvider.getEmail());
         layoutHandler.ADDRESS.setText(customerDataProvider.getCustomers_address());
         layoutHandler.AADHAR.setText(customerDataProvider.getAadhar());

        return row;
    }
}
