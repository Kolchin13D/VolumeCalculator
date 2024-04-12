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

public class activity_cube extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);

        Button getResult = findViewById(R.id.cube_btn);
        EditText enterVolume = findViewById(R.id.CubeEditText);

        getResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  cubeH = enterVolume.getText().toString();
                //int finalValue = Integer.parseInt(value);
                int figure = 1;

                Intent GetResultPage = new Intent(getApplicationContext(), ResultPage.class);

                GetResultPage.putExtra("figure", figure);
                GetResultPage.putExtra("cubeH", cubeH);

                startActivity(GetResultPage);
            }
        });
    }
}