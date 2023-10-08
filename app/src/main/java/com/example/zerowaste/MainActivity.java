package com.example.zerowaste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {

    customAdapter adapter;
    int [] logos={R.drawable.basmah,R.drawable.ffhungry,R.drawable.jgo,R.drawable.norailexpress,R.drawable.savethechildren};
    String[]organizationNames;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=(GridView)findViewById(R.id.gridViewId);
       organizationNames=getResources().getStringArray(R.array.organizationName);
         adapter=new customAdapter(this,organizationNames,logos);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        MenuItem menuItem= menu.findItem(R.id.searchviewId);
        SearchView searchView= (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
            // adapter.getFilter().filter(newText);// i did it by seeing anisul islam when he did it to listview
                return true;// i changed it by seeing video ,before than it was false
            }
        });

        return true;// i changed it by seeing video, before than it was super.onCreateOptionsMenu(menu) on true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        if(id==R.id.searchviewId){
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}