package com.example.jonasexpensetracker;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.jonasexpensetracker.databinding.ActivityMainBinding;

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
            double amount=viewModel.getInputAmount();
            viewModel.getTotalExpenseFromModel(amount);
            viewModel.getCurrentBalanceFromModel();
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

}