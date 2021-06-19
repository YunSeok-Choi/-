package com.example.project4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private EditText num1, num2;
    private Button sum, min, mul, dev;
    private TextView result;
    private String r1, r2;
    private Integer r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);

        sum = (Button)findViewById(R.id.sum);
        min = (Button)findViewById(R.id.min);
        mul = (Button)findViewById(R.id.mul);
        dev = (Button)findViewById(R.id.dev);

        result = (TextView)findViewById(R.id.result);

        sum.setOnTouchListener(this);
        min.setOnTouchListener(this);
        mul.setOnTouchListener(this);
        dev.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        r1 = num1.getText().toString();
        r2 = num2.getText().toString();

        switch (v.getId()){
            case R.id.sum :
                r = Integer.parseInt(r1) + Integer.parseInt(r2);
                result.setText("계산결과 : " + r.toString());
                return false;
            case R.id.min :
                r = Integer.parseInt(r1) - Integer.parseInt(r2);
                result.setText("계산결과 : " + r.toString());
                return false;
            case R.id.mul :
                r = Integer.parseInt(r1) * Integer.parseInt(r2);
                result.setText("계산결과 : " + r.toString());
                return false;
            case R.id.dev :
                r = Integer.parseInt(r1) / Integer.parseInt(r2);
                result.setText("계산결과 : " + r.toString());
                return false;

        }
        return false;
    }
}