package com.example.sapeu.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText(String.format("任务栈编号（TaskID）：%d\n当前Activity编号：%s",getTaskId(),toString()));
        findViewById(R.id.start_self).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this,Main2Activity.class));
            }
        });
        findViewById(R.id.start_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
            }
        });
    }
}
