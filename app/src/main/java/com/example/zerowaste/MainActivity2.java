package com.example.zerowaste;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    


    RecyclerView myrecyclerView;
    RecyclerViewAdapter myAdapter;

    List<Recipes> recipes1;

    DatabaseReference databaseReference;
    String a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

      /* taking data from organizingEvent
        String name=getIntent().getStringExtra("keyEvntName");
        String place=getIntent().getStringExtra("keyplace");
       */

        databaseReference= FirebaseDatabase.getInstance().getReference().child("checking").child("-MkYV8YeKJWlnZHgIRao");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {

                if(snapshot.exists())
                {
                    a=snapshot.child("ename").getValue().toString();
                }

            }

            @Override
            public void onCancelled( DatabaseError error) {

            }
        });

        recipes1 = new ArrayList<>();
        recipes1.add(new Recipes("BASHMAH Foundation","the name of the place "+a +" "+
                "     "+"   "+" "+
                "description about the event" +
                "description about the event" +
                "description about the event" +
                "description about the event" +
                "description about the event" +
                "description about the event" +
                "description about the event" +
                "description about the event" +
                "description about the event" +
                "description about the event" +
                "description about the event","Schedule",
                "Time and date . time and date . time and date!\n",R.drawable.basmah));

        recipes1.add(new Recipes("save the children","1 c. whole milk" +
                "description about the event" +
                "description about the event " +
                "description about the event" +
                "description about the event" +
                "description about the event" +
                "description about the event" +
                "description about the event" +
                "description about the event","Schedule","\n" +
                "time nd date . time and date . time and date. time and date . time and date",R.drawable.savethechildren));
        recipes1.add(new Recipes("Feed the Hungry","Schedule" +
                "description about the event" +
                "description about the event " +
                "description about the event" +
                "description about the event" +
                "description about the event" +
                "description about the event" +
                "description about the event" +
                "description about the event","Schedule",
                "Time and date . time and date . time and date!\n",R.drawable.ffhungry));
        recipes1.add(new Recipes("Jago","description" +
                "description about the event" +
                "description about the event " +
                "description about the event" +
                "description about the event" +
                "description about the event" +
                "description about the event" +
                "description about the event" +
                "description about the event","Schedule",
                "Time and date . time and date . time and date!\n",R.drawable.jgo));
        recipes1.add(new Recipes("NorailExpress","description" +
                "description about the event" +
                "description about the event " +
                "description about the event" +
                "description about the event" +
                "description about the event" +
                "description about the event" +
                "description about the event" +
                "description about the event","Schedule",
                "Time and date . time and date . time and date!\n",R.drawable.norailexpress));



        myrecyclerView = (RecyclerView)findViewById(R.id.recyclerView_id);

        myAdapter = new RecyclerViewAdapter(this,recipes1);

        myrecyclerView.setLayoutManager(new GridLayoutManager(this,1));

        myrecyclerView.setAdapter(myAdapter);




    }
}