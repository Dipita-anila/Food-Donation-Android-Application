package com.example.zerowaste;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class DonationDataRshowAdapter extends ArrayAdapter<DonationDataReceive>{


    private Activity context;
    private List<DonationDataReceive> Donateddata;

    public DonationDataRshowAdapter( Activity context, List<DonationDataReceive> Donateddata) {
        super(context, R.layout.admn_nf_donnars_sampleview, Donateddata);
        this.context = context;
        this.Donateddata = Donateddata;
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=context.getLayoutInflater();
      View view=  layoutInflater.inflate(R.layout.admn_nf_donnars_sampleview,null,true);

      DonationDataReceive donationDataReceive=Donateddata.get(position);

        TextView dnr_username=view.findViewById(R.id.anf_usernameid);
        TextView dnr_mail=view.findViewById(R.id.anf_emailid);
        TextView dnr_foodcatagory=view.findViewById(R.id.anf_foodcatid);
        TextView dnr_location=view.findViewById(R.id.anf_locationid);
        TextView dnr_time=view.findViewById(R.id.anf_timecookid);
        TextView dnr_quantity=view.findViewById(R.id.anf_foodq_id);

        dnr_username.setText("User Name"+donationDataReceive.getUname());
        dnr_mail.setText("Email"+donationDataReceive.getUmail());
        dnr_foodcatagory.setText("Food Catagory"+donationDataReceive.getUfoodtype());
        dnr_location.setText("Donor Location"+donationDataReceive.getUlocation());
        dnr_time.setText("Baking time"+donationDataReceive.getUtime());
        dnr_quantity.setText("Quantity"+donationDataReceive.getUquantity());





        return view;
    }
}
