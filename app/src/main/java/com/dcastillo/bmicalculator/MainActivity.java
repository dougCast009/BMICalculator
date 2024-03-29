package com.dcastillo.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

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
                double bmiResult = calculateBmi();
                String ageText = ageEditText.getText().toString();
                int age = Integer.parseInt(ageText);
                if(age >= 18){
                    displayResult((bmiResult));
                } else {
                    displayGuidance(bmiResult);
                }
            }
        });
    }

    private double calculateBmi() {
        String heightText = heightEditText.getText().toString();
        String weightText = weightEditText.getText().toString();

        //Converting the the strings to int
        double height = Double.parseDouble(heightText);
        int weight = Integer.parseInt(weightText);

        double heightInMeters = height / 100;

        //Formula
        return weight/(heightInMeters*heightInMeters);
    }

    private void displayResult(double bmi){
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;
        if(bmi < 18.5){
            //Display underweight
            fullResultString = bmiTextResult + " - You are underweight";
        } else if (bmi > 25) {
            //Display Overweight
            fullResultString = bmiTextResult + " - You are overweight";
        } else {
            //Dsiplay Healthy
            fullResultString = bmiTextResult + " - You are a healthy weight";
        }
        resultText.setText(fullResultString);
    }

    private void displayGuidance(double bmi) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;
        if(maleButton.isChecked()){
            //Dsiplay boy guidance
            fullResultString = bmiTextResult + " - As you are under 18, please consult with your doctor for the healthy range for boys";
        } else if (femaleButton.isChecked()) {
            //Display girl guidance
            fullResultString = bmiTextResult + " - As you are under 18, please consult with your doctor for the healthy range for girls";
        } else {
            //Display General Guidance
            fullResultString = bmiTextResult + " - As you are under 18, please consult with your doctor for the healthy range";
        }
        resultText.setText(fullResultString);
    }
}