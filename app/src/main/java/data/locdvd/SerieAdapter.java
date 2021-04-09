package data.locdvd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dvdloc_therasse.R;

public class SerieAdapter extends ArrayAdapter<Serie> {
    //Ajout methode FilmAdapter qui prend comme parametre Conntext et un int
    public SerieAdapter(Context context, int textViewRessourceId){
        super(context, textViewRessourceId);
    }
    @Override
    //Surcharge de la methode getView pour prise en compte du LinearLayout specifique ligne.xml
    public View getView(int position, View convertView, ViewGroup parent) {
        View result = convertView;
        if (convertView == null) {
            result = LayoutInflater.from(getContext()).inflate(R.layout.ligne, parent, false);
        }
        Serie uneSerie = getItem(position);

        //Assigner aux textView les valeurs obtenues par les get de la classe Serie
        TextView titre = result.findViewById(R.id.titre);
        titre.setText(uneSerie.getTitre());

        TextView realisateur = result.findViewById(R.id.realisateur);
        realisateur.setText(uneSerie.getRealisateur());

        ImageView imageview = result.findViewById(R.id.ligne_img);
        imageview.setImageResource(uneSerie.getImg());
        return result;
    }

    //Notification a la vue principale des changements de la ListView
    public void updateData() { this.notifyDataSetChanged(); }
}