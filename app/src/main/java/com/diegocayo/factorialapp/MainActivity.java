package com.diegocayo.factorialapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText numberText = findViewById(R.id.numberText);
        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                String numberStr = String.valueOf(numberText.getText());
                String result = calculateFactorial(numberStr);
                TextView resultNumber = findViewById(R.id.resultNumber);
                resultNumber.setText(result);
            }
        });
    }

    private String calculateFactorial (String numberStr) {
        int numberInt = Integer.parseInt(numberStr);
        int factorial = 1;
        for (int i = 2; i <= numberInt; i++) {
            factorial *= i;
        }
        String finalNumber = String.valueOf(factorial);
        return finalNumber;
    }
}