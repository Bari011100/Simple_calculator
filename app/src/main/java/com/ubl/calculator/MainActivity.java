package com.ubl.calculator;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText number_1,number_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number_1 = findViewById(R.id.TxtNumber1);
        number_2 = findViewById(R.id.TxtNumber2);

        Button buttonPlus = findViewById(R.id.btnPlus);
        Button buttonMinus = findViewById(R.id.btnMinus);



        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePlusButton();
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleMinusButton();
            }
        });
    }

    private void handlePlusButton() {
        if (validateInput()) {
            int numberA = Integer.parseInt(number_1.getText().toString());
            int numberB = Integer.parseInt(number_2.getText().toString());
            int result = numberA + numberB;
            showDialog("Hasil Penjumlahan", "Hasil: " + result);
        }
    }

    private void handleMinusButton() {
        if (validateInput()) {
            int numberA = Integer.parseInt(number_1.getText().toString());
            int numberB = Integer.parseInt(number_2.getText().toString());
            int result = numberA - numberB;
            showDialog("Hasil Pengurangan", "Hasil: " + result);
        }
    }

    private boolean validateInput() {
        if (TextUtils.isEmpty(number_1.getText()) || TextUtils.isEmpty(number_2




                .getText())) {
            showDialog("Error", "Silakan masukkan kedua angka.");
            return false;
        }
        return true;
    }

    private void showDialog(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }
}