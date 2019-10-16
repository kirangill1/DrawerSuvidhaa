package com.example.drawersuvidha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AddCustomerActivity extends AppCompatActivity {
    TextView suvidha_tv, distributor_tv, ward_tv, contact_tv;
    EditText add_et, name_et, adhaar_et, pan_et, email_et, app_et;
    EditText bankname_et, bankaccount_et, ifsccode_et, amount_et, payment_et;
    EditText refer_name1, refer_contact1, refer_email1;
    EditText refer_name2, refer_contact2, refer_email2;
    RadioButton dd, cheque, yes, no, yess, noo;
    LinearLayout bank_detail;
    Context context = this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;


    public static ImageView profile_photo;
    public static ImageView adhaar_card;
    public static ImageView pan_card;
    public static ImageView ptp_image;

    public static String profile_photo_string;
    public static String adhaar_card_string;
    public static String pan_card_string;
    public static String ptp_image_string;

    private int PICK_IMAGE_REQUEST = 1;
    private int PICK_IMAGE_REQUEST1 = 2;
    private int PICK_IMAGE_REQUEST2 = 3;
    private int PICK_IMAGE_REQUEST3 = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcustomer);
        name_et = (EditText) findViewById(R.id.name_et);
        suvidha_tv = (TextView) findViewById(R.id.suvidha_center_name);
        distributor_tv = (TextView) findViewById(R.id.distributor_name);
        add_et = (EditText) findViewById(R.id.add_et);
        app_et = (EditText) findViewById(R.id.app_et);
        ward_tv = (TextView) findViewById(R.id.ward_no);
        contact_tv = (TextView) findViewById(R.id.contact_no);
        adhaar_et = (EditText) findViewById(R.id.adhaar_et);
        pan_et = (EditText) findViewById(R.id.pan_et);
        email_et = (EditText) findViewById(R.id.email_et);
        profile_photo = (ImageView) findViewById(R.id.img);
        adhaar_card = (ImageView) findViewById(R.id.adhaar);
        pan_card = (ImageView) findViewById(R.id.pan);
        ptp_image = (ImageView) findViewById(R.id.ptp_image);
        bank_detail = findViewById(R.id.bank_detail);

        bankname_et = (EditText) findViewById(R.id.bank_name);
        bankaccount_et = (EditText) findViewById(R.id.bank_account);
        ifsccode_et = (EditText) findViewById(R.id.ifsc_code);
        amount_et = (EditText) findViewById(R.id.amount);
        payment_et = (EditText) findViewById(R.id.payment);

        refer_name1 = (EditText) findViewById(R.id.refer_name1);
        refer_contact1 = (EditText) findViewById(R.id.refer_contact1);
        refer_email1 = (EditText) findViewById(R.id.refer_email1);
        refer_name2 = (EditText) findViewById(R.id.refer_name2);
        refer_contact2 = (EditText) findViewById(R.id.refer_contact2);
        refer_email2 = (EditText) findViewById(R.id.refer_email2);

        cheque = (RadioButton) findViewById(R.id.cheque);
        dd = (RadioButton) findViewById(R.id.dd);
        yes = (RadioButton) findViewById(R.id.yes);
        yess = (RadioButton) findViewById(R.id.yess);
        no = (RadioButton) findViewById(R.id.no);
        noo = (RadioButton) findViewById(R.id.noo);


        SharedPreferences sp = getSharedPreferences("user_info", MODE_PRIVATE);

        suvidha_tv.setText(sp.getString("suvidha_name", ""));
        distributor_tv.setText(sp.getString("distributor_name", ""));
        ward_tv.setText(sp.getString("ward_no", ""));
        contact_tv.setText(sp.getString("contact_no", ""));


    }

    public void add_image(View view) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_GET_CONTENT);
        i.setType("image/*");
        profile_photo.setVisibility(View.VISIBLE);
        //File file = new File(Environment.getExternalStorageDirectory(),
        //      counter+".jpg");
        //Uri photoPath = Uri.fromFile(file);
        // i.putExtra(MediaStore.EXTRA_OUTPUT, photoPath);
        startActivityForResult(i.createChooser(i, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    public void add_adhaar_card(View view) {
        Intent i = new Intent();
        adhaar_card.setVisibility(View.VISIBLE);
        i.setAction(Intent.ACTION_GET_CONTENT);
        i.setType("image/*");
        startActivityForResult(i.createChooser(i, "Select Picture"), PICK_IMAGE_REQUEST1);
    }

    public void add_pan_card(View view) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_GET_CONTENT);
        i.setType("image/*");
        pan_card.setVisibility(View.VISIBLE);
        startActivityForResult(i.createChooser(i, "Select Picture"), PICK_IMAGE_REQUEST2);
    }

    public void upload_ptp(View view) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_GET_CONTENT);
        i.setType("image/*");
        ptp_image.setVisibility(View.VISIBLE);
        //File file = new File(Environment.getExternalStorageDirectory(),
        //      counter+".jpg");
        //Uri photoPath = Uri.fromFile(file);
        // i.putExtra(MediaStore.EXTRA_OUTPUT, photoPath);
        startActivityForResult(i.createChooser(i, "Select Picture"), PICK_IMAGE_REQUEST3);
    }

    // function to convert bitmap to string
    public String getStringImage(Bitmap bmp) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public String getStringImage1(Bitmap bmp) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public String getStringImage2(Bitmap bmp) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }

    public String getStringImage3(Bitmap bmp) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE_REQUEST && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //Getting the Bitmap from Gallery
                Bitmap bitmap = decodeUri(AddCustomerActivity.this, filePath, 700);
                profile_photo_string = getStringImage(bitmap);
                //Setting the Bitmap to ImageView
                profile_photo.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE_REQUEST1 && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //Getting the Bitmap from Gallery
                Bitmap bitmap1 = decodeUri(AddCustomerActivity.this, filePath, 700);
                adhaar_card_string = getStringImage(bitmap1);
                //Setting the Bitmap to ImageView
                adhaar_card.setImageBitmap(bitmap1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE_REQUEST2 && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //Getting the Bitmap from Gallery
                Bitmap bitmap2 = decodeUri(AddCustomerActivity.this, filePath, 700);
                pan_card_string = getStringImage(bitmap2);
                //Setting the Bitmap to ImageView
                pan_card.setImageBitmap(bitmap2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE_REQUEST3 && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //Getting the Bitmap from Gallery
                Bitmap bitmap3 = decodeUri(AddCustomerActivity.this, filePath, 700);
                ptp_image_string = getStringImage(bitmap3);
                //Setting the Bitmap to ImageView
                ptp_image.setImageBitmap(bitmap3);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // function to scale down image
    public Bitmap decodeUri(Context c, Uri uri, final int requiredSize)
            throws FileNotFoundException {
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(c.getContentResolver().openInputStream(uri), null, o);

        int width_tmp = o.outWidth, height_tmp = o.outHeight;
        int scale = 1;

        while (true) {
            if (width_tmp / 2 < requiredSize || height_tmp / 2 < requiredSize)
                break;
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }

        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        return BitmapFactory.decodeStream(c.getContentResolver().openInputStream(uri), null, o2);
    }

    public void submit(View view) {

        String customers_name = name_et.getText().toString();
        String suvidha = suvidha_tv.getText().toString();
        String distributor = distributor_tv.getText().toString();
        String email = email_et.getText().toString();
        String customers_address = add_et.getText().toString();
        String application = app_et.getText().toString();
        String ward = ward_tv.getText().toString();
        String contact = contact_tv.getText().toString();
        String aadhar = adhaar_et.getText().toString();
        String pan = pan_et.getText().toString();
        String bank_name = bankname_et.getText().toString();
        String bank_account = bankaccount_et.getText().toString();
        String ifsc = ifsccode_et.getText().toString();
        String amount = amount_et.getText().toString();
        String payment_details = payment_et.getText().toString();
        String ref1_name = refer_name1.getText().toString();
        String ref1_contact = refer_contact1.getText().toString();
        String ref1_email = refer_email1.getText().toString();
        String ref2_name = refer_name2.getText().toString();
        String ref2_contact = refer_contact2.getText().toString();
        String ref2_email = refer_email2.getText().toString();

        Boolean dd_rb = dd.isChecked();
        Boolean cheque_rb = cheque.isChecked();
        Boolean yes_rb = yes.isChecked();
        Boolean no_rb = no.isChecked();

        Boolean yess_rb = yess.isChecked();
        Boolean noo_rb = noo.isChecked();



       /* if (suvidha.equals("")) {
            Toast.makeText(AddCustomerActivity.this, "enter the suvidha center name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (distributor.equals("")) {
            Toast.makeText(AddCustomerActivity.this, "enter the distributor name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (ward.equals("")) {
            Toast.makeText(AddCustomerActivity.this, "enter the ward no.", Toast.LENGTH_SHORT).show();
            return;
        }*/
        if (customers_name.equals("")) {
            Toast.makeText(AddCustomerActivity.this, "enter the name", Toast.LENGTH_SHORT).show();
            return;
        }
       /* if (contact.length() < 10) {
            Toast.makeText(AddCustomerActivity.this, "re-enter the contact no. ", Toast.LENGTH_SHORT).show();
            return;
        }*/
        if (application.equals("")) {
            Toast.makeText(AddCustomerActivity.this, "enter the application no. ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (customers_address.equals("")) {
            Toast.makeText(AddCustomerActivity.this, "enter the address", Toast.LENGTH_SHORT).show();
            return;
        }
        if (aadhar.length() < 12 || aadhar.length() > 12) {
            Toast.makeText(AddCustomerActivity.this, "please check your adhaar card no.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (pan.length() < 8 || pan.length() > 8) {
            Toast.makeText(AddCustomerActivity.this, "please check your pan card no.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(AddCustomerActivity.this, "enter valid email", Toast.LENGTH_SHORT).show();
            return;
        }


        if (bank_name.equals("")) {
            Toast.makeText(AddCustomerActivity.this, "enter the name", Toast.LENGTH_SHORT).show();
            return;
        }

        if (bank_account.length() < 15 || bank_account.length() > 15) {
            Toast.makeText(AddCustomerActivity.this, " account no should  contain  15 digits", Toast.LENGTH_SHORT).show();
            return;
        }


        if (ifsc.length() < 11 || ifsc.length() > 11) {
            Toast.makeText(AddCustomerActivity.this, " ifsc code should contain 11 digits", Toast.LENGTH_SHORT).show();
            return;
        }
        if (amount.equals("")) {
            Toast.makeText(AddCustomerActivity.this, " amount  should  be greater than 0", Toast.LENGTH_SHORT).show();
            return;
        }

        if (payment_details.equals("")) {
            Toast.makeText(AddCustomerActivity.this, "enter the payment details", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!dd_rb && !cheque_rb) {
            Toast.makeText(AddCustomerActivity.this, "select the option", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!yes_rb && !no_rb) {
            Toast.makeText(AddCustomerActivity.this, "select the option", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!yess_rb && !noo_rb) {
            Toast.makeText(AddCustomerActivity.this, "select the option ecs", Toast.LENGTH_SHORT).show();
            return;
        }
        if (ref1_name.equals("")) {
            Toast.makeText(AddCustomerActivity.this, "enter the name for first referencr", Toast.LENGTH_SHORT).show();
            return;
        }
        if (ref1_contact.length() < 10) {
            Toast.makeText(AddCustomerActivity.this, "re-enter the contact for first reference ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(ref1_email).matches()) {
            Toast.makeText(AddCustomerActivity.this, "enter valid email for first reference", Toast.LENGTH_SHORT).show();
            return;
        }

        if (ref2_name.equals("")) {
            Toast.makeText(AddCustomerActivity.this, "enter the name for second reference", Toast.LENGTH_SHORT).show();
            return;
        }
        if (ref2_contact.length() < 10) {
            Toast.makeText(AddCustomerActivity.this, "re-enter the contact for second reference ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(ref2_email).matches()) {
            Toast.makeText(AddCustomerActivity.this, "enter valid email for second reference", Toast.LENGTH_SHORT).show();
            return;
        }

        if (ref1_name.equals("") && ref1_email.equals("") && ref1_contact.equals("")) {

            Toast.makeText(AddCustomerActivity.this, "Please enter atleast one reference", Toast.LENGTH_SHORT).show();
            return;

        }
        userDbHelper = new UserDbHelper(context);
        sqLiteDatabase = userDbHelper.getWritableDatabase();
        userDbHelper.addinformations(customers_name, email, customers_address, aadhar, pan,
                bank_name, bank_account, ifsc, dd_rb, cheque_rb, amount,
                payment_details, ref1_name, ref1_email, ref1_contact, ref2_name,
                ref2_email, ref2_contact, sqLiteDatabase);
        Toast.makeText(getBaseContext(), "Data Saved", Toast.LENGTH_LONG).show();
        userDbHelper.close();


    }

    public void bank_details(View view) {
        bank_detail.setVisibility(View.VISIBLE);}

}

