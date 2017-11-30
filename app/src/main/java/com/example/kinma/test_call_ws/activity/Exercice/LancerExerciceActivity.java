package com.example.kinma.test_call_ws.activity.Exercice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.kinma.test_call_ws.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LancerExerciceActivity extends AppCompatActivity {
    @BindView(R.id.RadioButtonMultiplication)
    RadioButton RadioButtonMultiplication;
    @BindView(R.id.RadioButtonDivision)
    RadioButton RadioButtonDivision;
    @BindView(R.id.RadioButtonSoustraction)
    RadioButton RadioButtonSoustraction;
    @BindView(R.id.RadioButtonAddition)
    RadioButton RadioButtonAddition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancer_exercice);
        setTitle(R.string.LancerExerciceActivity_label);
        ButterKnife.bind(this);
    }

    public void LancerExercice(View view) {
        if (!RadioButtonAddition.isChecked() && !RadioButtonDivision.isChecked() && !RadioButtonMultiplication.isChecked() && !RadioButtonSoustraction.isChecked()) {
            String text = "Veuillez sélectionner au moins un type d'opérateur";
            Spannable centeredText = new SpannableString(text);
            centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                    0, text.length() - 1,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            Toast.makeText(getApplicationContext(), centeredText, Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(LancerExerciceActivity.this, ExerciceActivity.class);
            startActivity(intent);
        }
    }
}

