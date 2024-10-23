package com.example.italiaquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Pregunta3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pregunta3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner spinner = findViewById(R.id.spinner_main);
        Button button = findViewById(R.id.buttonSubmit3);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String selectedText = spinner.getSelectedItem().toString();
                if(selectedText.equals("Azul Claro")){
                    Toast.makeText(Pregunta3.this,"Correcto\t+3 pts", Toast.LENGTH_LONG).show();
                    Intent intent = getIntent();
                    int points = intent.getIntExtra("myPoints",0);
                    Intent myIntent = new Intent(Pregunta3.this, Pregunta4.class);
                    points+=3;
                    myIntent.putExtra("myPoints", points);
                    startActivity(myIntent);
                } else if(selectedText.equals("Null")){
                    Toast.makeText(Pregunta3.this,"Seleccione algo", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(Pregunta3.this,"Incorrecto\t-2 pts", Toast.LENGTH_LONG).show();
                    Intent intent = getIntent();
                    int points = intent.getIntExtra("myPoints",0);
                    String page = "3";

                    Intent myIntent = new Intent(Pregunta3.this, RespuestaNo.class);
                    points-=2;
                    myIntent.putExtra("myPoints", points);
                    myIntent.putExtra("myPage", page);
                    startActivity(myIntent);
                }
            }
        });

        String[] spinnerList = {"Azul Oscuro", "Rojo", "Verde", "Azul Claro"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerList);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);
    }
}