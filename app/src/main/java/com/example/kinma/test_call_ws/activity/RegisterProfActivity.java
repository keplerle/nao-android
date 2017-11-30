package com.example.kinma.test_call_ws.activity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_prof);
        setTitle(R.string.RegisterProfActivity_label);
        ButterKnife.bind(this);
    }

    public void Cree(View view) {
        String Nom = EditTextNom.getText().toString();
        String Prenom = EditTextPrenom.getText().toString();
        String Mail = EditTextMail.getText().toString();
        String Password = EditTextPassword.getText().toString();
        String PasswordVerif = EditTextVerifPassword.getText().toString();

        if (Nom.equals("") || Prenom.equals("") || Mail.equals("") || Password.equals("") || PasswordVerif.equals("")) {
            String text = "Veuillez remplir tout les champs";
            Spannable centeredText = new SpannableString(text);
            centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                    0, text.length() - 1,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            Toast.makeText(getApplicationContext(), centeredText, Toast.LENGTH_LONG).show();
        } else if ((!Nom.equals("") && !Prenom.equals("") && !Mail.equals("") && !Password.equals("") && !PasswordVerif.equals("")) && (!Password.equals(PasswordVerif))) {
            String text = "Veuillez rerentrer votre password";
            EditTextPassword.setText("");
            EditTextVerifPassword.setText("");
            Spannable centeredText = new SpannableString(text);
            centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                    0, text.length() - 1,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            Toast.makeText(getApplicationContext(), centeredText, Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(RegisterProfActivity.this, MenuActivity.class);
            startActivity(intent);
        }


    }
}
