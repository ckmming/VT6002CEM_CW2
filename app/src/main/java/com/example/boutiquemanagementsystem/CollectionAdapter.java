package com.example.boutiquemanagementsystem;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CollectionAdapter extends ArrayAdapter<Buy> {
    Context context;
    int resource;
    List<Buy> objects;
    EditText quantity;
    int totalBill = 0;

    public CollectionAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Buy> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource, parent, false);
//        convertView = LayoutInflater.from(getContext()).inflate(R.layout.collection, parent, false);
        Buy dress1 =objects.get(position);
        ImageView img =convertView.findViewById(R.id.dressImage);
        TextView price = convertView.findViewById(R.id.price);
        Button purchase = convertView.findViewById(R.id.btnPurchase);
        EditText qua = convertView.findViewById(R.id.qty);

        img.setImageResource(getItem(position).getImagePath());
        String str = Integer.toString(getItem(position).getPrice());
//        price.setText("Price is: "+ str);
        price.setText(Integer.toString(getItem(position).getPrice()));


//        quantity = convertView.findViewById(R.id.qty);

        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button b = (Button) v;
                int qty = Integer.parseInt(qua.getText().toString());
                int pri = Integer.parseInt(price.getText().toString());
                totalBill = totalBill + qty * pri;
                b.setText("Purchased");
                b.setBackgroundColor(Color.DKGRAY);
                System.out.println("Bill is " + totalBill);

            }

        });



        return  convertView;
    }

}
