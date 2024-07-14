package com.example.costdivisonapp;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ExpenseEntryActivity extends AppCompatActivity {
    private EditText titleEditText, amountEditText, categoryEditText, dateEditText, peopleEditText;
    private Button saveButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_entry);

        titleEditText = findViewById(R.id.titleEditText);
        amountEditText = findViewById(R.id.amountEditText);
        categoryEditText = findViewById(R.id.categoryEditText);
        dateEditText = findViewById(R.id.dateEditText);
        peopleEditText = findViewById(R.id.peopleEditText);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString().trim();
                String amount = amountEditText.getText().toString().trim();
                String category = categoryEditText.getText().toString().trim();
                String date = dateEditText.getText().toString().trim();
                String people = peopleEditText.getText().toString().trim();

                saveExpense(title, amount, category, date, people);
            }
        });
    }

    private void saveExpense(String title, String amount, String category, String date, String people) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("expenses");

        String expenseId = myRef.push().getKey();
        Expense expense = new Expense(title, amount, category, date, people);
        myRef.child(expenseId).setValue(expense);
    }
}

class Expense {
    public String title;
    public String amount;
    public String category;
    public String date;
    public String people;

    public Expense() {}

    public Expense(String title, String amount, String category, String date, String people) {
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.people = people;
    }
}
