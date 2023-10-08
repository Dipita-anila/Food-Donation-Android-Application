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

public class DetailsActivity extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;
    private List<EvntDataHandling> EvntdataList;
    private EvntDetailAdapter evntdetailadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        databaseReference= FirebaseDatabase.getInstance().getReference("Future_Events->");
        EvntdataList=new ArrayList<>();
        evntdetailadapter=new EvntDetailAdapter(DetailsActivity.this,EvntdataList);

        listView=(ListView)findViewById(R.id.evntdetailId);
    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {

                EvntdataList.clear();

                for(DataSnapshot dataSnapshot1:snapshot.getChildren()){

                    EvntDataHandling evnt=dataSnapshot1.getValue(EvntDataHandling.class);
                    EvntdataList.add(evnt);
                }
                listView.setAdapter(evntdetailadapter);

            }

            @Override
            public void onCancelled( DatabaseError error) {

            }
        });

        super.onStart();
    }
}