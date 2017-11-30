package com.example.kinma.test_call_ws.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kinma.test_call_ws.R;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ConnexionActivity extends AppCompatActivity  {
    EditText EditTextUtilisateur,EditTextPassword;
    Button ButtonConnexion,ButtonCreeProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        setTitle(R.string.ConnexionActivity_label);

        ButtonCreeProfil = (Button) findViewById(R.id.ButtonCreeProfil);
        ButtonConnexion = (Button) findViewById(R.id.ButtonConnexion);
        EditTextUtilisateur = (EditText)findViewById(R.id.EditTextUtilisateur);
        EditTextPassword = (EditText)findViewById(R.id.EditTextPasswordProf);
    }

    public void CreeProfil (View view){
        Intent intent = new Intent(ConnexionActivity.this, RegisterProfActivity.class);
        startActivity(intent);
    }

    public void Connexion (View view){
        String MailUtilisateur = EditTextUtilisateur.getText().toString();
        String PasswordUtilisateur = EditTextPassword.getText().toString();
        if(MailUtilisateur.equals("")&&PasswordUtilisateur.equals("")){
            String text = "Veuillez rentrer un mail utilisateur et un password";
            Spannable centeredText = new SpannableString(text);
            centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                    0, text.length() - 1,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            Toast.makeText(getApplicationContext(), centeredText, Toast.LENGTH_LONG).show();
        }else if(MailUtilisateur.equals("")){
            String text = "Veuillez rentrer un mail utilisateur";
            Spannable centeredText = new SpannableString(text);
            centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                    0, text.length() - 1,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            Toast.makeText(getApplicationContext(), centeredText, Toast.LENGTH_LONG).show();
        }else if(PasswordUtilisateur.equals("")){
            String text = "Veuillez rentrer un password";
            Spannable centeredText = new SpannableString(text);
            centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                    0, text.length() - 1,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            Toast.makeText(getApplicationContext(), centeredText, Toast.LENGTH_LONG).show();
        }else{
            String type = "login";
            //BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            //backgroundWorker.execute(type, MailUtilisateur, PasswordUtilisateur);
            Intent intent = new Intent(ConnexionActivity.this, MenuActivity.class);
            startActivity(intent);
        }
    }

  /*  @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(LoginEvent event) {
        if ("OK".equals(event.getMessage())){
            Intent intent = new Intent(ConnexionActivity.this, MenuActivity.class);
            startActivity(intent);
        }
    };*/
}

