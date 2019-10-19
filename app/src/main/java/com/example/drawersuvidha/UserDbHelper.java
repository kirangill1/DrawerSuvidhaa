package com.example.drawersuvidha;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class UserDbHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME="userinfo.db";
    private final static int DATABASE_VERSION=1;
    private final static String CREATE_QUERY=
            "CREATE TABLE "+ UserContract.NewUserInfo.TABLE_NAME+"(" + UserContract.NewUserInfo.
    COLUMN_NAME +
                    " VARCHAR, " + UserContract.NewUserInfo.COLUMN_EMAIL +
                    " VARCHAR, " + UserContract.NewUserInfo.COLUMN_ADDRESS +
            " VARCHAR, " + UserContract.NewUserInfo.COLUMN_AADHAR +

                   " VARCHAR, " + UserContract.NewUserInfo.COLUMN_APPLICATION_NUMBER +
            " VARCHAR, " + UserContract.NewUserInfo.COLUMN_PAN +

            " VARCHAR, " + UserContract.NewUserInfo.COLUMN_BNAME +
            " VARCHAR, " + UserContract.NewUserInfo.COLUMN_BACCOUNT +
            " VARCHAR, " + UserContract.NewUserInfo.COLUMN_IFSC +
            /*" VARCHAR, " + UserContract.NewUserInfo.COLUMN_DD +
                    " VARCHAR, " + UserContract.NewUserInfo.COLUMN_CHEQUE +*/

                    " VARCHAR, " + UserContract.NewUserInfo.COLUMN_AMOUNT +
            " VARCHAR, " + UserContract.NewUserInfo.COLUMN_PAYMENTDETAILS +
            " VARCHAR, " + UserContract.NewUserInfo.COLUMN_REF1NAME +
            " VARCHAR, " + UserContract.NewUserInfo.COLUMN_REF1EMAIL +
            " VARCHAR, " + UserContract.NewUserInfo.COLUMN_REF1CONTACT +
            " VARCHAR, " + UserContract.NewUserInfo.COLUMN_REF2NAME +
            " VARCHAR, " + UserContract.NewUserInfo.COLUMN_REF2EMAIL +
            " VARCHAR, " + UserContract.NewUserInfo.COLUMN_REF2CONTACT +
            /*" VARCHAR, " + UserContract.NewUserInfo.COLUMN_PTPFORM +*/

            " VARCHAR);";


    public UserDbHelper(Context context){
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
    Log.e("DATABASE OPERATIONS", "Database created / opened");

}
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS", "Table created ....");


    }
    public void addinformations(String customers_name, String email, String customers_address, String aadhar, String pan, String application_number,
                                String bank_name, String bank_account, String ifsc, String amount,
                                String payment_details, String ref1_name, String ref1_email, String ref1_contact, String ref2_name,
                                String ref2_email,String ref2_contact, SQLiteDatabase sqLiteDatabase)
    {
        ContentValues contentValues= new ContentValues();
        contentValues.put(UserContract.NewUserInfo.COLUMN_NAME,customers_name);
        contentValues.put(UserContract.NewUserInfo.COLUMN_EMAIL,email);
        contentValues.put(UserContract.NewUserInfo.COLUMN_ADDRESS,customers_address);
        contentValues.put(UserContract.NewUserInfo.COLUMN_AADHAR,aadhar);
        contentValues.put(UserContract.NewUserInfo.COLUMN_APPLICATION_NUMBER,application_number);
        contentValues.put(UserContract.NewUserInfo.COLUMN_PAN,pan);
        contentValues.put(UserContract.NewUserInfo.COLUMN_BNAME,bank_name);
        contentValues.put(UserContract.NewUserInfo.COLUMN_BACCOUNT,bank_account);
        contentValues.put(UserContract.NewUserInfo.COLUMN_IFSC,ifsc);
       /* contentValues.put(UserContract.NewUserInfo.COLUMN_DD,dd_rb);
        contentValues.put(UserContract.NewUserInfo.COLUMN_CHEQUE,cheque_rb);
*/
        contentValues.put(UserContract.NewUserInfo.COLUMN_AMOUNT,amount);
        contentValues.put(UserContract.NewUserInfo.COLUMN_PAYMENTDETAILS,payment_details);
        contentValues.put(UserContract.NewUserInfo.COLUMN_REF1NAME,ref1_name);
        contentValues.put(UserContract.NewUserInfo.COLUMN_REF1EMAIL,ref1_email);
        contentValues.put(UserContract.NewUserInfo.COLUMN_REF1CONTACT,ref1_contact);
        contentValues.put(UserContract.NewUserInfo.COLUMN_REF2NAME,ref2_name);
        contentValues.put(UserContract.NewUserInfo.COLUMN_REF2EMAIL,ref2_email);
        contentValues.put(UserContract.NewUserInfo.COLUMN_REF2CONTACT,ref2_contact);
         sqLiteDatabase.insert(UserContract.NewUserInfo.TABLE_NAME, null,contentValues);
        Log.e("DATABASE OPERATIONS", "one row inserted ....");
    }
    public Cursor getinformations(SQLiteDatabase sqLiteDatabase){
        Cursor cursor;
        String[] projections = {UserContract.NewUserInfo.COLUMN_NAME, UserContract.NewUserInfo.COLUMN_EMAIL, UserContract.NewUserInfo.COLUMN_ADDRESS, UserContract.NewUserInfo.COLUMN_AADHAR,
                UserContract.NewUserInfo.COLUMN_APPLICATION_NUMBER, UserContract.NewUserInfo.COLUMN_PAN, UserContract.NewUserInfo.COLUMN_BNAME, UserContract.NewUserInfo.COLUMN_BACCOUNT,
                UserContract.NewUserInfo.COLUMN_IFSC, UserContract.NewUserInfo.COLUMN_AMOUNT, UserContract.NewUserInfo.COLUMN_PAYMENTDETAILS, UserContract.NewUserInfo.COLUMN_REF1CONTACT,
                UserContract.NewUserInfo.COLUMN_REF1CONTACT, UserContract.NewUserInfo.COLUMN_REF1EMAIL, UserContract.NewUserInfo.COLUMN_REF2NAME, UserContract.NewUserInfo.COLUMN_REF2CONTACT,
                UserContract.NewUserInfo.COLUMN_REF2EMAIL};
        cursor=sqLiteDatabase.query(UserContract.NewUserInfo.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
