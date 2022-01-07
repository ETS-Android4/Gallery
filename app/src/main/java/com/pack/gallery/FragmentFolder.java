package com.pack.gallery;
import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import androidx.recyclerview.widget.GridLayoutManager;
public class FragmentFolder extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    protected View rootView;
    GridView gridview;
    private String mParam1;
    private String mParam2;
    ArrayList<Integer> mImageIds = new ArrayList<>(Arrays.asList(
            R.drawable.divya,
            R.drawable.saikumar,
            R.drawable.srinivas,
            R.drawable.jagan,
            R.drawable.kcr,
            R.drawable.kegriwal,
            R.drawable.modi,
            R.drawable.tony,
            R.drawable.captain
    ));
    public FragmentFolder(){
    }
    public static FragmentFolder newInstance(String param1, String param2) {
        FragmentFolder fragment = new FragmentFolder();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        CheckUserPermisions();
        rootView=inflater.inflate(R.layout.fragment_folder,container,false);
        gridview = (GridView) rootView.findViewById(R.id.mygrid);
        gridview.setAdapter(new ImageAdapter(mImageIds,getActivity()));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               int item_pos = mImageIds.get(position);
               showDialogBox(item_pos);
           }
       });
         return rootView;
    }
    public void showDialogBox(int item_Pos){
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.custom_dialog);
        //gettting custom dialog view
        TextView imagename= dialog.findViewById(R.id.txt_image_name);
        ImageView Image = dialog.findViewById(R.id.img);
        Button btn_Full = dialog.findViewById(R.id.btn_full);
        Button btn_close = dialog.findViewById(R.id.btn_close);
        String title = getResources().getResourceName(item_Pos);
        //extracting name
        int index = title.indexOf("/");
        String name = title.substring(index+1,title.length());
        imagename.setText(name);
        Image.setImageResource(item_Pos);
        btn_close.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialog.dismiss();
            }
        });
        btn_Full.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(getActivity(),FullView.class);
                intent.putExtra("img_id",item_Pos);
                startActivity(intent);
            }
        });
        dialog.show();
    }
    private void CheckUserPermisions(){
        if(Build.VERSION.SDK_INT >=23){
            if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                    PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1/*REQUEST_CODE_ASK_PERMISSIONS*/);
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1/*REQUEST_CODE_ASK_PERMISSIONS*/);
                return;
            }
            }
        else {
            // Permission Denied
            Toast.makeText(getActivity(), "Please try again ", Toast.LENGTH_SHORT).show();
            CheckUserPermisions();
        }

    }
}
