package com.example.drawersuvidha;

import android.content.Context;
import android.icu.util.ValueIterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
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
        TextView NAME, EMAIL, ADDRESS, AADHAR, APPLICATION_NUMBER, PAN_NUMBER, BANK_NAME, BANK_ACCOUNT, IFSC_CODE, AMOUNT , PAYMENT_DETAIL , REF_NAME, REF_NUMBER, REF_EMAIL, REFF_NAME, REFF_NUMBER, REFF_EMAIL ;
        //ImageView ADD_PHOTO, ADD_ADHAAR, ADD_PANCARD, ADD_PTPFORM;
        //RadioButton DD , CHEQUE, ESC_YES, ESC_NO, PTP_YES, PTP_NO;

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
           // layoutHandler.ADD_PHOTO=(ImageView)row.findViewById(R.id.image_add_photo);
            layoutHandler.APPLICATION_NUMBER=(TextView)row.findViewById(R.id.text_application_number);
            //layoutHandler.ADD_AADHAR=(ImageView) row.findViewById(R.id.image_aadhar_card);
            layoutHandler.PAN_NUMBER=(TextView)row.findViewById(R.id.text_pan);
            //layoutHandler.ADD_PANCARD=(ImageView) row.findViewById(R.id.image_pan_card);
            layoutHandler.BANK_NAME=(TextView)row.findViewById(R.id.text_bank_name);
            layoutHandler.BANK_ACCOUNT=(TextView)row.findViewById(R.id.text_bank_account);
           layoutHandler.IFSC_CODE=(TextView)row.findViewById(R.id.text_ifsc);
            //layoutHandler.DD=(RadioButton) row.findViewById(R.id.dd);
            //layoutHandler.CHEQUE=(RadioButton) row.findViewById(R.id.cheque);
           // layoutHandler.ESC_YES=(RadioButton) row.findViewById(R.id.yes);
            //layoutHandler.ESC_NO=(RadioButton) row.findViewById(R.id.no);
            layoutHandler.AMOUNT = (TextView)row.findViewById(R.id.text_amount);
            layoutHandler.PAYMENT_DETAIL=(TextView)row.findViewById(R.id.text_payment_details);
            layoutHandler.REF_NAME=(TextView)row.findViewById(R.id.text_ref1_name);
            layoutHandler.REF_NUMBER=(TextView)row.findViewById(R.id.text_ref1_contact);
            layoutHandler.REF_EMAIL = (TextView)row.findViewById(R.id.text_ref1_email);
            layoutHandler.REFF_NAME=(TextView)row.findViewById(R.id.text_ref2_name);
            layoutHandler.REFF_NUMBER=(TextView)row.findViewById(R.id.text_ref2_contact);
            layoutHandler.REFF_EMAIL = (TextView)row.findViewById(R.id.text_ref2_email);
            //layoutHandler.PTP_YES=(RadioButton) row.findViewById(R.id.yess);
           // layoutHandler.PTP_NO=(RadioButton) row.findViewById(R.id.noo);
           // layoutHandler.ADD_PTPFORM=(ImageView) row.findViewById(R.id.image_ptp_form);
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
        layoutHandler.APPLICATION_NUMBER.setText(customerDataProvider.getApplication_number());
        layoutHandler.PAN_NUMBER.setText(customerDataProvider.getPan());
        layoutHandler.BANK_NAME.setText(customerDataProvider.getBank_name());
        layoutHandler.BANK_ACCOUNT.setText(customerDataProvider.getBank_account());
        layoutHandler.IFSC_CODE.setText(customerDataProvider.getIfsc());
        layoutHandler.AMOUNT.setText(customerDataProvider.getAmount());
        layoutHandler.PAYMENT_DETAIL.setText(customerDataProvider.getPayment_details());
        layoutHandler.REF_NAME.setText(customerDataProvider.getRef1_name());
        layoutHandler.REF_NUMBER.setText(customerDataProvider.getRef1_contact());
        layoutHandler.REF_EMAIL.setText(customerDataProvider.getRef1_email());
        layoutHandler.REFF_NAME.setText(customerDataProvider.getRef2_name());
        layoutHandler.REFF_NUMBER.setText(customerDataProvider.getRef2_contact());
        layoutHandler.REFF_EMAIL.setText(customerDataProvider.getRef2_email());

        return row;
    }
}
