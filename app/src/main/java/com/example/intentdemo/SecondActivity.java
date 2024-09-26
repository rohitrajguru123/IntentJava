package com.example.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView textView,textView11;
    Button btnn;
    String name;
    String rollNum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondlayout);

        initializeView();
        extractData();
        initializeListners();
    }


    private void initializeView() {
        textView = findViewById(R.id.textView);
        textView11 = findViewById(R.id.textView11);
        btnn = findViewById(R.id.btnn);



    }


    private void extractData() {

        Intent i = getIntent();
        name = i.getStringExtra("name");
        rollNum = i.getStringExtra("rollno");

        textView.setText(name);
        textView11.setText(rollNum);

    }
    private void initializeListners() {
        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("KEY1",101);

                setResult(1,i);
                finish();
            }
        });

    }


}
