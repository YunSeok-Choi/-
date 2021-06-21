package com.example.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout l;
        CheckBox checkBox;
        RadioGroup r;
        RadioButton r1,r2,r3;
        Button b;
        ImageView i;

        l = (LinearLayout)findViewById(R.id.l1);
        checkBox = (CheckBox)findViewById(R.id.c);
        r = (RadioGroup)findViewById(R.id.group);
        r1 = (RadioButton)findViewById(R.id.p1);
        r2 = (RadioButton)findViewById(R.id.p2);
        r3 = (RadioButton)findViewById(R.id.p3);
        b = (Button)findViewById((R.id.b));
        i = (ImageView)findViewById(R.id.mp);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBox.isChecked() == true)
                    l.setVisibility(View.VISIBLE);
                else
                    l.setVisibility(View.INVISIBLE);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(r.getCheckedRadioButtonId()){
                    case R.id.p1 :
                        i.setImageResource(R.drawable.cream);
                        break;
                    case R.id.p2 :
                        i.setImageResource((R.drawable.dan));
                        break;
                    case R.id.p3 :
                        i.setImageResource(R.drawable.back);
                        break;
                }
            }
        });
    }
}