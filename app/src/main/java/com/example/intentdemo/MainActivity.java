package com.example.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    Button btn;
    String username;
    String rollNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initializeViews();
        initializeListeners();

    }


    private void initializeViews() {

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        btn = findViewById(R.id.btn);
    }
    private void initializeListeners() {
        btn.setOnClickListener(new MybtnClickListner());

    }

    private class MybtnClickListner implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);

            username = editText1.getText().toString();
            rollNumber = editText2.getText().toString();

            intent.putExtra("name",username);
            intent.putExtra("rollno",rollNumber);

            startActivityForResult(intent,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();
        int value = bundle.getInt("KEY1");
        Log.e("tag",value + "");
    }
}