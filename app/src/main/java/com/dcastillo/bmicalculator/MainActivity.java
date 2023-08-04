package com.dcastillo.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Class Variables, also called fields
    private TextView resultText;
    private Button calculateButton;
    private RadioButton maleButton;
    private RadioButton femaleButton;
    private EditText ageEditText;
    private EditText heightEditText;
    private EditText weightEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();
    }

    private void findViews(){
        resultText = findViewById(R.id.text_view_result);
        resultText.setText("Wohoo, I can update my textview using programming code - I'm a real developer!");
        maleButton = findViewById(R.id.radio_button_male);
        femaleButton = findViewById(R.id.radi_button_female);
        ageEditText = findViewById(R.id.edit_text_age);
        heightEditText = findViewById(R.id.edit_text_height);
        weightEditText = findViewById(R.id.edit_text_weight);
        calculateButton = findViewById(R.id.button_calculate);
    }

    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBmi();
            }
        });
    }

    private void calculateBmi() {
        String ageText = ageEditText.getText().toString();
        String heightText = heightEditText.getText().toString();
        String weightText = weightEditText.getText().toString();

        //Converting the the strings to int
        int age = Integer.parseInt(ageText);
        double height = Double.parseDouble(heightText);
        int weight = Integer.parseInt(weightText);

        double heightInMeters = height / 100;

        //Formula
        double bmi = weight/(heightInMeters*heightInMeters);

        //We must convert the decimal to string
        String bmiTextResult = String.valueOf(bmi);
        resultText.setText(bmiTextResult);
    }
}