package com.example.jonasexpensetracker;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.jonasexpensetracker.databinding.ActivityMainBinding;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewModelFactory factory=new ViewModelFactory();
        viewModel=new ViewModelProvider(this,factory).get(MainViewModel.class);
        setupListeners();
        setupObservers();

        //insert Income
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Enter your monthly income.");
        final EditText input=new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);
        builder.setPositiveButton("OK",(dialog,which)->{
            String value=input.getText().toString();
            BigDecimal number= BigDecimal.valueOf(Double.parseDouble(value));
            viewModel.setMonthlyIncome(number);
            //set currentBalance to Monthly income
            viewModel.setCurrentBalanceLiveDataInitially();
        });
        builder.show();

        // insert Date
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String currentDate= LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            binding.Date.setText(currentDate);
        }

    }

    private void setupListeners(){
        binding.inputAmountSpend.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    String input=charSequence.toString();
                    viewModel.onInputAmountChanged(input);
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        binding.addExpenseButton.setOnClickListener(v->{
            BigDecimal amount=viewModel.getInputAmount();
            viewModel.getTotalExpenseFromModel(amount);
            viewModel.getCurrentBalanceFromModel();

            //whenever a new expense was put in, ask what that expense was for
            askForExpenseReason();
        });
        binding.showExpenses.setOnClickListener(v->{
            gotoListExpensesActivity();
        });

    }

    private void setupObservers(){
        viewModel.getMonthlyIncome().observe(this,total->{
            binding.showMonthlyIncome.setText("Monthly Income: "+String.valueOf(total)+"€");
        });
        viewModel.getTotalExpense().observe(this,total->{
            binding.showTotalAmountSpend.setText("Total Expense: "+String.valueOf(total)+"€");
        });
        viewModel.getCurrentBalance().observe(this,total->{
            binding.CurrentBalance.setText("Current Balance: "+String.valueOf(total)+"€");
        });
    }
    private void askForExpenseReason(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("What was that expense spend on?");
        final EditText input=new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        builder.setPositiveButton("OK",(dialog,which)->{
          String reason=input.getText().toString();

          viewModel.setExpenses(viewModel.getInputAmount(),reason);
        });
        builder.show();
    }
    private void gotoListExpensesActivity(){
        Intent intent=new Intent(MainActivity.this, ListExpensesActivity.class);
        intent.putExtra("ExpensesList",viewModel.getExpenses());
        Log.e("testArrayList",viewModel.getExpenses().get(0));
        startActivity(intent);
    }

}