package com.pack.gallery;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import org.opencv.core.Core;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSearch#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSearch extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    protected GridView gridView;
    protected View rootView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentSearch() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment search.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSearch newInstance(String param1, String param2) {
        FragmentSearch fragment = new FragmentSearch();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_search,container,false);
        //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
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

        gridView = (GridView) rootView.findViewById(R.id.grid_view_search);
        gridView.setAdapter(new RoundImageAdapter(mImageIds,getActivity()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int item_pos = mImageIds.get(position);
                showDialogBox(item_pos);
            }
        });
        // Inflate the layout for this fragment
       // grid_view_search)
        return rootView;
    }
    public void showDialogBox(int item_Pos){
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.round_custom_dialog);
        //gettting custom dialog view
        TextView imagename= dialog.findViewById(R.id.txt_image_name);
        //ImageView Image = dialog.findViewById(R.id.img);
        com.makeramen.roundedimageview.RoundedImageView Image = dialog.findViewById(R.id.img1);
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
}