package com.example.zerowaste;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class DashBoard extends AppCompatActivity  {
    public CardView NGOListButton,ftevntbtn,aboutusbtn,evntchkbtn,donatebtn,notificationbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        NGOListButton = (CardView) findViewById(R.id.NGOListButton);
        ftevntbtn=(CardView)findViewById(R.id.ftevntcardviewId);
        aboutusbtn=(CardView)findViewById(R.id.aboutusbtn);
      //  evntchkbtn=(CardView)findViewById(R.id.evntchkbtn);
        donatebtn=(CardView)findViewById(R.id.donatebtn);
        notificationbtn=(CardView)findViewById(R.id.notificationbtn);


        NGOListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashBoard.this,NGO_List.class);
                startActivity(intent);
            }
        });
        ftevntbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashBoard.this,DetailsActivity.class);
                startActivity(intent);
            }
        });

        donatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashBoard.this,DonationForm.class);
                startActivity(intent);
            }
        });

        aboutusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(DashBoard.this,AboutUs.class);
                startActivity(intent);


            }
        });

        notificationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashBoard.this,Donnar_Notification.class);
                startActivity(intent);
            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.dashboardmenu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.settingId)
        {
            Toast.makeText(DashBoard.this,"Setting is selected",Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.switchacntId)
        {
            Intent intent=new Intent(DashBoard.this,AdminDashBoard.class);
            startActivity(intent);

        }
        else if(item.getItemId()==R.id.feedbackId)
        {
            Toast.makeText(DashBoard.this,"Feed Back is selected",Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.logoutId)
        {

           // Toast.makeText(DashBoard.this,"Logout is selected",Toast.LENGTH_SHORT).show();
            Toast.makeText(DashBoard.this,"Logout is selected",Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builder=new AlertDialog.Builder(DashBoard.this);
            builder.setMessage("Do you Want to Exit?");
            builder.setCancelable(true);

            builder.setNegativeButton("YES",new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog,int which)
                {
                    finish();
                }
            });

            builder.setPositiveButton("NO",new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialog, int which){
                    dialog.cancel();
                }
            });

            AlertDialog alertDialog=builder.create();
            alertDialog.show();

        }



        return super.onOptionsItemSelected(item);
    }

}