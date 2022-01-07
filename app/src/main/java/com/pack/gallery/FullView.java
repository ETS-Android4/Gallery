package com.pack.gallery;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FullView extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedinstacespace){
        super.onCreate(savedinstacespace);
        setContentView(R.layout.full_image_view);
        ImageView imageView =(ImageView) findViewById(R.id.img_full);
        int img_id = getIntent().getExtras().getInt("img_id");
        imageView.setImageResource(img_id);
    }
}
