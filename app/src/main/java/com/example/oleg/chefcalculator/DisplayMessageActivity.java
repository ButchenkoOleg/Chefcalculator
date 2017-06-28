package com.example.oleg.chefcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;


public class DisplayMessageActivity extends Activity {

    EditText prodName;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);


        //

    }

    public void addProduct (View view) {
        prodName = (EditText)findViewById(R.id.edit_texst_name_prod);
        MainActivity.prodList.add(new Products("Chok",0,0));

       ;
    }
}
