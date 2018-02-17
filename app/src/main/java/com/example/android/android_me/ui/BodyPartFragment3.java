package com.example.android.android_me.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
 * Created by Aminu Bishier on 12/26/2017.
 */

public class BodyPartFragment3 extends android.support.v4.app.Fragment {
    private List<Integer> mImageIds;
    private int mImageIndex;
    private String LOG = "Body Part 3 Fragment";
    private  final String IMAGE_LIST_ID = "mImage_Ids";
    private final String IMAGE_LIST_INDEX = "mImage_Index";
    public BodyPartFragment3(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_body_part3,container,false);
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part3_image_view);
        if(savedInstanceState != null){
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_LIST_ID);
            mImageIndex = savedInstanceState.getInt(IMAGE_LIST_INDEX);
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mImageIndex < mImageIds.size() -1){
                    mImageIndex++;
                    imageView.setImageResource(mImageIds.get(mImageIndex));
                }
                else
                    mImageIndex =0;
            }
        });
        if(mImageIds != null){
            imageView.setImageResource(mImageIds.get(mImageIndex));
        }
        else{
            Log.v(LOG,"Body part 3 contain an empty image ids");
        }

        return imageView;
    }
    public void setmImageIds(List<Integer> imageIds){
        mImageIds = imageIds;
    }
    public void setmImageIndex(int imageIndex){
        mImageIndex = imageIndex;
    }

    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_LIST_ID,(ArrayList<Integer>)mImageIds);
        currentState.putInt(IMAGE_LIST_INDEX,mImageIndex);

    }
}
