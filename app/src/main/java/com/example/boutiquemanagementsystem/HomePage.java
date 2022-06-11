package com.example.boutiquemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomePage extends AppCompatActivity {

    ImageView slideshow;
    int count;
    int []imageArray={R.drawable.w2,R.drawable.m1,R.drawable.k1,R.drawable.w2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        count = 0;
        slideshow = findViewById(R.id.slideshow);
        slideshow.setImageResource(R.drawable.w2);

        Thread timer = new Thread() {
            public void run() {
                try {
//                    slideshow.setImageResource(imageArray[0]);
                    sleep(2000);


                    for (count = 0; count < imageArray.length + 1; count++) {
//                        slideshow.setImageResource(imageArray[0]);
                        if (count < imageArray.length) {
                            sleep(2000);
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    slideshow.setImageResource(imageArray[count]);
                                }
                            });
                        } else {
                            count = 0;
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    slideshow.setImageResource(imageArray[count]);
//                                }
//                            });
//                            slideshow.setImageResource(imageArray[0]);

                        }
//                        slideshow.setImageResource(imageArray[0]);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("finally");
                }
            }
        };
        timer.start();

    }

    public void onSeeCollectionClick(View view) {

        finish();
        Intent intent = new Intent(this, SeeCollection.class);
        startActivity(intent);
    }

    public void onLogout(View view) {
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}