package com.example.volumecalculator.figures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.volumecalculator.MainActivity;
import com.example.volumecalculator.R;
import com.example.volumecalculator.ResultPage;

public class activity_sphere extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);

        Button getResult = findViewById(R.id.sph_btn);
        EditText enterVolume = findViewById(R.id.SphereEditText);

        getResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sphereR = enterVolume.getText().toString();
                int figure = 4;

                Intent GetResultPage = new Intent(getApplicationContext(), ResultPage.class);

                GetResultPage.putExtra("figure", figure);
                GetResultPage.putExtra("spR", sphereR);

                startActivity(GetResultPage);
            }
        });
    }
}