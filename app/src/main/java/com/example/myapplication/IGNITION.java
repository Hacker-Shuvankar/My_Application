package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.delaroystudios.studentmgt.R;
public class IGNITION extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ignition);
    }

    public void AddStudent(View view) {
        Intent intent = new Intent(this, ADDSTUDENT.class);
        startActivity(intent);
    }
    public void ListStudent(View view) {
        Intent intent = new Intent(this, StudentsList.class);
        startActivity(intent);
    }
}