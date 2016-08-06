package com.example.sapeu.sendargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
//        Bundle b = i.getBundleExtra("data");
//        Bundle b = i.getExtras();
        TextView tv = (TextView) findViewById(R.id.text);
//        String text = i.getStringExtra("data");
//        String text = String.format("姓名： %s\n年龄：%d\n其他：%s",b.getString("name"),b.getInt("age"),b.getString("other","其他"));
        User u = (User) i.getParcelableExtra("user");
        String text = String.format("姓名： %s\n年龄：%d\n",u.getName(),u.getAge());
        tv.setText(text);
        findViewById(R.id.send_args).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et = (EditText) findViewById(R.id.et);
                Intent si = new Intent();
                si.putExtra("data",et.getText().toString());
                setResult(1,si);
                finish();
            }
        });
    }
}
