package com.example.sapeu.learnwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MultipleChooseActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private CheckBox[] checkBoxes;
    private TextView textResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choose);
        checkBoxes = new CheckBox[]{
                (CheckBox) findViewById(R.id.ch1),
                (CheckBox) findViewById(R.id.ch2),
                (CheckBox) findViewById(R.id.ch3),
                (CheckBox) findViewById(R.id.ch4),
                (CheckBox) findViewById(R.id.ch5),
                (CheckBox) findViewById(R.id.ch6),
                (CheckBox) findViewById(R.id.ch7),
                (CheckBox) findViewById(R.id.ch8),
                (CheckBox) findViewById(R.id.ch9),
                (CheckBox) findViewById(R.id.ch10)
        };
        textResult = (TextView) findViewById(R.id.textResult);
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i].setOnCheckedChangeListener(this);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        String text = "你选择了";
        for (int i = 0; i < checkBoxes.length; i++) {
            if (checkBoxes[i].isChecked()){
                text += "，" + checkBoxes[i].getText().toString();
            }
        }
        textResult.setText(text);
    }
}
