package com.example.sapeu.learnservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.start_service).setOnClickListener(this);
        findViewById(R.id.stop_service).setOnClickListener(this);
        findViewById(R.id.bind_service).setOnClickListener(this);
        findViewById(R.id.unbind_service).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        intent = new Intent(MainActivity.this,MyService.class);
        switch (view.getId()){
            case R.id.start_service:
                startService(intent);
                break;
            case R.id.stop_service:
                stopService(intent);
                break;
            case R.id.bind_service:
                bindService(intent,this,BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                unbindService(this);
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        System.out.println("服务绑定执行onServiceConnected");
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        System.out.println("服务奔溃或者被清除执行onServiceDisconnected");
    }
}
