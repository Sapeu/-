package com.example.sapeu.learnbroadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MyReceiver receiver = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.send_message).setOnClickListener(this);
        findViewById(R.id.reg).setOnClickListener(this);
        findViewById(R.id.unreg).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send_message:
//                Intent intent = new Intent(this,MyReceiver.class);
                Intent intent = new Intent(MyReceiver.MY_RECEIVER_ACTION);
                intent.putExtra("message","这是我发送的消息");
//                sendBroadcast(intent);
                // 顺序发送广播
                sendOrderedBroadcast(intent,null);
                break;
            case R.id.reg:
                if (null == receiver){
                    receiver = new MyReceiver();
                    registerReceiver(receiver,new IntentFilter(MyReceiver.MY_RECEIVER_ACTION));
                }
                break;
            case R.id.unreg:
                if (null != receiver){
                    unregisterReceiver(receiver);
                    receiver = null;
                }
                break;
        }
    }
}
