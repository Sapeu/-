package com.example.sapeu.app1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.to_app_my_aty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    startActivity(new Intent("com.example.sapeu.learnintent.action.MYATY", Uri.parse("app://hello")));
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"无法启动指定的Activity",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
