package com.example.dvdloc_therasse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reservation extends AppCompatActivity {

    private Button btnOk;
    private Button btnAnnuler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        // Confirmation
        btnOk = findViewById(R.id.BtnReservConfirm);
        btnOk.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View view){
                setResult(Activity.RESULT_OK);
                finish();
            }
        });

        // Annulation
        btnAnnuler = findViewById(R.id.btnReservAnnule);
        btnAnnuler.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View view){
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });

        //Gestion du bouton btnReservRetour
        final Button btnReservRetour = (Button) findViewById(R.id.btnReservRetour);
        //Utilisation d'un listener pour récupérer l'interaction avec le bouton
        btnReservRetour.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View arg0) {
                //Retour a la mainPageActivity
                Intent intent = new Intent(Reservation.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}