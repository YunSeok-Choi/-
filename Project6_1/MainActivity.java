package com.example.project6_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Chronometer chronometer;
    private Button start;
    private Button stop;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private  CalendarView calendar;
    private  TimePicker time;
    private TextView result;
    private String years, months, days, hour, min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = (Chronometer)findViewById(R.id.chronometer);
        start = (Button)findViewById(R.id.start);
        stop = (Button)findViewById(R.id.stop);
        radioButton1 = (RadioButton)findViewById(R.id.radiobutton1);
        radioButton2 = (RadioButton)findViewById(R.id.radiobutton2);
        calendar = (CalendarView)findViewById(R.id.calendar);
        time = (TimePicker)findViewById(R.id.time);
        result = (TextView)findViewById(R.id.result);

        calendar.setVisibility(View.INVISIBLE);
        time.setVisibility(View.INVISIBLE);

        radioButton1.setOnClickListener(this);
        radioButton2.setOnClickListener(this);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                 years = Integer.toString(year);
                 months = Integer.toString(month + 1);
                 days = Integer.toString(dayOfMonth);
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.radiobutton1 :
                calendar.setVisibility(View.VISIBLE);
                time.setVisibility(View.INVISIBLE);
                break;
            case R.id.radiobutton2 :
                calendar.setVisibility(View.INVISIBLE);
                time.setVisibility(View.VISIBLE);
                break;
            case R.id.start :
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
                break;
            case R.id.stop :
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);
                hour = Integer.toString(time.getCurrentHour());
                min = Integer.toString(time.getCurrentMinute());
                result.setText(years + "년 "+ months + "월 " + days + "일 " + hour + "시 " + min + "분 ");
                break;
        }
    }
}