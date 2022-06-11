package com.example.boutiquemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class SeeCollection extends AppCompatActivity {

    ListView listView;
    CollectionAdapter adapter;
    ArrayList<Buy> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_collection);
        listView = findViewById(R.id.listview);

        list = new ArrayList<>();

        list.add(new Buy(R.drawable.w_dress1,1000));
        list.add(new Buy(R.drawable.w_dress2,800));
        list.add(new Buy(R.drawable.w_dress3, 2500));
        list.add(new Buy(R.drawable.w_dress4, 3000));
        list.add(new Buy(R.drawable.w_dress5, 700));
        list.add(new Buy(R.drawable.m_dress1, 1200));
        list.add(new Buy(R.drawable.m_dress2, 1500));
        list.add(new Buy(R.drawable.w_dress3, 1100));
        list.add(new Buy(R.drawable.w_dress4, 1800));
        list.add(new Buy(R.drawable.w_dress5, 1600));
        list.add(new Buy(R.drawable.k_dress1, 900));
        list.add(new Buy(R.drawable.k_dress2, 500));
        list.add(new Buy(R.drawable.k_dress3, 1000));
        list.add(new Buy(R.drawable.k_dress4, 900));
        list.add(new Buy(R.drawable.k_dress5, 750));

        adapter = new CollectionAdapter(this, R.layout.collection,list);
        listView.setAdapter(adapter);
    }

    public void logout(View view) {
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onGenerateBill(View view) {
        int bill = adapter.totalBill;
        finish();
        Intent intent = new Intent(this, Bill.class);
        intent.putExtra("bill", bill);
        startActivity(intent);
    }
}