package com.example.sapeu.androidactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    
    /**
     * 创建
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        System.out.println("第二个Activity执行onCrete()方法");
        findViewById(R.id.toa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("第二个Activity正在跳到第一个Activity");
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
            }
        });
        findViewById(R.id.tod).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("第二个Activity正在跳到对话框");
                startActivity(new Intent(Main2Activity.this,Main3Activity.class));
            }
        });
    }

    /**
     * 开始
     */
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("第二个Activity执行onStart()方法");
    }

    /**
     * 恢复
     */
    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("第二个Activity执行onResume()方法");
    }

    /**
     * 暂停
     */
    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("第二个Activity执行onPause()方法");
    }

    /**
     * 停止
     */
    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("第二个Activity执行onStop()方法");
    }

    /**
     * 销毁
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("第二个Activity执行onDestroy()方法");
    }

    /**
     * 重启
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("第二个Activity执行onRestart()方法");
    }
}
