package com.example.oleg.chefcalculator;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final int REQUEST_CODE_PROD = 1;
    double total_expenditure = 0;

    static ArrayList<Products> prodList;
    ListView listView;
    TextView textViewTotalExpenditure;

    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prodList = new ArrayList<Products>();

        prodList.add(new Products("Butter", 200, 17.8, 120));




        listView = (ListView)findViewById(R.id.list);
        textViewTotalExpenditure = (TextView)findViewById(R.id.total_expenditure);
        total_expenditure = total_expenditure + prodList.get(0).getExpenditure();
        textViewTotalExpenditure.setText("Total expenditure " + String.valueOf(total_expenditure));
        adapter = new ProductAdapter(getApplicationContext(), R.layout.row, prodList);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id) {

                Toast.makeText(getApplicationContext(), prodList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        /*EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);*/
        startActivityForResult(intent, REQUEST_CODE_PROD);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        //add new product in LisView
        prodList.add(new Products(data.getStringExtra("name"), data.getIntExtra("weight pack", 0), data.getDoubleExtra("coast", 0), data.getIntExtra("weight spending",0)));
        adapter.notifyDataSetChanged();

        // calculate expenditure of product in list
        double total_expenditure_updated = 0;
        for (Products products : prodList){
            total_expenditure_updated = total_expenditure_updated + products.getExpenditure();
        }
        total_expenditure = total_expenditure_updated;
        total_expenditure = Math.floor(total_expenditure*100)/100;
        textViewTotalExpenditure.setText("Total expenditure " + String.valueOf(total_expenditure));

    }
}
