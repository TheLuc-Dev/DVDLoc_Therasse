package com.example.dvdloc_therasse;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Gestion du bouton btnPolicier
        final Button btnPolicier = (Button) findViewById(R.id.btnPolicier);
        //Utilisation d'un listener pour récupérer l'interaction avec le bouton
        btnPolicier.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View arg0){
                //AlertDialog (confirmation avant action)
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Policier");
                alertDialog.setMessage("Voulez-vous choisir un film policier ?");
                //Utilisation d'un listener pour récupérer l'interaction avec le bouton
                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Affichage d'un message utilisateur
                        Toast toast = Toast.makeText(getApplicationContext(), btnPolicier.getText(), Toast.LENGTH_SHORT);
                        toast.show();
                        //Lance l'activité qui affiche la fenêtre Policier
                        Intent intent = new Intent(MainActivity.this, Policier.class);
                        startActivity(intent);
                    }
                });
                alertDialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
            }
        });

        //Gestion du bouton btnFiction
        final Button btnFiction = (Button) findViewById(R.id.btnFiction);
        //Utilisation d'un listener pour récupérer l'interaction avec le bouton
        btnFiction.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View arg0){
                //AlertDialog (confirmation avant action)
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Fiction");
                alertDialog.setMessage("Voulez-vous choisir un film de Fiction ?");
                //Utilisation d'un listener pour récupérer l'interaction avec le bouton
                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Affichage d'un message utilisateur
                        Toast toast = Toast.makeText(getApplicationContext(), btnFiction.getText(), Toast.LENGTH_SHORT);
                        toast.show();
                        //Lance l'activité qui affiche la fenêtre Fiction
                        Intent intent = new Intent(MainActivity.this, Fiction.class);
                        startActivity(intent);
                    }
                });
                alertDialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
            }
        });

        //Gestion du bouton btnDocu
        final Button btnDocu = (Button) findViewById(R.id.btnDocu);
        //Utilisation d'un listener pour récupérer l'interaction avec le bouton
        btnDocu.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View arg0){
                //AlertDialog (confirmation avant action)
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Documentaire");
                alertDialog.setMessage("Voulez-vous choisir un Documentaire ?");
                //Utilisation d'un listener pour récupérer l'interaction avec le bouton
                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Affichage d'un message utilisateur
                        Toast toast = Toast.makeText(getApplicationContext(), btnDocu.getText(), Toast.LENGTH_SHORT);
                        toast.show();
                        //Lance l'activité qui affiche la fenêtre Documentaire
                        Intent intent = new Intent(MainActivity.this, Docu.class);
                        startActivity(intent);
                    }
                });
                alertDialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
            }
        });

        //Gestion du bouton btnSerie
        final Button btnSerie = (Button) findViewById(R.id.btnSerie);
        //Utilisation d'un listener pour récupérer l'interaction avec le bouton
        btnSerie.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View arg0){
                //AlertDialog (confirmation avant action)
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Serie");
                alertDialog.setMessage("Voulez-vous choisir une Serie ?");
                //Utilisation d'un listener pour récupérer l'interaction avec le bouton
                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Affichage d'un message utilisateur
                        Toast toast = Toast.makeText(getApplicationContext(), btnSerie.getText(), Toast.LENGTH_SHORT);
                        toast.show();
                        //Lance l'activité qui affiche la fenêtre Serie
                        Intent intent = new Intent(MainActivity.this, Serie.class);
                        startActivity(intent);
                    }
                });
                alertDialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
            }
        });

    }
    // Menu
    @Override
    public boolean onCreateOptionsMenu (Menu unMenu){
        //Gestion ouverture/fermeture du menugeneral (MenuInFlater)
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menugeneral, unMenu);
        return true;
    }

    //Activation des menu et des sous menus
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();

        switch (item.getItemId()){
            case R.id.MenuRechercher:
                //TODO

                //Affichage du layOut de rechercher
                Intent intentRecherche = new Intent(MainActivity.this, Recherche.class);
                startActivity(intentRecherche);
                return true;
            case R.id.MenuReserverUnFilm:
                //TODO

                //Affichage du layOut de réservation
                Intent intent = new Intent(MainActivity.this, Reservation.class);
                startActivityForResult(intent , 1);
                return true;
            case R.id.MenuMagasins:
                //TODO
                return true;
            case R.id.MenuPresentation:
                //TODO
                return true;
        }
        return true;
    }
    /**
     * Cette méthode est appelée quand un résultat parvient à l'activité
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1 : //Interessant si plusieurs requestCode,
                //ici le 1 correspond au retour depuis l'activité Reservation
                switch (resultCode){
                    case RESULT_OK:
                        Toast.makeText(MainActivity.this,
                                "Réservation confirmée", Toast.LENGTH_SHORT).show();
                        break;
                    case RESULT_CANCELED:
                        Toast.makeText(MainActivity.this,
                                "Réservation annulé", Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
        }
    }

}