package com.example.kinma.test_call_ws.activity.RobotNAO;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kinma.test_call_ws.R;
import com.example.kinma.test_call_ws.activity.MenuActivity;
import com.example.kinma.test_call_ws.activity.RegisterProfActivity;

public class SynchroniserRobotNAOActivity extends AppCompatActivity {

    ImageView EtatConnexionRobotNAO;
    EditText EditTextIPRobot,EditTextNomRobot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synchroniser_robot_nao);
        setTitle(R.string.SynchroniserRobotNAOActivity_label);

        EtatConnexionRobotNAO = (ImageView)findViewById(R.id.EtatConnexionRobotNAO);
        EtatConnexionRobotNAO.setVisibility(View.INVISIBLE);

        EditTextIPRobot = (EditText)findViewById(R.id.EditTextIPRobot);
        EditTextNomRobot = (EditText)findViewById(R.id.EditTextNomRobot);
    }

    public void TesterRobotNAO(View view){
        String IPRobotNAO = EditTextIPRobot.getText().toString();
        if(IPRobotNAO.equals("")){
            String text = "Veuillez renseigner l'adresse IP";
            Spannable centeredText = new SpannableString(text);
            centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                    0, text.length() - 1,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            Toast.makeText(getApplicationContext(), centeredText, Toast.LENGTH_LONG).show();
            EtatConnexionRobotNAO.setVisibility(View.INVISIBLE);
        }else{
            EtatConnexionRobotNAO.setVisibility(View.VISIBLE);
            EtatConnexionRobotNAO.setImageResource(R.drawable.ok);
        }
    }

    public void SynchroniserRobotNAO(View view) {
        String IPRobotNAO = EditTextIPRobot.getText().toString();
        String NomRobotNAO = EditTextNomRobot.getText().toString();

        if (IPRobotNAO.equals("") || NomRobotNAO.equals("")) {
            if(IPRobotNAO.equals("") && NomRobotNAO.equals("")){
                String text = "Veuillez renseigner tout les champs";
                Spannable centeredText = new SpannableString(text);
                centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                        0, text.length() - 1,
                        Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                Toast.makeText(getApplicationContext(), centeredText, Toast.LENGTH_LONG).show();
            }
            else if(IPRobotNAO.equals("")){
                String text = "Veuillez renseigner l'adresse IP";
                Spannable centeredText = new SpannableString(text);
                centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                        0, text.length() - 1,
                        Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                Toast.makeText(getApplicationContext(), centeredText, Toast.LENGTH_LONG).show();
            }else{
                String text = "Veuillez renseigner le nom du robot";
                Spannable centeredText = new SpannableString(text);
                centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                        0, text.length() - 1,
                        Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                Toast.makeText(getApplicationContext(), centeredText, Toast.LENGTH_LONG).show();
            }
        }else{
            Intent intent = new Intent(SynchroniserRobotNAOActivity.this, RobotNAOActivity.class);
            startActivity(intent);
        }

    }
}
