package com.example.jonasexpensetracker;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.jonasexpensetracker.databinding.ActivityInitialBinding;

public class InitialActivity extends AppCompatActivity {
    private ActivityInitialBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityInitialBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
