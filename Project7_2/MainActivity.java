package com.example.project7_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity {

    private Button backButton, transButton;
    private LinearLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        back = (LinearLayout)findViewById(R.id.back);
        backButton = (Button)findViewById(R.id.backButton);
        transButton = (Button)findViewById(R.id.transButton);

        registerForContextMenu(backButton);
        registerForContextMenu(transButton);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        if(v==backButton){
            menu.setHeaderTitle("배경색 변경");
            menuInflater.inflate(R.menu.menu1,menu);
        }
        if(v==transButton)
            menuInflater.inflate(R.menu.menu2,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.itemRed :
                back.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen :
                back.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemBlue :
                back.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.subRotate :
                transButton.setRotation(45);
                return true;
            case R.id.subSize :
                transButton.setScaleX(2);
                backButton.setScaleX(2);
                return true;

        }
        return false;
    }
}