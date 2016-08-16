package com.example.sapeu.learnwidget;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class ChooseDateActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_date);
        button = (Button) findViewById(R.id.choose_date);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(ChooseDateActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        String theDate = String.format("%d-%d-%d",year,monthOfYear+1,dayOfMonth);
                        button.setText(theDate);
                        System.out.println(theDate);
                    }
                },2016,7,16).show();
            }
        });
    }
}
