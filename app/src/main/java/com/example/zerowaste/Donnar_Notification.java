package com.example.zerowaste;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Donnar_Notification extends AppCompatActivity {


    private ListView DN_listview;
    DatabaseReference databaseReference;
    List<adm_msg_datahandle> msg_frm_admin;
    Donnar_nf_adapter donnar_nf_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donnar_notification);


        databaseReference= FirebaseDatabase.getInstance().getReference("Message_Exchange:");

        msg_frm_admin=new ArrayList<>();
        donnar_nf_adapter=new Donnar_nf_adapter(Donnar_Notification.this,msg_frm_admin);
        DN_listview=(ListView)findViewById(R.id.donr_N_lvid);


    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot2: snapshot.getChildren())
                {
                    adm_msg_datahandle received_msg=dataSnapshot2.getValue(adm_msg_datahandle.class);
                    msg_frm_admin.add(received_msg);

                }
                DN_listview.setAdapter(donnar_nf_adapter);

            }

            @Override
            public void onCancelled( DatabaseError error) {

            }
        });



        super.onStart();
    }
}