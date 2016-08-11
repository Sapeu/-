package com.example.sapeu.learnbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    public static final String MY_RECEIVER_ACTION = "com.example.sapeu.learnbroadcastreceiver.intent.action.MyReceiver";
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        System.out.println("MyReceiver接收到了消息:"+intent.getStringExtra("message"));
    }
}
