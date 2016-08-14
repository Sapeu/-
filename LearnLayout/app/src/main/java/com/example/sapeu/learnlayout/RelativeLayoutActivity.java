package com.example.sapeu.learnlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RelativeLayoutActivity extends AppCompatActivity {
    private RelativeLayout root;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_relative_layout);
        root = new RelativeLayout(this);
        setContentView(root);
        text = new TextView(this);
        text.setText("好好学习");
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 123;
        lp.topMargin = 567;
        root.addView(text,lp);
    }
}
