package com.example.user.cs496_p1_t3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;

/**
 * Created by user on 2017-12-27.
 */

public class Imagefrag extends Fragment{

    public Imagefrag(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedlnstanceState){
        View view = null;
        view = inflater.inflate(R.layout.imagefrag, container, false);

        return view;
    }
}
