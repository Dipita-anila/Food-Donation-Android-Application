package com.example.zerowaste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register_one extends AppCompatActivity {


    EditText regname, regmail,regnum,regpass;
    TextView regbtn;
    DatabaseReference databaseReference3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_one);

        regname=(EditText)findViewById(R.id.regnameid);
        regmail=(EditText)findViewById(R.id.regmailid);
        regnum=(EditText)findViewById(R.id.regnumberid);
        regpass=(EditText)findViewById(R.id.regpasswrdid);
        regbtn=(TextView)findViewById(R.id.regbtnid);

        databaseReference3= FirebaseDatabase.getInstance().getReference("Registration->");


        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registeration();
            }
        });



    }


    public  void Registeration()
    {
         String regstrdname=regname.getText().toString().trim();
         String regstrdmail=regmail.getText().toString().trim();
         String regstrdnum=regnum.getText().toString().trim();
         String regstrdpass=regpass.getText().toString().trim();

         String regkey="1st_user";

         Registration_Data_handling registration_data_handling=new Registration_Data_handling(regstrdname,regstrdmail,regstrdnum,regstrdpass);
         databaseReference3.child(regkey).setValue(registration_data_handling);
        Toast.makeText(getApplicationContext(),"Your Registration is Completed!!",Toast.LENGTH_SHORT).show();
        Intent intent;
        intent=new Intent(register_one.this,Login.class); // here we willl check the credentials with the database and allow login
        startActivity(intent);



    }
}