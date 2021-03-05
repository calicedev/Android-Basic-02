package com.example.user.cs496_p1_t3;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by user on 2017-12-27.
 */

public class freefrag extends Fragment {

    public freefrag(){

    }
    Button add;
    Button sub;
    Button mul;
    Button div;
    EditText NUMBER1;
    EditText NUMBER2;
    TextView RESULT;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedlnstanceState){

        View view = inflater.inflate(R.layout.freefrag, container, false);

        NUMBER1 =(EditText)view.findViewById(R.id.NUMBER1);
        NUMBER2 =(EditText)view.findViewById(R.id.NUMBER2);
        RESULT = (TextView) view.findViewById(R.id.RESULT);
        add = view.findViewById(R.id.ADD);
        sub = view.findViewById(R.id.SUB);
        mul = view.findViewById(R.id.MUL);
        div = view.findViewById(R.id.DIV);


        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int n1 = Integer.parseInt(NUMBER1.getText().toString());
                int n2 = Integer.parseInt(NUMBER2.getText().toString());
                RESULT.setText(Integer.toString(n1+n2));
                if(n1==496 & n2==496) {
                    Intent intent = new Intent(getActivity(), Diary.class);
                    startActivity(intent);
                }

            }
        });
        sub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int n1 = Integer.parseInt(NUMBER1.getText().toString());
                int n2 = Integer.parseInt(NUMBER2.getText().toString());
                RESULT.setText(Integer.toString(n1-n2));

            }
        });
         mul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int n1 = Integer.parseInt(NUMBER1.getText().toString());
                int n2 = Integer.parseInt(NUMBER2.getText().toString());
                RESULT.setText(Integer.toString(n1*n2));

            }
        });
        div.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int n1 = Integer.parseInt(NUMBER1.getText().toString());
                int n2 = Integer.parseInt(NUMBER2.getText().toString());
                RESULT.setText(Integer.toString(n1/n2));

            }
        });


        return view;
    }



}
