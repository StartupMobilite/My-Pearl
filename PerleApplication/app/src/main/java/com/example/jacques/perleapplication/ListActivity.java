package com.example.jacques.perleapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.ami.fundapter.BindDictionary;
import com.ami.fundapter.FunDapter;
import com.ami.fundapter.extractors.StringExtractor;
import com.ami.fundapter.interfaces.DynamicImageLoader;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements AsyncResponse, View.OnClickListener {

    final String LOG="ListActivity";
    private ArrayList<modele> modelList;
    private ListView lvmodele;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


       // ImageLoader.getInstance().init(UILConfig.config(ListActivity.this));
        PostResponseAsyncTask TaskRead = new PostResponseAsyncTask(ListActivity.this);
        TaskRead.execute("http://10.0.3.2/MaPerle/produit.php");


    }

    @Override
    public void processFinish(String s) {
        modelList = new JsonConverter<modele>().toArrayList(s, modele.class);


        BindDictionary<modele> dict = new BindDictionary<modele>();
        dict.addStringField(R.id.tvName, new StringExtractor<modele>() {
            @Override
            public String getStringValue(modele modele, int i) {
                return modele.name;
            }
        });

        dict.addStringField(R.id.tvprice, new StringExtractor<modele>() {
            @Override
            public String getStringValue(modele modele, int i) {
                return "" + modele.price;
            }
        });

        dict.addStringField(R.id.tvQty, new StringExtractor<modele>() {
            @Override
            public String getStringValue(modele modele, int i) {
                return "" + modele.qty;
            }

        });

        dict.addDynamicImageField(R.id.ivlimage,
                new StringExtractor<modele>() {
                    @Override
                    public String getStringValue(modele m, int i) {
                        return m.image_url;
                    }

                }, new DynamicImageLoader() {
                    @Override
                    public void loadImage(String url, ImageView imageView) {

                        Picasso.with(ListActivity.this).load(url).placeholder(android.R.drawable.star_big_on).into(imageView);

                        //ImageLoader.getInstance().displayImage(url,imageView);
                    }
                }
        );

        FunDapter<modele>  adapter = new FunDapter<modele>(ListActivity.this,modelList,R.layout.layout_list,dict);
        lvmodele = (ListView) findViewById(R.id.lvmodele);
        lvmodele.setAdapter(adapter);
       // lvmodele.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {


    }
}
