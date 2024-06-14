package com.curso.android.app.practica.volumecalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cube extends AppCompatActivity {

    EditText et_cube_side;
    Button bt_calculate;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cube);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        et_cube_side = findViewById(R.id.et_cube_side);
        bt_calculate = findViewById(R.id.bt_calculate_cube);
        tv_result = findViewById(R.id.tv_volume_cube);

        // Set click listener for the button
        bt_calculate.setOnClickListener(v -> {
            // Get the side length from the EditText
            String side = et_cube_side.getText().toString();

            // Check if the input is valid
            if (side.isEmpty()) {
                tv_result.setText("Please enter a valid number.");
            } else {
                // Convert the input to a double
                double cubeSide = Double.parseDouble(side);

                // Calculate the volume
                double volume = cubeSide * cubeSide * cubeSide;

                // Display the result
                tv_result.setText("Volume: " + volume);

            }

        });

    }
}