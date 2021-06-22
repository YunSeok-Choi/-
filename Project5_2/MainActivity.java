package com.example.project5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private EditText e1, e2;
    private Button sum, min, mul, dev;
    private TextView result;
    private String num1, num2;
    private Button[] numButton = new Button[10];
    private Integer[] numID = { R.id.num0, R.id.num1,
            R.id.num2, R.id.num3, R.id.num4, R.id.num5,
            R.id.num6, R.id.num7, R.id.num8, R.id.num9
    };
    private int i;
    Integer re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("테이블레이아웃 계산기");

        e1 = (EditText)findViewById(R.id.e1);
        e2 = (EditText)findViewById(R.id.e2);
        sum = (Button)findViewById(R.id.sum);
        min = (Button)findViewById(R.id.min);
        mul = (Button)findViewById(R.id.mul);
        dev = (Button)findViewById(R.id.dev);
        result = (TextView)findViewById(R.id.result);

        sum.setOnTouchListener(this);
        min.setOnTouchListener(this);
        mul.setOnTouchListener(this);
        dev.setOnTouchListener(this);

        for(i = 0; i < numID.length; i++)
            numButton[i] = (Button)findViewById(numID[i]);

        for(i = 0; i < numID.length; i++){
            final int index;
            index = i;

            numButton[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(e1.isFocusable() == true){
                        num1 = e1.getText().toString() + numButton[index].getText().toString();
                        e1.setText((num1));
                    }else if(e2.isFocusable() == true){
                        num2 = e2.getText().toString() + numButton[index].getText().toString();
                        e2.setText(num2);
                    }else {
                        Toast.makeText(getApplicationContext(),"어느 곳에 값을 넣을 건가요?",Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        num1 = e1.getText().toString();
        num2 = e2.getText().toString();

        switch (v.getId()){
            case R.id.sum :
                re = Integer.parseInt(num1) + Integer.parseInt(num2);
                result.setText("계산결과 : " + re.toString());
                return false;
            case R.id.min :
                re = Integer.parseInt(num1) - Integer.parseInt(num2);
                result.setText("계산결과 : " + re.toString());
                return false;
            case R.id.mul :
                re = Integer.parseInt(num1) * Integer.parseInt(num2);
                result.setText("계산결과 : " + re.toString());
                return false;
            case R.id.dev :
                re = Integer.parseInt(num1) / Integer.parseInt(num2);
                result.setText("계산결과 : " + re.toString());
                return false;

        }

        return false;
    }
}