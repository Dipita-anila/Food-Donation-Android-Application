package com.example.zerowaste;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class AdminDashBoard extends AppCompatActivity  {
    public CardView admnNGOListButton,admnftevntbtn,admnaboutusbtn,admnevntchkbtn,notificationbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dash_board);

        admnNGOListButton = (CardView) findViewById(R.id.admnNGOListButton);
        admnftevntbtn=(CardView)findViewById(R.id.admnftevntbtn);
        admnaboutusbtn=(CardView)findViewById(R.id.admnaboutusbtn);
        admnevntchkbtn=(CardView)findViewById(R.id.admnevntchkbtn);
        notificationbtn=(CardView)findViewById(R.id.notificationbtn);
        admnNGOListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminDashBoard.this,NGO_List.class);
                startActivity(intent);
            }
        });
        admnftevntbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminDashBoard.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        admnaboutusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminDashBoard.this,AboutUs.class);
                startActivity(intent);
            }
        });
        admnevntchkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminDashBoard.this,OrganizingEvent.class);
                startActivity(intent);
            }
        });

        notificationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminDashBoard.this,AdmnNotfictnofDonnrs.class);
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
            Toast.makeText(AdminDashBoard.this,"Setting is selected",Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.switchacntId)
        {
            Intent intent=new Intent(AdminDashBoard.this,DashBoard.class);
            startActivity(intent);

        }
        else if(item.getItemId()==R.id.feedbackId)
        {
            Toast.makeText(AdminDashBoard.this,"Feed Back is selected",Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.logoutId)
        {
            Toast.makeText(AdminDashBoard.this,"Logout is selected", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);


    }



}