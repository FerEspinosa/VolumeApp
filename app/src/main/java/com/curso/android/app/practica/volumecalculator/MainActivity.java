package com.curso.android.app.practica.volumecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 1- Adapter View: GridView
    GridView gridView;

    // 2- Data Source: ArrayList
    ArrayList <Shape> shapeArrayList;

    // 3- Adapter: MyCustomAdapter
    MyCustomAdapter myCustomAdapter;



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

        gridView = findViewById(R.id.my_grid_view);
        shapeArrayList = new ArrayList<>();

        Shape s1 = new Shape("Sphere", R.drawable.sphere);
        Shape s2 = new Shape("Cylinder", R.drawable.cylinder);
        Shape s3 = new Shape("Cube", R.drawable.cube);
        Shape s4 = new Shape("Prism", R.drawable.prism);

        shapeArrayList.add(s1);
        shapeArrayList.add(s2);
        shapeArrayList.add(s3);
        shapeArrayList.add(s4);

        myCustomAdapter = new MyCustomAdapter(getApplicationContext(), shapeArrayList);
        gridView.setAdapter(myCustomAdapter);
        gridView.setNumColumns(2);

        // OnItemClickListener
        gridView.setOnItemClickListener((parent, view, position, id) -> {

            // switch cases for different shapes
            switch (position) {
                case 0:
                    Intent intent1 = new Intent(getApplicationContext(), Sphere.class);
                    startActivity(intent1);
                    break;
                case 1:
                    Intent intent2 = new Intent(getApplicationContext(), Cylinder.class);
                    startActivity(intent2);
                    break;
                case 2:
                    Intent intent3 = new Intent(getApplicationContext(), Cube.class);
                    startActivity(intent3);
                    break;
                case 3:
                    Intent intent4 = new Intent(getApplicationContext(), Prism.class);
                    startActivity(intent4);
                    break;
            }

        });

    }
}