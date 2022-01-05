package com.pack.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutAdapter  extends BaseAdapter {
    private Context context;
    LayoutInflater inflater;
    String[] team_name;
    int[] img_id,id;
    public AboutAdapter(Context c,String[] team_name,int[] id,int[] img_id){
        context =c;
        this.team_name = team_name;
        this.id = id;
        this.img_id = img_id;
    }
    @Override
    public int getCount() {
        return team_name.length;
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
        if (inflater == null){
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView = inflater.inflate(R.layout.row_item,null);
        }
        ImageView imageView = convertView.findViewById(R.id.about_imageview);
        TextView about_name,about_hallticket;
        about_name = convertView.findViewById(R.id.about_name);
        about_hallticket = convertView.findViewById(R.id.about_hallticket);
        imageView.setImageResource(img_id[position]);
        about_name.setText(team_name[position]);
        about_hallticket.setText(id[position]);
        return convertView;
    }
}
