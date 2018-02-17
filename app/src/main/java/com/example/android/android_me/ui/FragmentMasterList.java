package com.example.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.zip.Inflater;

/**
 * Created by Aminu Bishier on 12/28/2017.
 */

public class FragmentMasterList extends Fragment {

    OnImageSelectListener mCallback;
    public interface OnImageSelectListener{
        void onImageSelected(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


        try {

            mCallback = (OnImageSelectListener) context;
        }
        catch(ClassCastException e){
            throw new ClassCastException(context.toString() + " Must implement OnImageSelected Interface");

        }
    }
    public FragmentMasterList(){

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_master_list,container,false);
        GridView gridView = (GridView) rootView.findViewById(R.id.master_grid_view);
        MasterListAdapter adapter = new MasterListAdapter(getContext().getApplicationContext(), AndroidImageAssets.getAll());

        gridView.setAdapter(adapter);
       gridView.setOnItemClickListener( new AdapterView.OnItemClickListener(){


           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               mCallback.onImageSelected(position);
           }
       });

        return gridView;
    }
}
