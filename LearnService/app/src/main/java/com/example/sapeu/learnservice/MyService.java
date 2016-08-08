package com.example.sapeu.learnservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    private boolean serviceRuning = true;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        /*// TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");*/
        return new Binder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("服务在执行onStartCommand");
        new Thread(){
            @Override
            public void run() {
                super.run();
                while (serviceRuning){
                    System.out.println("服务正在运行。。。");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        System.out.println("服务在执行onCreate");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        System.out.println("服务在执行onDestroy");
        serviceRuning = false;
        super.onDestroy();
    }
}
