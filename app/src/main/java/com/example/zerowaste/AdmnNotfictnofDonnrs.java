package com.example.zerowaste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class AdmnNotfictnofDonnrs extends AppCompatActivity {


    private   ListView listView2;
    DatabaseReference databaseReference;
    List<DonationDataReceive> Donateddata;
    DonationDataRshowAdapter donationDataRshowAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admn_notfictnof_donnrs);
        databaseReference= FirebaseDatabase.getInstance().getReference("Users'_Donation->");
        Donateddata=new ArrayList<>();
        donationDataRshowAdapter=new DonationDataRshowAdapter(AdmnNotfictnofDonnrs.this,Donateddata);


        listView2=(ListView)findViewById(R.id.nfdonationlviewid);

    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
                Donateddata.clear();

                for(DataSnapshot dataSnapshot2:snapshot.getChildren())
                {
                    DonationDataReceive donationDataReceive=dataSnapshot2.getValue(DonationDataReceive.class);
                    Donateddata.add(donationDataReceive);

                }
                listView2.setAdapter(donationDataRshowAdapter);

                listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //Toast.makeText(AdmnNotfictnofDonnrs.this,"clicked",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(AdmnNotfictnofDonnrs.this,AdminToDonnar_msg.class);
                        startActivity(intent);
                    }
                });


            }

            @Override
            public void onCancelled(  DatabaseError error) {

            }
        });



        super.onStart();
    }
}