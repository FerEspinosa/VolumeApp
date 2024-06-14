package com.curso.android.app.practica.volumecalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Sphere extends AppCompatActivity {

    EditText radius_et;
    TextView volume_tv;
    Button calculate_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sphere);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        radius_et = findViewById(R.id.et_sphere_radius);
        volume_tv = findViewById(R.id.tv_volume);
        calculate_btn = findViewById(R.id.bt_calculate_sphere);

        calculate_btn.setOnClickListener(v -> {
            String radius = radius_et.getText().toString();
            if (radius.isEmpty()) {
                Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            } else {
                // call the function to calculate the volume
                calculateVolume(Integer.parseInt(radius));
            }
        });
    }

    private void calculateVolume(int r) {
        // calculate the volume (This should occur on the Presenter section of a MVP architecture)
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(r, 3);

        // update the UI with the volume (This should occur on the View section of a MVP architecture)
        String volume_str = "Volume: " + volume;
        volume_tv.setText(volume_str);
    }
}