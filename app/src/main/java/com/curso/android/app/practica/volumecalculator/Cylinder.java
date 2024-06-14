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

public class Cylinder extends AppCompatActivity {

    // declare variables
    EditText et_radius, et_height;
    Button btn_calculate;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cylinder);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // initialize variables
        et_radius = findViewById(R.id.et_cylinder_radius);
        et_height = findViewById(R.id.et_cylinder_height);
        btn_calculate = findViewById(R.id.bt_calculate_cylinder);
        tv_result = findViewById(R.id.tv_cylinder_volume);

        // set click listener
        btn_calculate.setOnClickListener(v -> {
            // get user input
            double radius = Double.parseDouble(et_radius.getText().toString());
            double height = Double.parseDouble(et_height.getText().toString());

            // calculate volume
            double volume = Math.PI * radius * radius * height;

            // display result
            tv_result.setText("Volume: " + volume);
        });


    }
}