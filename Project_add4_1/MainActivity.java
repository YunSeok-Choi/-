package com.example.project4_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText num1, num2;
    private Button sum, min, mul, dev, devre;
    private TextView result;
    private String r1, r2;
    private Double r;

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
        devre = (Button)findViewById(R.id.devre);

        result = (TextView)findViewById(R.id.result);

        sum.setOnClickListener(this);
        min.setOnClickListener(this);
        mul.setOnClickListener(this);
        dev.setOnClickListener(this);
        devre.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        r1 = num1.getText().toString();
        r2 = num2.getText().toString();

        if(r1 == null || r2 == null)
            Toast.makeText(getApplicationContext(),"값을 넣어주세요",Toast.LENGTH_SHORT).show();
        else {
            switch (v.getId()) {
                case R.id.sum:
                    r = Double.parseDouble(r1) + Double.parseDouble(r2);
                    result.setText("계산결과 : " + r.toString());
                    break;
                case R.id.min:
                    r = Double.parseDouble(r1) - Double.parseDouble(r2);
                    result.setText("계산결과 : " + r.toString());
                    break;
                case R.id.mul:
                    r = Double.parseDouble(r1) * Double.parseDouble(r2);
                    result.setText("계산결과 : " + r.toString());
                    break;
                case R.id.dev:
                    r = Double.parseDouble(r1) / Double.parseDouble(r2);
                    result.setText("계산결과 : " + r.toString());
                    break;
                case R.id.devre:
                    if(r2 == "0")
                        break;
                    else {
                        r = Double.parseDouble(r1) % Double.parseDouble(r2);
                        result.setText("계산결과 : " + r.toString());
                        break;
                    }
            }
        }
    }
}