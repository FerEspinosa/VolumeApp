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

public class Prism extends AppCompatActivity {

    EditText prismWidth_et, prismHeight_et, prismDepth_et;
    Button calculate_btn;
    TextView prismVolume_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prism);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        prismWidth_et = findViewById(R.id.et_prism_width);
        prismHeight_et = findViewById(R.id.et_prism_height);
        prismDepth_et = findViewById(R.id.et_prism_depth);
        calculate_btn = findViewById(R.id.bt_calculate_prism);
        prismVolume_tv = findViewById(R.id.tv_prism_volume);

        // Set click listener for the calculate button
        calculate_btn.setOnClickListener(v -> {
            // Get user input
            double prismWidth = Double.parseDouble(prismWidth_et.getText().toString());
            double prismHeight = Double.parseDouble(prismHeight_et.getText().toString());
            double prismDepth = Double.parseDouble(prismDepth_et.getText().toString());

            // Calculate volume
            double prismVolume = calculatePrismVolume(prismWidth, prismHeight, prismDepth);

            // Display volume
            String volumeText = "Volume: " + prismVolume;
            prismVolume_tv.setText(volumeText);
        });
    }

    private double calculatePrismVolume(double prismWidth, double prismHeight, double prismDepth) {

        if (prismWidth <= 0 || prismHeight <= 0 || prismDepth <= 0) {
            return 0;
        } else {
            return prismWidth * prismHeight * prismDepth;
        }
    }

}