package com.example.volumecalculator.figures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.volumecalculator.R;
import com.example.volumecalculator.ResultPage;

public class activity_cylinder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder);

        Button getResult = findViewById(R.id.cyl_btn);
        EditText enterR = findViewById(R.id.CylinderR);
        EditText enterH = findViewById(R.id.CylinderH);

        getResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cylR = enterR.getText().toString();
                String cylH = enterH.getText().toString();
                int figure = 2;

                Intent GetResultPage = new Intent(getApplicationContext(), ResultPage.class);

                GetResultPage.putExtra("figure", figure);
                GetResultPage.putExtra("cylR", cylR);
                GetResultPage.putExtra("cylH", cylH);

                startActivity(GetResultPage);
            }
        });
    }
}