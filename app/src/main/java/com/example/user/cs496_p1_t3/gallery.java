package com.example.user.cs496_p1_t3;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.CursorLoader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;
import static android.provider.MediaStore.Images.Media.getBitmap;

/**
 * Created by user on 2017-12-27.
 */
//main for listview

public class gallery extends Fragment {

    static final int PICK_IMAGE = 1;

    public GridView gridViews;

    public static ArrayList<String> link = gallery_adapter.getLinks();

    public gallery() {

    }

//    List<Uri> fetchAllImages() {
//        // DATA는 이미지 파일의 스트림 데이터 경로를 나타냅니다.
//        String[] projection = { MediaStore.Images.Media.DATA };
//
//        Cursor imageCursor = getContext().getContentResolver().query(
//                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, // 이미지 컨텐트 테이블
//                projection, // DATA를 출력
//                null,       // 모든 개체 출력
//                null,
//                null);      // 정렬 안 함
//
//        ArrayList<Uri> result = new ArrayList<>(imageCursor.getCount());
//        int dataColumnIndex = imageCursor.getColumnIndex(projection[0]);
//
//        if (imageCursor == null) {
//            // Error 발생
//            // 적절하게 handling 해주세요
//        } else if (imageCursor.moveToFirst()) {
//            do {
//                String filePath = imageCursor.getString(dataColumnIndex);
//                Uri imageUri = Uri.parse(filePath);
//                result.add(imageUri);
//            } while(imageCursor.moveToNext());
//        } else {
//            // imageCursor가 비었습니다.
//        }
//        imageCursor.close();
//        return result;
//    }

    public List<String> getCameraImages() {
        String[] projection = new String[] { MediaStore.Images.Media._ID, MediaStore.Images.Media.DATA };
        Uri images = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor cur = getContext().getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, // 이미지 컨텐트 테이블
                projection, // DATA를 출력
                null,       // 모든 개체 출력
                null,
                null);
        Log.i("ListingImages", " query count=" + cur.getCount());
        ArrayList<String> imagePaths = new ArrayList<String>(cur.getCount());
        int rawCol = cur.getColumnIndex(MediaStore.Images.Media.DATA);
        if (cur.moveToFirst()) {
            do {
                imagePaths.add(cur.getString(rawCol));
            } while (cur.moveToNext());
        }
        return imagePaths;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = null;
        view = inflater.inflate(R.layout.gallery, container, false);

        gridViews = (GridView)view.findViewById(R.id.listview);

        dataSetting();

        //gridview item을 image와 link 보유.

        gridViews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //ArrayList<String> link = gallery_adapter.getLinks();
                Log.d("ig",link.get(position));
                Intent i = new Intent(getActivity().getApplicationContext(), ItemClick.class);
                i.putExtra("id", link.get(position));
                startActivity(i);
            }
        });

        return view;
    }

    private void dataSetting(){

        List<String> allimage = getCameraImages();
        int len = allimage.size();
        int index = 0;

        gallery_adapter mAdapter = new gallery_adapter();


        while(index < len){
            ImageView iv = new ImageView(getActivity().getApplicationContext());
            String imgpath = allimage.get(index);
            Log.d("imgpath is ", imgpath);
            Bitmap bm = BitmapFactory.decodeFile(imgpath);
            Bitmap thumbnail = ThumbnailUtils.extractThumbnail(bm,300,300);
            mAdapter.addItem(thumbnail,imgpath);
            index++;
            link.add(imgpath);
            }

        gridViews.setAdapter(mAdapter);
    }

}


