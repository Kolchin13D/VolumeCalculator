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

public class activity_prism extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prism);

        Button getResult = findViewById(R.id.Prism_btn);
        EditText enterL = findViewById(R.id.PrismL);
        EditText enterW = findViewById(R.id.PrismW);
        EditText enterH = findViewById(R.id.PrismH);

        getResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prismL = enterL.getText().toString();
                String prismW = enterW.getText().toString();
                String prismH = enterH.getText().toString();
                int figure = 3;

                Intent GetResultPage = new Intent(getApplicationContext(), ResultPage.class);

                GetResultPage.putExtra("figure", figure);
                GetResultPage.putExtra("prismL", prismL);
                GetResultPage.putExtra("prismW", prismW);
                GetResultPage.putExtra("prismH", prismH);

                startActivity(GetResultPage);
            }
        });
    }
}