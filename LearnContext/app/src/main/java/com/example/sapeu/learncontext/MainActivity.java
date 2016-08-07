package com.example.sapeu.learncontext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private ImageView iv;
    private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        tv = new TextView(this);
//        tv.setText("学习安卓的Context");
//        tv.setText(R.string.lean_context);
//        setContentView(tv);
//        System.out.println(getResources().getText(R.string.lean_context));
//        iv = new ImageView(this);
//        iv.setImageResource(R.mipmap.ic_launcher );
//        setContentView(iv);
        System.out.println("正在创建MainActivity");
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.text);
        et = (EditText) findViewById(R.id.edit);
        tv.setText("共享的数据是"+getApp().getTextData());
        // getApplicationContext();  获取application的全局对象
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String etText = et.getText().toString();
                ((App)getApplicationContext()).setTextData(etText);
                tv.setText("共享的数据是"+etText);
            }
        });

    }

    public App getApp(){
        return (App) getApplicationContext();
    }
}
