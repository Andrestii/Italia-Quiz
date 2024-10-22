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

public class Pregunta2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pregunta2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button1 = findViewById(R.id.buttonImg1);
        Button button2 = findViewById(R.id.buttonImg2);
        Button button3 = findViewById(R.id.buttonImg3);
        Button button4 = findViewById(R.id.buttonImg4);

        button1.setOnClickListener(new View.OnClickListener() { // WRONG
            @Override
            public void onClick(View view) {
                Toast.makeText(Pregunta2.this,"Incorrecto", Toast.LENGTH_LONG).show();
                Intent intent = getIntent();
                int points = intent.getIntExtra("myPoints",0);
                String page = "2";

                Intent myIntent = new Intent(Pregunta2.this, RespuestaNo.class);
                points-=2;
                myIntent.putExtra("myPoints", points);
                myIntent.putExtra("myPage", page);
                startActivity(myIntent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() { // CORRECT

            @Override
            public void onClick(View view) {
                Toast.makeText(Pregunta2.this,"Correcto", Toast.LENGTH_LONG).show();

                Intent intent = getIntent();
                int points = intent.getIntExtra("myPoints",0);

                Intent myIntent = new Intent(Pregunta2.this, Pregunta3.class);
                points+=3;
                myIntent.putExtra("myPoints", points);
                startActivity(myIntent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() { // WRONG
            @Override
            public void onClick(View view) {
                Toast.makeText(Pregunta2.this,"Incorrecto", Toast.LENGTH_LONG).show();
                Intent intent = getIntent();
                int points = intent.getIntExtra("myPoints",0);
                String page = "2";

                Intent myIntent = new Intent(Pregunta2.this, RespuestaNo.class);
                points-=2;
                myIntent.putExtra("myPoints", points);
                myIntent.putExtra("myPage", page);
                startActivity(myIntent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() { // WRONG
            @Override
            public void onClick(View view) {
                Toast.makeText(Pregunta2.this,"Incorrecto", Toast.LENGTH_LONG).show();
                Intent intent = getIntent();
                int points = intent.getIntExtra("myPoints",0);
                String page = "2";

                Intent myIntent = new Intent(Pregunta2.this, RespuestaNo.class);
                points-=2;
                myIntent.putExtra("myPoints", points);
                myIntent.putExtra("myPage", page);
                startActivity(myIntent);
            }
        });
    }
}