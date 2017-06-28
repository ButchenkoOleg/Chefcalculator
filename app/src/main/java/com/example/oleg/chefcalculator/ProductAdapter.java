package com.example.oleg.chefcalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;



public class ProductAdapter extends ArrayAdapter<Products> {
    ArrayList<Products> prodList;
    LayoutInflater vi;
    int Resource;
    ViewHolder holder;

    public ProductAdapter(Context context, int resource, ArrayList<Products> objects) {
        super(context, resource, objects);
        vi = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
        prodList = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // convert view = design
        View v = convertView;
        if (v == null) {
            holder = new ViewHolder();
            v = vi.inflate(Resource, null);

            holder.product = (TextView) v.findViewById(R.id.prodName);
            holder.coast = (TextView) v.findViewById(R.id.prodCoast);
            holder.weight = (TextView) v.findViewById(R.id.prodWeight);
            holder.spending = (TextView) v.findViewById(R.id.spanding);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }


        holder.product.setText("Product: " + prodList.get(position).getName());
        holder.coast.setText("Coast: " + prodList.get(position).getCoast());
        holder.weight.setText("Weight: " + prodList.get(position).getWeight());
        //holder.spending.setText("Spending: " + prodList.get(position). );
        return v;

    }

    static class ViewHolder {
        public TextView product;
        public TextView coast;
        public TextView weight;
        public TextView spending;


    }

}