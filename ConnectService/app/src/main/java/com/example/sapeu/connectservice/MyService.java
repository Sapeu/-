package com.example.sapeu.connectservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    private boolean running = false;
    private String data = "这是默认信息";

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        /*// TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");*/
        return new Binder();
    }

    public class Binder extends android.os.Binder{
        public void setData(String data){
            MyService.this.data = data;
        }

        public MyService getService(){
            return MyService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        data = intent.getStringExtra("data");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        running = true;
        new Thread(){
            @Override
            public void run() {
                super.run();
                int i = 0;
                while (running){
                    i++;
                    String string = i+":"+data;
                    System.out.println(string);
                    if(null != callBack){
                        callBack.onDataChange(string);
                    }
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        running = false;
    }
    private CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public CallBack getCallBack() {
        return callBack;
    }

    public static interface CallBack{
        void onDataChange(String data);
    }
}
