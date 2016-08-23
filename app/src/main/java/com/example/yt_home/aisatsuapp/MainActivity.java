package com.example.yt_home.aisatsuapp;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;
    int hourOfDayVal = 13;
    //int minuteVal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            Aisatsu();
        } else if (v.getId() == R.id.button2) {
            showTimePickerDialog();
        }
    }

    //TimePickerDialogで設定した時刻に応じてTextViewに表示されるあいさつを変化させる
    //2:00 ~ 9:59 では「おはよう」
    //10:00 ~ 17:59 では「こんにちは」
    //18:00 ~ 1:59 では「こんばんは」
    private void Aisatsu() {
        String str;

        if((hourOfDayVal >= 2) && (hourOfDayVal < 10))
        {
            str = "おはよう";
        }
        else if((hourOfDayVal) >= 10 && (hourOfDayVal < 18))
        {
            str = "こんにちは";
        }
        else
        {
            str = "こんばんは";
        }

        mTextView.setText(str);
    }

    //時刻を設定
    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        hourOfDayVal = hourOfDay;
                        //minuteVal = minute;
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }

}
