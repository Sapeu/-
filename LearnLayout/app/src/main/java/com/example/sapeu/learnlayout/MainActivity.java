package com.example.sapeu.learnlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout root;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
//        root.setOrientation(LinearLayout.HORIZONTAL);
        setContentView(root);
        for (int i = 0; i < 5; i++) {
            btn = new Button(this);
            btn.setText("删除点我！");
            btn.setOnClickListener(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.weight = 1;
            root.addView(btn,lp);
        }

//        root.addView(btn,321,123);
//        root.addView(btn,LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//        root.addView(btn,lp);
    }

    @Override
    public void onClick(View view) {
        root.removeView(view);
    }
}
