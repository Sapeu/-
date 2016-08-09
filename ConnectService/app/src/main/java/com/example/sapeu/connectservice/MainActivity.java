package com.example.sapeu.connectservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {
    private Intent intent;
    private EditText edit;
    private MyService.Binder binder;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText)findViewById(R.id.edit);
        textView = (TextView) findViewById(R.id.tv_out);
        findViewById(R.id.start_service).setOnClickListener(this);
        findViewById(R.id.stop_service).setOnClickListener(this);
        findViewById(R.id.bind_service).setOnClickListener(this);
        findViewById(R.id.unbind_service).setOnClickListener(this);
        findViewById(R.id.save_data).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        intent = new Intent(this,MyService.class);
        switch (view.getId()){
            case R.id.start_service:
                intent.putExtra("data",edit.getText().toString());
                startService(intent);
                break;
            case R.id.stop_service:
                stopService(intent);
                break;
            case R.id.bind_service:
                bindService(intent,this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                unbindService(this);
                break;
            case R.id.save_data:
                if(null != binder){
                    binder.setData(edit.getText().toString());
                }
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        binder = (MyService.Binder) iBinder;
        binder.getService().setCallBack(new MyService.CallBack() {
            @Override
            public void onDataChange(String data) {
                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("data",data);
                message.setData(bundle);
                handler.sendMessage(message);
            }
        });
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            textView.setText(msg.getData().getString("data"));
        }
    };
}
