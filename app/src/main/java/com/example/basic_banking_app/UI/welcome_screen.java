package com.example.basic_banking_app.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.basic_banking_app.R;

public class welcome_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        Thread thread= new Thread()
        {
            public void run()
            {
                try {
                    sleep(6000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {
                    Toast.makeText(welcome_screen.this,"WELCOME",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(welcome_screen.this,HomeScreen.class);
                    startActivity(intent);
                }
            }
        };thread.start();
    }
}