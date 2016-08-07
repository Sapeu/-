package com.example.sapeu.learncontext;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Sapeu on 2016/8/7.
 */
public class Main2Activity extends Activity {
    private TextView tv;
    private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("正在创建Main2Activity");
        setContentView(R.layout.activity_main2);
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
