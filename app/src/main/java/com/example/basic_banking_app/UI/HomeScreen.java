package com.example.basic_banking_app.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.basic_banking_app.R;

import static com.example.basic_banking_app.R.raw.banking_welome;

public class HomeScreen extends AppCompatActivity {
    ImageView bankLogo;
    TextView tvBankTitle;
    Button btnAllUsers, btnAllTransactions;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        bankLogo = findViewById(R.id.animation_view);
        btnAllUsers = findViewById(R.id.all_users);
        btnAllTransactions = findViewById(R.id.all_transactions);
        tvBankTitle = findViewById(R.id.bank_title);

    }

    public void showAllUsers(View view) {

        Intent intent=new Intent(HomeScreen.this,UsersList.class);
        startActivity(intent);

    }

    public void showAllTransactions(View view) {
        Intent intent=new Intent(HomeScreen.this,Transaction_history.class);
        startActivity(intent);
    }
}