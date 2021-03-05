package com.example.user.cs496_p1_t3;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by user on 2017-12-28.
 */

public class gallery_adapter extends BaseAdapter{

    private ArrayList<gallery_item> mItems = new ArrayList<>();

    public static ArrayList<String> links = new ArrayList<String>();

    @Override
    public int getCount(){
        return mItems.size();
    }

    public static ArrayList<String> getLinks(){
        return links;
    }

    @Override
    public gallery_item getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup  parent){

        Context context = parent.getContext();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_sub, parent, false);
        }

        ImageView iv_img = (ImageView) convertView.findViewById(R.id.image) ;
        gallery_item myItem = getItem(position);
        Log.d("links link is ", myItem.getLink());
        iv_img.setImageBitmap(myItem.getBm());
        return convertView;
    }

    public void addItem(Bitmap bm, String link){
        gallery_item mItem = new gallery_item();

        mItem.setBm(bm);
        mItem.setLink(link);

        mItems.add(mItem);

    }

}
