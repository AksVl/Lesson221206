package com.example.lesson221206;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.lesson221206.databinding.ActivityShowTextBinding;

public class ShowText extends AppCompatActivity {
    private final static String ARG_TEXT = "ARG_TEXT";
    private ActivityShowTextBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowTextBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String textFromExtra = getIntent().getStringExtra(ARG_TEXT);
        binding.secondActivityText.setText(textFromExtra);
    }
}