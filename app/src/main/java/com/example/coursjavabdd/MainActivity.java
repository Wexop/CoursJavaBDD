package com.example.coursjavabdd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonAddStudent;
    private Button buttonSeeResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAddStudent = (Button) findViewById(R.id.button_add_student);
        buttonSeeResult = (Button) findViewById(R.id.button_see_result);

        buttonAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addStudentActivity = new Intent(MainActivity.this, AddStudentActivity.class);
                startActivity(addStudentActivity);
            }
        });

        buttonSeeResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent seeResultActivity = new Intent(MainActivity.this, getResultActivity.class);
                startActivity(seeResultActivity);
            }
        });


    }
}