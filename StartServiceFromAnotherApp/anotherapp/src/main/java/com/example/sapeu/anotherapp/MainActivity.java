package com.example.sapeu.anotherapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.sapeu.startservicefromanotherapp.IAppServiceRemoteBinder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private Intent serviceIntent;
    private EditText editText;
    private IAppServiceRemoteBinder iAppServiceRemoteBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serviceIntent = new Intent();
        serviceIntent.setComponent(new ComponentName("com.example.sapeu.startservicefromanotherapp","com.example.sapeu.startservicefromanotherapp.AppService"));
        editText = (EditText) findViewById(R.id.edit);
        findViewById(R.id.start_app_service).setOnClickListener(this);
        findViewById(R.id.stop_app_service).setOnClickListener(this);
        findViewById(R.id.bind_app_service).setOnClickListener(this);
        findViewById(R.id.unbind_app_service).setOnClickListener(this);
        findViewById(R.id.sync).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_app_service:
                startService(serviceIntent);
                break;
            case R.id.stop_app_service:
                stopService(serviceIntent);
                break;
            case R.id.bind_app_service:
                bindService(serviceIntent,this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.unbind_app_service:
                iAppServiceRemoteBinder = null;
                unbindService(this);
                break;
            case R.id.sync:
                if (null != iAppServiceRemoteBinder){
                    try {
                        iAppServiceRemoteBinder.setData(editText.getText().toString());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        System.out.println("绑定外部服务执行onServiceConnected\n"+iBinder+"\n"+iBinder.toString());
        iAppServiceRemoteBinder = IAppServiceRemoteBinder.Stub.asInterface(iBinder);
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }
}
