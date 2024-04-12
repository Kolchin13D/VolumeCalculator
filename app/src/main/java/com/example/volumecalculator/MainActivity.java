package com.example.volumecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.example.volumecalculator.adapters.MyAdapter;
import com.example.volumecalculator.figures.activity_cube;
import com.example.volumecalculator.figures.activity_cylinder;
import com.example.volumecalculator.figures.activity_prism;
import com.example.volumecalculator.figures.activity_sphere;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridview;
    ArrayList<Figure_class> figureArrayList;

    private static MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //data array
        figureArrayList = new ArrayList<>();
        Figure_class figure1 = new Figure_class("cube", R.drawable.cube);
        figureArrayList.add(figure1);
        Figure_class figure2 = new Figure_class("cylinder", R.drawable.cylinder);
        figureArrayList.add(figure2);
        Figure_class figure3 = new Figure_class("prism", R.drawable.prism);
        figureArrayList.add(figure3);
        Figure_class figure4 = new Figure_class("sphere", R.drawable.sphere);
        figureArrayList.add(figure4);

        //adapter
        MyAdapter adapter = new MyAdapter(figureArrayList, getApplicationContext());
        gridview = findViewById(R.id.grid_ID);
        //gridview.setNumColumns(2);

        //link listliew with adapter
        gridview.setAdapter(adapter);

        //click listener
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (adapter.getItem(position).getName() == "cube") {
                    Intent goCube = new Intent(getApplicationContext(), activity_cube.class);
                    startActivity(goCube);
                } else if (adapter.getItem(position).getName() == "cylinder") {
                    Intent goCylinder = new Intent(getApplicationContext(), activity_cylinder.class);
                    startActivity(goCylinder);
                } else if (adapter.getItem(position).getName() == "sphere") {
                    Intent goSphere = new Intent(getApplicationContext(), activity_sphere.class);
                    startActivity(goSphere);
                } else if (adapter.getItem(position).getName() == "prism") {
                    Intent goPrism = new Intent(getApplicationContext(), activity_prism.class);
                    startActivity(goPrism);
                } else if (adapter.getItem(position).getName() == null) {

                }
            }
        });

        // Creates a button that mimics a crash when pressed
        /*
        Button crashButton = new Button(this);
        crashButton.setText("Test Crash");
        crashButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                throw new RuntimeException("Test Crash"); // Force a crash
            }
        });

        addContentView(crashButton, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

         */
    }
}