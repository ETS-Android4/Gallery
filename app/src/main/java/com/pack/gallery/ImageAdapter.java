package com.pack.gallery;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private List<Integer> mThubIds;
    private Context context;
    public ImageAdapter(List<Integer>mThubIds,Context context){
        this.mThubIds = mThubIds;
        this.context = context;
    }
    @Override
    public int getCount() {
        return mThubIds.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return mThubIds.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageview =(ImageView)  convertView;
        if(imageview == null){
            imageview = new ImageView(context);
            imageview.setLayoutParams(new ViewGroup.LayoutParams(250,450));
            imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        imageview.setImageResource(mThubIds.get(position));
        return imageview;
    }
}
