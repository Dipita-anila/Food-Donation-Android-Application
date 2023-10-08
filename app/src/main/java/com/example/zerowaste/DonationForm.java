package com.example.zerowaste;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DonationForm extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence>adapter;
    EditText user,mail,foodtype,location,cookingtime,quantity;
    TextView submitbtn;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_form);


        databaseReference= FirebaseDatabase.getInstance().getReference("Users'_Donation->");

        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        user=(EditText)findViewById(R.id.usrid);
        mail=(EditText)findViewById(R.id.usrmilid);
        location=(EditText)findViewById(R.id.lctionid);
        foodtype=(EditText)findViewById(R.id.foodtypeid);
        cookingtime=(EditText)findViewById(R.id.cokingdteid);
        quantity=(EditText)findViewById(R.id.qntityid);
        submitbtn=(TextView)findViewById(R.id.submitbtnid);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passData();
            }
        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getBaseContext(),adapterView.getItemIdAtPosition(i) + "Selected",Toast.LENGTH_LONG);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void passData()
    {
        String dkey=databaseReference.push().getKey();
        String uname=user.getText().toString().trim();
        String umail=mail.getText().toString().trim();
        String ufoodtype= String.valueOf(foodtype.getText());

        String ulocation= String.valueOf(location.getText());
        String utime= String.valueOf(cookingtime.getText());
        String uquantity= String.valueOf(quantity.getText());
        DonationDataReceive donationDataReceive=new DonationDataReceive(uname,umail,ufoodtype,ulocation,utime,uquantity);
        databaseReference.child(dkey).setValue(donationDataReceive);
        Toast.makeText(DonationForm.this,"Sended to the organization",Toast.LENGTH_LONG).show();

    }
}