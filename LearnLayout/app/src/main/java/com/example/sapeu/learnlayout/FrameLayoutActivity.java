package com.example.sapeu.learnlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class FrameLayoutActivity extends AppCompatActivity {
    private FrameLayout root;
    private ImageView i0,i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        root = (FrameLayout) findViewById(R.id.root);
        i0 = (ImageView) findViewById(R.id._0);
        i1 = (ImageView) findViewById(R.id._1);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i0.getVisibility() == View.VISIBLE) {
                    show1();
                } else {
                    show0();
                }
            }
        });
    }

    private void show0(){
        i0.setVisibility(View.VISIBLE);
        i1.setVisibility(View.INVISIBLE );
    }

    private void show1(){
        i0.setVisibility(View.INVISIBLE);
        i1.setVisibility(View.VISIBLE );
    }
}
