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

public class ExerciceAdapter extends ArrayAdapter<NAO> {

    public ExerciceAdapter(Context context, List<NAO> nao) {
        super(context, 0, nao);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_exercice,parent, false);
        }

        RobotNAOViewHolder viewHolder = (RobotNAOViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new RobotNAOViewHolder();
            viewHolder.nom_robotnao = (TextView) convertView.findViewById(R.id.nom_eleve);
            viewHolder.ip_robotnao = (TextView) convertView.findViewById(R.id.ip_robotnao);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        NAO nao = getItem(position);
        viewHolder.nom_robotnao.setText(nao.getNom());
        viewHolder.ip_robotnao.setText(nao.getIp());
        return convertView;
    }

    private class RobotNAOViewHolder{
        public TextView nom_robotnao;
        public TextView ip_robotnao;
    }
}



