package com.example.volumecalculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOError;
import java.text.DecimalFormat;

public class ResultPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        //объявление полей
        TextView result_text = findViewById(R.id.result_formul);
        TextView result = findViewById(R.id.result);
        Button home = findViewById(R.id.menu);

        //получение фигуры и значения
        Bundle info_bundle = getIntent().getExtras();
        int figureID = (int) info_bundle.get("figure");
        String cube_H, cyl_R, cyl_H, prism_L, prism_W, prism_H, sp_R;
        DecimalFormat REAL_FORMATTER = new DecimalFormat("0.##");

        //расчет объема и вывод результата
        if (figureID == 1){
            cube_H = info_bundle.get("cubeH").toString();

            result_text.setText(R.string.cube_formul);
            double volume = Double.parseDouble(cube_H) * Double.parseDouble(cube_H) * Double.parseDouble(cube_H);
            result.setText(getString(R.string.cube_result) + " " + cube_H + " * " + cube_H + " * " + cube_H + " = " + REAL_FORMATTER.format(volume));
        } else if (figureID == 2) {
            cyl_R = info_bundle.get("cylR").toString();
            cyl_H = info_bundle.get("cylH").toString();

            result_text.setText(R.string.cylinder_formul);
            double volume = 3.14 * Double.parseDouble(cyl_R) * Double.parseDouble(cyl_R) * Double.parseDouble(cyl_H);
            result.setText(getString(R.string.cylinder_result) + " " + 3.14 + " * " + cyl_R + " * " + cyl_R + " * " + cyl_H + " = " + REAL_FORMATTER.format(volume));
        } else if (figureID == 3) {
            prism_L = info_bundle.get("prismL").toString();
            prism_W = info_bundle.get("prismW").toString();
            prism_H = info_bundle.get("prismH").toString();

            result_text.setText(R.string.prism_formul);
            double volume = Double.parseDouble(prism_L) * Double.parseDouble(prism_W) * Double.parseDouble(prism_H);
            result.setText(getString(R.string.prism_result) + " " + prism_L + " * " + prism_W + " * " + prism_H + " = " + REAL_FORMATTER.format(volume));
        } else if (figureID == 4){
            sp_R = info_bundle.get("spR").toString();

            result_text.setText(R.string.sphere_formul);
            double volume = 4 / 3 * 3.14 * Double.parseDouble(sp_R) * Double.parseDouble(sp_R) * Double.parseDouble(sp_R);
            result.setText(getString(R.string.sphere_result) + " " + "4 / 3 * " + 3.14 + " * " + sp_R + " * " + sp_R + " * " + sp_R + " = " + REAL_FORMATTER.format(volume));
        }

        //back to menu
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}