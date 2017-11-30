package com.example.kinma.test_call_ws.activity.Eleve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kinma.test_call_ws.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterEleveActivity extends AppCompatActivity {
    @BindView(R.id.EditTextPrenomEleve)
    EditText EditTextPrenomEleve;
    @BindView(R.id.EditTextNomEleve)
    EditText EditTextNomEleve;
    @BindView(R.id.EditTextClasseEleve)
    EditText EditTextClasseEleve;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_eleve);
        setTitle(R.string.RegisterEleveActivity_label);
        ButterKnife.bind(this);
    }

    public void CreerEleve(View view){
        String NomEleve = EditTextNomEleve.getText().toString();
        String PrenomEleve = EditTextPrenomEleve.getText().toString();
        String ClasseEleve = EditTextClasseEleve.getText().toString();
        if(NomEleve.equals("") || PrenomEleve.equals("") || ClasseEleve.equals("")){
            String text = "Veuillez renseigner tout les champs";
            Spannable centeredText = new SpannableString(text);
            centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                    0, text.length() - 1,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            Toast.makeText(getApplicationContext(), centeredText, Toast.LENGTH_LONG).show();
        } else{
            Intent intent = new Intent(RegisterEleveActivity.this, EleveActivity.class);
            startActivity(intent);
        }

    }

}

