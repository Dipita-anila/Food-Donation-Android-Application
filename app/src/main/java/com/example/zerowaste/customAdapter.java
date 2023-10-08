package com.example.zerowaste;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

public class customAdapter extends BaseAdapter  {
    Context context;
    int [] logos;
    String[] organizationNames;
    private LayoutInflater inflater;
    customAdapter(Context context,String[]organizationNames,int[]logos){
        this.context=context;
        this.organizationNames=organizationNames;
        this.logos=logos;
    }

    @Override
    public int getCount() {
        return organizationNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.sample_cardview,parent,false);

        }
        ImageView imageView=(ImageView)convertView.findViewById(R.id.imageViewId);
        TextView textView= (TextView) convertView.findViewById(R.id.textViewId);
        imageView.setImageResource(logos[position]);
        textView.setText(organizationNames[position]);
        return convertView;
    }

  /*  @Override
    public Filter getFilter() {
        Filter filter=new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults=new FilterResults();
                if(constraint==null||constraint.length()==0){
                    filterResults.count== organizationNames.length;
                    filterResults.values==organizationNames;

                }
                return null;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                filter

            }
        };
        return filter;
    }*/
}
