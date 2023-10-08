package com.example.zerowaste;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OrganizingEvent extends AppCompatActivity {

    EditText EventName,EventFor,EventDate,EventPlace;
    Button Organize;
    String evntname,evntdate,evntplace,evntfor;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizing_event);

        databaseReference= FirebaseDatabase.getInstance().getReference("Future_Events->");


        EventName=(EditText)findViewById(R.id.evntnameid);
        EventDate=(EditText)findViewById(R.id.evntdateid);
        EventPlace=(EditText)findViewById(R.id.evntplaceid);
        EventFor=(EditText)findViewById(R.id.evntforid);
        Organize=(Button)findViewById(R.id.evntorganizeid);


        Organize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedData();

            }
        });


    }

    public void savedData()
    {

        evntname=EventName.getText().toString().trim();
        evntdate=EventDate.getText().toString().trim();
        evntplace=EventPlace.getText().toString().trim();
        evntfor=EventFor.getText().toString().trim();

        String key=databaseReference.push().getKey();
        //String key2="Catagory";// this is for test.it will be removed
        EvntDataHandling evnt=new EvntDataHandling(evntname,evntplace,evntdate,evntfor);

        databaseReference.child(key).setValue(evnt);
        Toast.makeText(getApplicationContext(),"Event has been Created",Toast.LENGTH_LONG).show();

    }

}