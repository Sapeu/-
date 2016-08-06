package com.example.sapeu.sendargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.send_args).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
//                i.putExtra("data","这是一个数据");
//                Bundle b = new Bundle();
//                b.putString("name","大家都知道");
//                b.putInt("age",25);
//                i.putExtra("data",b);
//                i.putExtras(b);
                i.putExtra("user",new User("大家都知道",25));
//                startActivity(i);
                startActivityForResult(i, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView t = (TextView) findViewById(R.id.text);
        if (data != null){
            t.setText("另一个Activity返回的数据"+data.getStringExtra("data"));
        }
    }
}
