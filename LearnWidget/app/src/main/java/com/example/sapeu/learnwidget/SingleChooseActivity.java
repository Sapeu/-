package com.example.sapeu.learnwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class SingleChooseActivity extends AppCompatActivity {
    private Button button;
    private RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_choose);
        button = (Button) findViewById(R.id.submit);
        radioButton = (RadioButton) findViewById(R.id.rbd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton.isChecked()){
                    Toast.makeText(SingleChooseActivity.this,"选择正确！", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(SingleChooseActivity.this,"选择错误！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
