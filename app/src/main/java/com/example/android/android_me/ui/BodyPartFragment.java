package com.example.android.android_me.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aminu Bishier on 12/25/2017.
 */

public class BodyPartFragment extends android.support.v4.app.Fragment {
    private List<Integer> mImageIds;
    private int mImageIndex;
    private String LOG = "Body Part Fragment";
    private final String IMAGE_LIST_ID="mImageIds"  ;
    private final String IMAGE_LIST_INDEX = "mImageIndex";
    public BodyPartFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if (savedInstanceState != null){
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_LIST_ID);
            mImageIndex = savedInstanceState.getInt(IMAGE_LIST_INDEX);
        }
        View rootView = inflater.inflate(R.layout.fragrment_body_part, container, false);
       final ImageView  imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

        imageView.setOnClickListener(new View.OnClickListener(){
                                         @Override
                                         public void onClick(View v) {
                                             if(mImageIndex < mImageIds.size() -1){
                                                 mImageIndex++;
                                                 imageView.setImageResource(mImageIds.get(mImageIndex));
                                             }
                                             else
                                                 mImageIndex =0;
                                         }
                                     }

        );
        if(mImageIds != null){
            imageView.setImageResource(mImageIds.get(mImageIndex));
        }
        else {
            Log.v(LOG,"This Fragment contain empty image IDs");
        }

        return imageView;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putIntegerArrayList(IMAGE_LIST_ID,(ArrayList<Integer>) mImageIds);
        savedInstanceState.putInt(IMAGE_LIST_INDEX,mImageIndex);
    }

    public void setImageIds(List<Integer> imageId){

        mImageIds = imageId;
    }
    public void setmImageIndex(int index){
        mImageIndex = index;
    }
}
