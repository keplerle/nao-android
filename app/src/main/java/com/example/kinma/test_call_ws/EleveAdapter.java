package com.example.kinma.test_call_ws;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

import com.example.kinma.test_call_ws.model.Eleve;


import java.util.List;

public class EleveAdapter extends ArrayAdapter<Eleve> {

    public EleveAdapter(Context context, List<Eleve> eleve) {
        super(context, 0, eleve);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_eleve, parent, false);
        }

        EleveViewHolder viewHolder = (EleveViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new EleveViewHolder();
            viewHolder.nom_eleve = (TextView) convertView.findViewById(R.id.nom_eleve);
            viewHolder.prenom_eleve = (TextView) convertView.findViewById(R.id.prenom_eleve);
            viewHolder.classe_eleve = (TextView) convertView.findViewById(R.id.classe_eleve);
            viewHolder.bonne_reponse = (TextView) convertView.findViewById(R.id.bonne_reponse);
            viewHolder.fausse_reponse = (TextView) convertView.findViewById(R.id.fausse_reponse);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Eleve eleve = getItem(position);
        viewHolder.nom_eleve.setText(eleve.getNom());
        viewHolder.prenom_eleve.setText(eleve.getPrenom());
        viewHolder.classe_eleve.setText(eleve.getClasse());
        viewHolder.bonne_reponse.setText(Integer.toString(eleve.getBonne_reponse()));
        viewHolder.fausse_reponse.setText(Integer.toString(eleve.getFausse_reponse()));
        return convertView;
    }

    private class EleveViewHolder {
        public TextView nom_eleve;
        public TextView prenom_eleve;
        public TextView classe_eleve;
        public TextView bonne_reponse;
        public TextView fausse_reponse;

    }
}



