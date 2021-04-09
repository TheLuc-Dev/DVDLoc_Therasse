package com.example.dvdloc_therasse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Policier extends AppCompatActivity {

    public String filmPolicier[] =
            {
                    "Kill bill-Vol1",
                    "Kill bill-Vol2",
                    "Otage",
                    "Da Vinci Code",
                    "36 quai des Orfèvres",
                    "Mystic River",
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policier);

          //Création d'un adapter qui lie le tableau au Listview
         //Constructeur : contexte (this), ressource, tableau (filmPolicier)
        //La ressource est le type de Liste à afficher : bouton radio...
        final ArrayAdapter<String> adapterList = new
                ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, filmPolicier);

        //Implementation du listener dans la listview pour récupérer le titre choisi
        ListView listPolicier = (ListView)findViewById(R.id.policier_listview);
        listPolicier.setAdapter(adapterList);

        //test de chaque item
        listPolicier.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long arg3) {
                        Toast toast = Toast.makeText(getApplicationContext(),"Position :" + String.valueOf(position), Toast.LENGTH_SHORT);
                        toast.show();

                        Toast toast2 = Toast.makeText(getApplicationContext(),"Titre :" + filmPolicier[position], Toast.LENGTH_SHORT);
                        toast2.show();

                    }
                });

        //vient de recherche
        String mot = this.getIntent().getStringExtra("titre");
        TextView titreDemande = findViewById(R.id.titreDemande);
        titreDemande.setText(mot);

        //Gestion du bouton btnRetour
        final Button btnRetourPolicier = (Button) findViewById(R.id.btnRetourPolicier);
        //Utilisation d'un listener pour récupérer l'interaction avec le bouton
        btnRetourPolicier.setOnClickListener(new Button.OnClickListener()
        {
                    @Override
                    public void onClick(View arg0) {
                        //Lance l'activité qui affiche la fenêtre Policier
                        Intent intent = new Intent(Policier.this, MainActivity.class);
                        startActivity(intent);
                    }
        });
    }
}