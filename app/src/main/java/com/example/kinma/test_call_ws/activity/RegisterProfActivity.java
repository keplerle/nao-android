package com.example.kinma.test_call_ws.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kinma.test_call_ws.PublicContext;
import com.example.kinma.test_call_ws.R;
import com.example.kinma.test_call_ws.activity.Events.MessageEvent;
import com.example.kinma.test_call_ws.activity.Events.ProfSavedEvent;
import com.example.kinma.test_call_ws.manager.ProfManager;
import com.example.kinma.test_call_ws.model.Prof;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RegisterProfActivity extends AppCompatActivity {
    @BindView(R.id.EditTextPrenomProf)
    EditText EditTextPrenom;
    @BindView(R.id.EditTextNomProf)
    EditText EditTextNom;
    @BindView(R.id.EditTextMailProf)
    EditText EditTextMail;
    @BindView(R.id.EditTextPasswordProf)
    EditText EditTextPassword;
    @BindView(R.id.EditTextVerifPassword)
    EditText EditTextVerifPassword;
    ProfManager profManager;
    Prof prof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_prof);
        setTitle(R.string.RegisterProfActivity_label);
        ButterKnife.bind(this);
        this.profManager = new ProfManager();
    }

    @OnClick(R.id.ButtonCreationProf)
    public void Cree() {
        String nom = EditTextNom.getText().toString();
        String prenom = EditTextPrenom.getText().toString();
        String mail = EditTextMail.getText().toString();
        String password = EditTextPassword.getText().toString();
        String passwordVerif = EditTextVerifPassword.getText().toString();

        if (nom.equals("") || prenom.equals("") || mail.trim().equals("") || password.equals("") || passwordVerif.equals("")) {
            String text = "Veuillez remplir tout les champs";
            Spannable centeredText = new SpannableString(text);
            centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                    0, text.length() - 1,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            Toast.makeText(getApplicationContext(), centeredText, Toast.LENGTH_LONG).show();
        } else if (!password.equals(passwordVerif)) {
            String text = "Veuillez rerentrer votre password";
            EditTextPassword.setText("");
            EditTextVerifPassword.setText("");
            Spannable centeredText = new SpannableString(text);
            centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                    0, text.length() - 1,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            Toast.makeText(getApplicationContext(), centeredText, Toast.LENGTH_LONG).show();
        } else {
            prof = new Prof();
            prof.setNom(nom);
            prof.setPrenom(prenom);
            prof.setMail(mail);
            prof.setPassword(password);
            this.profManager.saveProf(prof);
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
    public void onMessageEvent(ProfSavedEvent profSavedEvent) {
        PublicContext.currentProf = prof;
        Intent intent = new Intent(RegisterProfActivity.this, MenuActivity.class);
        startActivity(intent);


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent) {
        Toast.makeText(getApplicationContext(), messageEvent.getMessage(), Toast.LENGTH_LONG).show();
    }
}
