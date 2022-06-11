package com.example.boutiquemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Bill extends AppCompatActivity {

    int val;
    TextView textBill;
    Button logout, btnOk;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        Intent intent = getIntent();
        val = intent.getIntExtra("bill", 0);

        textBill = findViewById(R.id.txtBill);
        logout = findViewById(R.id.btnLogoutToMain);
        btnOk = findViewById(R.id.btnOk);
        img = findViewById(R.id.imageView2);
        img.setImageResource(R.drawable.girll);

        textBill.setText("Total amount is: "+ val);
//        System.out.println("Bill in Bill activity " + val);
    }

    public void onClickOk(View view) {
        Toast.makeText(this, "Thanks for Shopping!", Toast.LENGTH_SHORT).show();
    }

    public void onClickLogout(View view) {
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}