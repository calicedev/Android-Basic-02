package com.example.user.cs496_p1_t3;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by user on 2017-12-28.
 */

public class ItemClick extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagefrag);

        // get intent data
        Intent i = getIntent();

        // Selected image id
        String link = i.getExtras().getString("id");

        Log.d("position is here", link);
        Bitmap bm = BitmapFactory.decodeFile(link);

        ImageView imageView = (ImageView)findViewById(R.id.image);
        imageView.setImageBitmap(bm);
    }

}
