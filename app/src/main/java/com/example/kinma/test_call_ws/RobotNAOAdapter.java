package com.example.kinma.test_call_ws;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.kinma.test_call_ws.model.NAO;

import java.util.List;

public class RobotNAOAdapter extends ArrayAdapter<NAO> {

    public RobotNAOAdapter(Context context, List<NAO> nao) {
        super(context, 0, nao);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_robotnao,parent, false);
        }

        RobotNAOViewHolder viewHolder = (RobotNAOViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new RobotNAOViewHolder();
            viewHolder.nom_robotnao = (TextView) convertView.findViewById(R.id.nom_eleve);
            viewHolder.ip_robotnao = (TextView) convertView.findViewById(R.id.ip_robotnao);
            viewHolder.label_etat_batterie = (TextView) convertView.findViewById(R.id.label_etat_batterie);
            viewHolder.label_etat_moteur = (TextView) convertView.findViewById(R.id.label_etat_moteur);
            viewHolder.etat_batterie = (ImageView) convertView.findViewById(R.id.etat_batterie);
            viewHolder.etat_moteur = (ImageView) convertView.findViewById(R.id.etat_moteur);
            viewHolder.nbr_parties = (TextView) convertView.findViewById(R.id.nbr_parties);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        NAO nao = getItem(position);
        viewHolder.nom_robotnao.setText(nao.getNom());
        viewHolder.ip_robotnao.setText(nao.getIp());
        viewHolder.label_etat_batterie.setText("Batterie :");
        viewHolder.label_etat_moteur.setText("Moteur :");
        viewHolder.nbr_parties.setText(nao.getNbr_partie()+" Parties terminés");
        if(nao.getEtat_batterie()==1){

            viewHolder.etat_batterie.setImageResource(R.drawable.ok);
        }else {
            viewHolder.etat_batterie.setImageResource(R.drawable.no);
        }

        if(nao.getEtat_moteur()==1){

            viewHolder.etat_moteur.setImageResource(R.drawable.ok);
        }else {
            viewHolder.etat_moteur.setImageResource(R.drawable.no);
        }

        return convertView;
    }

    private class RobotNAOViewHolder{
        public TextView nom_robotnao;
        public TextView ip_robotnao;
        public TextView label_etat_batterie;
        public TextView label_etat_moteur;
        public TextView nbr_parties;
        public ImageView etat_batterie;
        public ImageView etat_moteur;


    }
}



