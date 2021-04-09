package com.example.dvdloc_therasse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import data.locdvd.Serie;
import data.locdvd.SerieAdapter;

public class Docu extends AppCompatActivity {

    private ListView listDocumentaire;
    private SerieAdapter adapterDoc;

    public String lireLeJSON(){
        StringBuilder builder = new StringBuilder();
        AssetManager assetManager;
        InputStreamReader isr;
        BufferedReader data;

        try{
            assetManager = getAssets();
            isr = new InputStreamReader(assetManager.open("documentaire.json"));
            data = new BufferedReader(isr);
            String line;
            while ((line = data.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return builder.toString();//donnee JSON au format chaine
    }//fin de la methode lireleJSON

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docu);

        listDocumentaire = findViewById(R.id.list_documentaires);
        Log.i( "LocDVD", "Vu Documentaire");
        adapterDoc = new SerieAdapter(this, R.layout.ligne);

        String strJSON = lireLeJSON();
        try{
            JSONArray jsonArray = new JSONArray(strJSON);
            //creation et alimentation d un tableau JSON avec la chaine de caracteres
            Log.i(Docu.class.getName(), "Nombre d'enregistrements :" + jsonArray.length());
            for (int i = 0; i < jsonArray.length(); i++){//parcours du tableau JSON
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Serie docu = new Serie();

                docu.setCat(jsonObject.getString("cat"));
                docu.setTitre(jsonObject.getString( "titre"));
                docu.setRealisateur(jsonObject.getString( "realisateur"));
                String path = getPackageName() + ":drawable/" + jsonObject.getString( "img");
                int resID = getResources().getIdentifier(path, null, null);
                Log.i(Docu.class.getName(), "ID image " + resID);
                docu.setImg(resID);
                adapterDoc.add(docu);//on ajoute le nouveau film a adapterFilm
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        listDocumentaire.setAdapter(adapterDoc);

        //Gestion du bouton btnRetour
        final Button btnRetourDocu = (Button) findViewById(R.id.btnRetourDocu);
        //Utilisation d'un listener pour récupérer l'interaction avec le bouton
        btnRetourDocu.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View arg0) {
                //Lance l'activité qui affiche la fenêtre Docu
                Intent intent = new Intent(Docu.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}