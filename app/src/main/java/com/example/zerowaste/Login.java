package com.example.zerowaste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Login extends AppCompatActivity {

    public CardView RegisterButton;
    public TextView loginbtn;
    EditText passswrd;
    String credentialpass;
    FirebaseDatabase DB;
    DatabaseReference databaseReference4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login);

        RegisterButton = (CardView)findViewById(R.id.RegisterButton);
        loginbtn=(TextView)findViewById(R.id.loginbtn);
        passswrd=(EditText)findViewById(R.id.logpassid);
         DB=FirebaseDatabase.getInstance();
        databaseReference4=DB.getReference().child("Registration->").child("1st_user");



        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               checkingauthentication();
            }
        });
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent=new Intent(Login.this,register_one.class);
                startActivity(intent);


            }
        });
    }


    public void checkingauthentication()
    {
        credentialpass=passswrd.getText().toString();
        databaseReference4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
                String dbcredentialpass=snapshot.child("registrdPasswrd").getValue().toString();
                //Toast.makeText(getApplicationContext(),dbcredentialpass,Toast.LENGTH_SHORT).show();
                if(credentialpass.equals(dbcredentialpass))
                {
                   // Toast.makeText(getApplicationContext(),"matched",Toast.LENGTH_SHORT).show();
                    Intent intent;
                    intent=new Intent(Login.this,DashBoard.class); // here we willl check the credentials with the database and allow login
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Wrong Password!",Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onCancelled( DatabaseError error) {

            }
        });




    }



}