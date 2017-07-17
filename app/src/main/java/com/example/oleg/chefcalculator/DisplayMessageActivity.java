package com.example.oleg.chefcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;


public class DisplayMessageActivity extends Activity {

    private EditText prodName, prodWeightUsed,prodWeightPack, prodCoast;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        prodName = (EditText)findViewById(R.id.edit_text_name_prod);
        prodWeightUsed = (EditText)findViewById(R.id.edit_text_weight_prod);
        prodWeightPack = (EditText)findViewById(R.id.edit_text_weight_pack);
        prodCoast = (EditText)findViewById(R.id.edit_text_coast_prod);

    }

    public void addProduct (View view) {

       Intent intent = new Intent();

        String ed_text_name = prodName.getText().toString().trim();
        int ed_text_weight_used = Integer.parseInt(prodWeightUsed.getText().toString());
        int ed_text_weight_pack = Integer.parseInt(prodWeightPack.getText().toString());
        double ed_text_coast = Double.parseDouble(prodCoast.getText().toString());
        double expenditure = ed_text_coast/ed_text_weight_pack*ed_text_weight_used;

        intent.putExtra("name", ed_text_name );
        intent.putExtra("weight pack", ed_text_weight_pack );
        intent.putExtra("coast", ed_text_coast );
        intent.putExtra("weight spending", ed_text_weight_used);
        intent.putExtra("expenditure", expenditure);
        setResult(RESULT_OK, intent);
        finish();

    }


}
