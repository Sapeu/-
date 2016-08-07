package com.example.sapeu.launchloacaapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LocalAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_app);
        Uri uri = getIntent().getData();
        System.out.println(uri);
    }
}
