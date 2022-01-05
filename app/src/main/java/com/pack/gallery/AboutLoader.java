package com.pack.gallery;

import android.app.Activity;
import android.widget.GridView;

public class AboutLoader extends Activity {
    GridView gridView;
    AboutAdapter adapter;
    public AboutLoader(){
       gridView = (GridView)findViewById(R.id.grid_view_about);
        //about fragment
        String[] team_name = {"Banoth Srinivas","Vangeti chaithanya","Dubasi Divya","Pullakandam Sai Kumar","Narsimha"};
        String[] id  = { "19641A05M8","19641A05K2","19641A05J5","19641A05N2","19641A05M9"};
        int[] imageid ={
                R.drawable.srinivas,
                R.drawable.user,
                R.drawable.user,
                R.drawable.user,
                R.drawable.user,
        };

       adapter = new AboutAdapter(AboutLoader.this,team_name,id,imageid);
        gridView.setAdapter(adapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

}
