package com.example.lesson221206;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.lesson221206.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private final static String PREFS = "MyPrefs";
    private final static String KEY_TEXT = "KeyText";
    private ActivityMainBinding binding;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences(PREFS, MODE_PRIVATE);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.load.setOnClickListener(view -> loadClick());
        binding.save.setOnClickListener(view -> saveClick());
        binding.remove.setOnClickListener(view -> removeClick());
    }

    private void removeClick() {
        preferences.edit().remove(KEY_TEXT).apply();
    }

    private void saveClick() {
        String text = binding.input.getText().toString();
        preferences.edit().putString(KEY_TEXT, text).apply();

    }

    private void loadClick() {
        String text = preferences.getString(KEY_TEXT, "");
        binding.input.setText(text);
    }
}