package com.example.boutiquemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;
    TextView register;
    DbHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.loginName);
        password = findViewById(R.id.loginPassword);
        login = findViewById(R.id.btnLogin);
        register = findViewById(R.id.lblLogin);
        helper = new DbHelper(this);
    }

    public void onLogin(View view) {
        String user = username.getText().toString();
        String pass = password.getText().toString();
        Boolean check = helper.loginByUsernameAndPassword(user, pass);

        if(check) {
            finish();
            Intent intent = new Intent(this, HomePage.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Username or password is incorrect", Toast.LENGTH_SHORT).show();
        }

    }

    public void onRegister(View view) {
        finish();
        Intent goToRegister = new Intent(this, Register.class);
        startActivity(goToRegister);
    }
}