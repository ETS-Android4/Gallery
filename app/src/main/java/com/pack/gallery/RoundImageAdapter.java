package com.pack.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class RoundImageAdapter extends BaseAdapter {
    private List<Integer> mThubIds;
    private Context context;
    public RoundImageAdapter(List<Integer>mThubIds,Context context){
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
        com.makeramen.roundedimageview.RoundedImageView imageview =(com.makeramen.roundedimageview.RoundedImageView)  convertView;
        if(imageview == null){
            imageview = new com.makeramen.roundedimageview.RoundedImageView(context);
            imageview.setLayoutParams(new ViewGroup.LayoutParams(250,450));
            imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        imageview.setImageResource(mThubIds.get(position));
        return imageview;
    }

}
