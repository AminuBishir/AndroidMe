package com.example.android.android_me.ui;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

public class BodyPart2Pragment extends Fragment {
    private List<Integer> mImageIds;
    private int mImageIndex;
    private String LOG = "Body Part2 Fragment";
    private final String IMAGE_LIST_ID = "mImageIds";
    private final String IMAGE_LIST_INDEX = "mImageIndex";
    public  BodyPart2Pragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_body_part2,container,false);
      final   ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part2_image_view);
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
            Log.v(LOG, "The Body Part2 Fragment contains an empty image IDs");
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
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putIntegerArrayList(IMAGE_LIST_ID,(ArrayList<Integer>) mImageIds);
        savedInstanceState.putInt(IMAGE_LIST_INDEX,mImageIndex);
    }
}
