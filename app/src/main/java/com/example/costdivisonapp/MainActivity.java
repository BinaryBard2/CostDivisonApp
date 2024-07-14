package com.example.costdivisonapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Method called when Sign Up button is clicked
    public void onSignupClick(View view) {
        Intent intent = new Intent(MainActivity.this, SignupActivity.class);
        startActivity(intent);
    }

    // Method called when Login button is clicked
    public void onLoginClick(View view) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    // Method called when Expense Entry button is clicked
    public void onExpenseEntryClick(View view) {
        Intent intent = new Intent(MainActivity.this, ExpenseEntryActivity.class);
        startActivity(intent);
    }

    // Method called when Bill Splitting button is clicked
    public void onBillSplittingClick(View view) {
        Intent intent = new Intent(MainActivity.this, BillSplittingActivity.class);
        startActivity(intent);
    }

    // Method called when Reports button is clicked
    public void onReportsClick(View view) {
        Intent intent = new Intent(MainActivity.this, ReportsActivity.class);
        startActivity(intent);
    }
}
