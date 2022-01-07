package com.pack.gallery;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.*;

import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    ImageView  menu;
    @Override
    public void onCreate(Bundle savedinstancestate) {
        super.onCreate(savedinstancestate);
        getSupportActionBar().hide();
      /*  new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,Intro.class));
                finish();
            }
        },300); */
        setContentView(R.layout.activity_main);
        NavigationView navigationview = findViewById(R.id.navigationview);
        navigationview.setItemIconTintList(null);
        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationview, navController);
        }
}