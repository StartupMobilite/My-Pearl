package com.example.jacques.perleapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jacques.perleapplication.R;
import com.example.jacques.perleapplication.modele.AndroidVersion;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SwipeDeckAdapter extends BaseAdapter {

  private final ArrayList<AndroidVersion> items;
  private final LayoutInflater inflater;

  public SwipeDeckAdapter(Context context, ArrayList<AndroidVersion> items) {
    this.inflater = LayoutInflater.from(context);
    this.items = items;
  }

  @Override
  public int getCount() {
    return items.size();
  }

  @Override
  public Object getItem(int position) {
    return items.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View v = convertView == null ? inflater.inflate(R.layout.list_row, parent, false) : convertView;
    TextView tv_android = (TextView) v.findViewById(R.id.tv_android);
    ImageView img_android = (ImageView) v.findViewById(R.id.img_android);

    tv_android.setText(items.get(position).getAndroid_version_name());
    Picasso.with(v.getContext()).load(items.get(position).getAndroid_image_url()).resize(120, 60).into(img_android);
    return v;
  }
}
