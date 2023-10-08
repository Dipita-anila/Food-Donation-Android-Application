package com.example.zerowaste;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class Donnar_nf_adapter extends ArrayAdapter<adm_msg_datahandle> {

  private    Activity context;

  private List<adm_msg_datahandle>msg_frm_admin;

    public Donnar_nf_adapter( Activity context,  List<adm_msg_datahandle> msg_frm_admin) {
        super(context, R.layout.dnr_nf_samplelayoutdesign, msg_frm_admin);
        this.context = context;
        this.msg_frm_admin = msg_frm_admin;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.dnr_nf_samplelayoutdesign,null,true);

        adm_msg_datahandle adm_msg_datahandle=msg_frm_admin.get(position);
        TextView v1=view.findViewById(R.id.dnr_nf_smpletxtid);

        v1.setText(adm_msg_datahandle.getAdminMsg());




        return view;
    }
}
