package com.example.android.android_me.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle = getIntent().getExtras();
        int head_index = bundle.getInt("head_index");
        int body_index = bundle.getInt("body_index");
        int leg_index  = bundle.getInt("leg_index");
            if(savedInstanceState == null) {
                BodyPartFragment headFragment = new BodyPartFragment();
                headFragment.setImageIds(AndroidImageAssets.getHeads());
                headFragment.setmImageIndex(head_index);

                BodyPart2Pragment bodyFragment = new BodyPart2Pragment();
                bodyFragment.setmImageIds(AndroidImageAssets.getBodies());
                bodyFragment.setmImageIndex(body_index);

                BodyPartFragment3 legFragment = new BodyPartFragment3();
                legFragment.setmImageIds(AndroidImageAssets.getLegs());
                legFragment.setmImageIndex(leg_index);


                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .add(R.id.head_container, headFragment).commit();

                fragmentManager.beginTransaction()
                        .add(R.id.body_container, bodyFragment)
                        .commit();
                fragmentManager.beginTransaction()
                        .add(R.id.leg_container, legFragment)
                        .commit();
            }
    }
}
