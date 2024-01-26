package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.delaroystudios.studentmgt.R;

public class MainActivity extends AppCompatActivity {
    EditText PersonNameET,PasswordET;
    String password,username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PersonNameET=findViewById(R.id.PersonNameET);
        PasswordET=findViewById(R.id.PasswordET);
    }



    public void Signin(View view) {
        //Method onClick pada Button

        PersonNameET = (EditText) findViewById(R.id.PersonNameET);
        PasswordET = (EditText) findViewById(R.id.PasswordET);
        Button button = (Button) findViewById(R.id.button);
        username = PersonNameET.getText().toString();
        password = PasswordET.getText().toString();


        if ((username.contains("Username")) && ((password.contains("Password"))))
        {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, IGNITION.class);
            startActivity(intent);
        }
        else if ((username.matches("") || password.matches("")))
        {

            Toast.makeText(this, "Fill the Username and Password", Toast.LENGTH_SHORT).show();

        }
        else
        {


            Toast.makeText(this, "Username Password incorrect", Toast.LENGTH_SHORT).show();
        }

    }



}