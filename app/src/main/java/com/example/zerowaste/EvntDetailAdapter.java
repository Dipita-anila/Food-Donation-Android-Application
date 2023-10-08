package com.example.zerowaste;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EvntDetailAdapter extends ArrayAdapter<EvntDataHandling>{

    private Activity context;
    private List<EvntDataHandling> EvntdataList;


    public EvntDetailAdapter( Activity context,List<EvntDataHandling> EvntdataList) {
        super(context,R.layout.evntdetailsmpleadptr, EvntdataList);
        this.context = context;
        this.EvntdataList = EvntdataList;
    }


    public View getView(int position,  View convertView,  ViewGroup parent) {

        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.evntdetailsmpleadptr,null,true);

        EvntDataHandling evntDataHandling=EvntdataList.get(position);

        TextView n1=view.findViewById(R.id.evntdnmeId);
        TextView p1=view.findViewById(R.id.evntdplceId);
        TextView t1=view.findViewById(R.id.evntdtmeId);
        TextView f1=view.findViewById(R.id.evntdfrId);

        n1.setText("Event Organizer & Name: "+evntDataHandling.getEname());
        p1.setText("Event Place: "+evntDataHandling.getEplace());
        t1.setText("Event Time & Deadline for the Donation: "+evntDataHandling.getEdate());
        f1.setText("Event For: "+evntDataHandling.getEfor());


        return view;


    }
}
