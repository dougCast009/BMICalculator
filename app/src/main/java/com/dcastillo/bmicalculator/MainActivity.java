package com.dcastillo.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView resultText = findViewById(R.id.text_view_result);

        resultText.setText("Wohoo, I can update my textview using programming code - I'm a real developer!");

        RadioButton maleButton = findViewById(R.id.radio_button_male);
        RadioButton femaleButton = findViewById(R.id.radi_button_female);

        EditText ageEditText = findViewById(R.id.edit_text_age);
        EditText heightEditText = findViewById(R.id.edit_text_height);
        EditText weightEditText = findViewById(R.id.edit_text_weight);

        Button calculateButton = findViewById(R.id.button_calculate);
    }
}