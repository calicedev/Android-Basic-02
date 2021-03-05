package com.example.user.cs496_p1_t3;

import android.graphics.Bitmap;

/**
 * Created by user on 2017-12-28.
 */

public class gallery_item {

    private Bitmap bm;
    private String link;

    public Bitmap getBm(){
        return bm;
    }
    public String getLink() {return link;}

    public void setBm(Bitmap bm){
        this.bm = bm;
    }
    public void setLink(String link){
        this.link = link;
    }
}
