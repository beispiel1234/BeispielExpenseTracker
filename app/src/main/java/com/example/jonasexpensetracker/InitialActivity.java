package com.example.jonasexpensetracker;

import android.app.Activity;
import android.content.Intent;
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

        setupListener();
    }

    private void setupListener(){
        binding.startNew.setOnClickListener(v->{
            gotoMain();
        });
    }
    private void gotoMain(){
        Intent intent=new Intent(InitialActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
