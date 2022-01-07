package com.pack.gallery;

import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import org.opencv.core.*;
import org.opencv.imgcodecs.*;
import org.opencv.imgproc.*;
import org.opencv.objdetect.*;
import org.opencv.core.*;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentPeople#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentPeople extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    protected View rootView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    GridView gridview;
    public FragmentPeople() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentPeople.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentPeople newInstance(String param1, String param2) {
        FragmentPeople fragment = new FragmentPeople();
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
        // Inflate the layout for this fragment
        rootView=inflater.inflate(R.layout.fragment_people,container,false);
        //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //  CascadeClassifier faceDetector = new CascadeClassifier();
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
       // faceDetector.load("haarcascade_frontalface_alt.xml");
        try {
            //Mat image = Imgcodecs.imread(String.valueOf(mImageIds.get(0)));
            //MatOfRect faceDetections = new MatOFRect();
          //  facedetector.detectMultiScale(image,facedetections);
            //for(Rect rect :faceDetections.toArray()){
              //  Imgproc.rectangle(image,new Point(rect.x,rect.y),
                //        new Point(rect.x,rect.width,rect.y+rect.height),
                  //      new Scalar(0,25,0));
            //}
            String name = "out.jpg";
            //Imgcodecs.imWrite("/"+name,image);
        }catch (Exception ex){
            Log.v("Exception view",""+ex);
        }
        gridview = (GridView) rootView.findViewById(R.id.mygrid1);
        gridview.setAdapter(new RoundImageAdapter(mImageIds,getActivity()));
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