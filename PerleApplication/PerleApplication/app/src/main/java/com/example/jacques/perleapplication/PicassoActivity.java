package com.example.jacques.perleapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class PicassoActivity extends AppCompatActivity {


    private final String android_version_names[] = {
            "test",
            "Ratp",
            "test3",
            "test1",
            "ratp2",
            "en",
            "calendrier"
    };

    private final String android_image_urls[] = {
            "http://www.maperle.esy.es/collections/uploads/0.png",
            "http://www.maperle.esy.es/collections/uploads/6.png",
            "http://www.maperle.esy.es/collections/uploads/5.png",
            "http://www.maperle.esy.es/collections/uploads/4.png",
            "http://www.maperle.esy.es/collections/uploads/7.png",
            "http://www.maperle.esy.es/collections/uploads/8.png",
            "http://www.maperle.esy.es/collections/uploads/9.png",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);

       // android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);




        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);


        initViews();
    }

    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList androidVersions = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(),androidVersions);
        recyclerView.setAdapter(adapter);

    }
    private ArrayList prepareData(){

        ArrayList android_version = new ArrayList<>();
        for(int i=0;i<android_version_names.length;i++){
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_version_name(android_version_names[i]);
            androidVersion.setAndroid_image_url(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }
}
