package com.example.zerowaste;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminToDonnar_msg extends AppCompatActivity {


    TextView txt1;
    EditText msg;
    Button msgbtn;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_admin_to_donnar_msg);

        databaseReference= FirebaseDatabase.getInstance().getReference("Message_Exchange:");

        msg = (EditText) findViewById(R.id.admeditTextNameid);
        msgbtn = (Button) findViewById(R.id.admmsgsendbtnid);
        txt1 = (TextView) findViewById(R.id.admmsgshowid);

        msgbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String adminmsg = msg.getText().toString();
                txt1.setText(" " + adminmsg);
                Send();
            }
        });
    }


    public void Send()
    {
        String sendablemsg=msg.getText().toString().trim();

        String fromAdmin="Admin->"; // this is the key of the database
        adm_msg_datahandle adminmsg=new adm_msg_datahandle(sendablemsg);
        databaseReference.child(fromAdmin).setValue(adminmsg);
        Toast.makeText(AdminToDonnar_msg.this,"Messages send to the donnar",Toast.LENGTH_SHORT).show();

    }

}