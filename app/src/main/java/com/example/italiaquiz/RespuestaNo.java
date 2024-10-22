package com.example.italiaquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RespuestaNo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_respuesta_no);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button restartBtn = findViewById(R.id.restartBtn);
        Button continueBtn = findViewById(R.id.continueBtn);
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RespuestaNo.this,"Restarting...", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(RespuestaNo.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                int points = intent.getIntExtra("myPoints",0);
                String page = intent.getStringExtra("myPage");

                switch (page) {
                    case "1": {
                        Intent myIntent = new Intent(RespuestaNo.this, Pregunta2.class);
                        myIntent.putExtra("myPoints", points);
                        startActivity(myIntent);
                        break;
                    }
                    case "2": {
                        Intent myIntent = new Intent(RespuestaNo.this, Pregunta3.class);
                        myIntent.putExtra("myPoints", points);
                        startActivity(myIntent);
                        break;
                    }
                    case "3": {
                        Intent myIntent = new Intent(RespuestaNo.this, Pregunta4.class);
                        myIntent.putExtra("myPoints", points);
                        startActivity(myIntent);
                        break;
                    }
                    case "4": {
                        Intent myIntent = new Intent(RespuestaNo.this, Pregunta5.class);
                        myIntent.putExtra("myPoints", points);
                        startActivity(myIntent);
                        break;
                    }
                    case "5": {
                        Intent myIntent = new Intent(RespuestaNo.this, Final.class);
                        myIntent.putExtra("myPoints", points);
                        startActivity(myIntent);
                        break;
                    }
                }
            }
        });
    }
}