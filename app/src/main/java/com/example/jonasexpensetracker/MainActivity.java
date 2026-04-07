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
                    viewModel.onInputAmountChanged(charSequence.toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        binding.addExpenseButton.setOnClickListener(v->{
            int amount=viewModel.getInputAmount();
            viewModel.addExpense(amount);
        });
    }

    private void setupObservers(){
        viewModel.getTotalAmount().observe(this,total->{
            binding.showTotalAmountSpend.setText("Gesamter Betrag: \n"+String.valueOf(total)+"€");
        });

    }

}