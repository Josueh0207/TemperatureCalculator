package com.example.temperaturecalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button toFahrenheit, toCelsius;
    TextView result;
    EditText inputText;
    DecimalFormat fmt = new DecimalFormat(".##");


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toFahrenheit = (Button) findViewById(R.id.button_fahrenheit);
        toCelsius = (Button) findViewById(R.id.button_celsius);
        result = (TextView) findViewById(R.id.text_result);
        inputText = (EditText)findViewById(R.id.num_unit);

        toFahrenheit.setOnClickListener(v -> {
            float celsius = Float.parseFloat(inputText.getText().toString());
            if (celsius <= -89.2)
            {
                result.setText("New coldest temperature ever recorded on Earth! which is  " + fmt.format((celsius * 1.8000 + 32.00)) + "°F");
            }
            else if (celsius >= 56.7)
            {
                result.setText("New hottest temperature ever reached on Earth! which is  " + fmt.format((celsius * 1.8000 + 32.00)) + "°F");
            }
            else
            {
                result.setText(fmt.format(celsius) + "°C is " + fmt.format((celsius * 1.8000 + 32.00)) + " °F");
            }
        });

        toCelsius.setOnClickListener(v -> {
            float fahrenheit = Float.parseFloat(inputText.getText().toString());
            if (fahrenheit <= -128.6)
            {
                result.setText(fmt.format(fahrenheit) + "°F has reached the lowest temperature on Earth and is  " + fmt.format((((fahrenheit - 32) * 5) / 9)) + " °C");
            }
            else if (fahrenheit >= 134)
            {
                result.setText(fmt.format(fahrenheit) + "°F has passed the highest temperature ever reached on Earth and is  " + fmt.format((((fahrenheit - 32) * 5) / 9)) + " °C");
            }
            else
            {
                result.setText(fmt.format(fahrenheit) + "°F is  " + fmt.format((((fahrenheit - 32) * 5) / 9)) + " °C");
            }
        });

    }
}