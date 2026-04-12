package com.example.jonasexpensetracker;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.jonasexpensetracker.databinding.ActivityListExpensesBinding;

import java.util.HashMap;

public class ListExpensesActivity extends AppCompatActivity {

    private ActivityListExpensesBinding binding;
    private ListExpensesViewModel viewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityListExpensesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel=new ViewModelProvider(this).get(ListExpensesViewModel.class);
        viewModel.setExpenses(getIntent().getStringArrayListExtra("ExpensesList"));
        showExpenses();
    }

    private void showExpenses(){
        StringBuilder sb=new StringBuilder();
        for(String item:viewModel.getExpenses()){
            sb.append(item).append("\n");
        }
        binding.expensesList.setText(sb.toString());
    }
}
