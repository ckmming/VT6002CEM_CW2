package com.example.boutiquemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText username, email, phone, password, confirmPassword;
    Button register;
    TextView login;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.registerUsername);
        email = findViewById(R.id.registerEmail);
        phone = findViewById(R.id.registerPhone);
        password = findViewById(R.id.registerPassword);
        confirmPassword = findViewById(R.id.registerConfirmPassword);
        register = findViewById(R.id.btnRegister);
        login = findViewById(R.id.lblLogin);

        dbHelper = new DbHelper(this);
    }

    public void onRegistration(View view) {

        String userName = String.valueOf(username.getText());
        String userEmail = String.valueOf(email.getText());
        String userPhone = String.valueOf(phone.getText());
        String userPassword = String.valueOf(password.getText());
        String userConfirmPassword = String.valueOf(confirmPassword.getText());

        if(userPassword.equals(userConfirmPassword)) {
            dbHelper.addUser(userName, userEmail, userPhone, userPassword);
            Toast.makeText(this, "Registered successfully. Please login", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Your password does not match", Toast.LENGTH_SHORT).show();
//        System.out.println(userName);
//        System.out.println(userEmail);
//        System.out.println(userPhone);
//        System.out.println(userPassword);
//        System.out.println(userConfirmPassword);



    }

    public void onLoginClick(View view) {
        finish();
        Intent goToLogin = new Intent(this, MainActivity.class);
        startActivity(goToLogin);
    }
}