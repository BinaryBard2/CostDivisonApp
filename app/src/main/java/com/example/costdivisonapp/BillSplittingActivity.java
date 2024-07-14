package com.example.costdivisonapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;




public class BillSplittingActivity extends AppCompatActivity {
    private EditText totalAmountEditText, peopleEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_splitting);

        totalAmountEditText = findViewById(R.id.totalAmountEditText);
        peopleEditText = findViewById(R.id.peopleEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String totalAmount = totalAmountEditText.getText().toString().trim();
                String people = peopleEditText.getText().toString().trim();
                calculateSplit(totalAmount, people);
            }
        });
    }

    private void calculateSplit(String totalAmount, String people) {
        double amount = Double.parseDouble(totalAmount);
        int numPeople = Integer.parseInt(people);

        double share = amount / numPeople;
        resultTextView.setText("Share per person: " + share);
    }
}
