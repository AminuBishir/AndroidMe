package com.example.android.android_me.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.android_me.R;

import java.util.zip.Inflater;

public class TheMainActivity extends AppCompatActivity implements FragmentMasterList.OnImageSelectListener{

    private int head_index,body_index,leg_index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_main);

    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "Position Clicked = "+position,Toast.LENGTH_SHORT).show();
        int body_part_index = position/12;
        switch (body_part_index){
            case 0 : head_index = position;
                break;
            case 1 : body_index = position -12;
                break;
            case 2 : leg_index  = position -24;
                break;
            default: break;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("head_index",head_index);
        bundle.putInt("body_index",body_index);
        bundle.putInt("leg_index",leg_index);

        final Intent intent = new Intent(this,MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
