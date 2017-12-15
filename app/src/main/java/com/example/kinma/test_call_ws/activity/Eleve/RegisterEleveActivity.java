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

import com.example.kinma.test_call_ws.PublicContext;
import com.example.kinma.test_call_ws.R;
import com.example.kinma.test_call_ws.activity.MenuActivity;
import com.example.kinma.test_call_ws.activity.Events.EleveSavedEvent;
import com.example.kinma.test_call_ws.activity.Events.MessageEvent;

import com.example.kinma.test_call_ws.manager.EleveManager;
import com.example.kinma.test_call_ws.model.Eleve;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterEleveActivity extends AppCompatActivity {
    @BindView(R.id.EditTextPrenomEleve)
    EditText EditTextPrenomEleve;
    @BindView(R.id.EditTextNomEleve)
    EditText EditTextNomEleve;
    @BindView(R.id.EditTextClasseEleve)
    EditText EditTextClasseEleve;
    EleveManager eleveManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_eleve);
        setTitle(R.string.RegisterEleveActivity_label);
        ButterKnife.bind(this);
        this.eleveManager = new EleveManager();
    }
    @OnClick(R.id.ButtonCreationEleve)
    public void CreerEleve(){
        String nomEleve = EditTextNomEleve.getText().toString();
        String prenomEleve = EditTextPrenomEleve.getText().toString();
        String classeEleve = EditTextClasseEleve.getText().toString();
        if(nomEleve.equals("") || prenomEleve.equals("") || classeEleve.equals("")){
            String text = "Veuillez renseigner tout les champs";
            Spannable centeredText = new SpannableString(text);
            centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                    0, text.length() - 1,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            Toast.makeText(getApplicationContext(), centeredText, Toast.LENGTH_LONG).show();
        } else{
            Eleve eleve = new Eleve();
            eleve.setNom(nomEleve);
            eleve.setPrenom(prenomEleve);
            eleve.setClasse(classeEleve);
            eleve.setProf(PublicContext.currentProf.getMail());
            eleve.setBonne_reponse(0);
            eleve.setFausse_reponse(0);
            this.eleveManager.saveEleve(eleve);
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Override
    public void onBackPressed(){
        Intent intent = getParentActivityIntent();
        startActivity(intent);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EleveSavedEvent eleveSavedEvent) {
        Intent intent = new Intent(RegisterEleveActivity.this, EleveActivity.class);
        startActivity(intent);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent) {
        Toast.makeText(getApplicationContext(), messageEvent.getMessage(), Toast.LENGTH_LONG).show();
    }
}

