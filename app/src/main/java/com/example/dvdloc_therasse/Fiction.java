package com.example.dvdloc_therasse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fiction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiction);

        //Gestion du bouton btnRetour
        final Button btnRetour = (Button) findViewById(R.id.btnRetour);
        //Utilisation d'un listener pour récupérer l'interaction avec le bouton
        btnRetour.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View arg0) {
                //Lance l'activité qui affiche la fenêtre Fiction
                Intent intent = new Intent(Fiction.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}