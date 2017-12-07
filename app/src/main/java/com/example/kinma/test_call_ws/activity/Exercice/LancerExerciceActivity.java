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
import com.example.kinma.test_call_ws.activity.Events.MessageEvent;
import com.example.kinma.test_call_ws.activity.Events.NAOSavedEvent;
import com.example.kinma.test_call_ws.activity.Events.NAOUpdatedEvent;
import com.example.kinma.test_call_ws.manager.NAOManager;
import com.example.kinma.test_call_ws.model.NAO;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
    NAOManager naoManager;
    NAO nao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancer_exercice);
        setTitle(R.string.LancerExerciceActivity_label);
        ButterKnife.bind(this);
        this.naoManager = new NAOManager();
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
            if(RadioButtonAddition.isChecked()){
                nao.setPlus(true);
            }

            if(RadioButtonSoustraction.isChecked()){
                nao.setMoins(true);
            }

            if(RadioButtonDivision.isChecked()){
                nao.setDivise(true);
            }

            if(RadioButtonMultiplication.isChecked()){
                nao.setMultiple(true);
            }

            nao.setOperande(true);
            nao.setOperateur(true);
            this.naoManager.updateNAO(nao);
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NAOUpdatedEvent naoUpdatedEvent) {
        Intent intent = new Intent(LancerExerciceActivity.this, ExerciceActivity.class);
        startActivity(intent);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent) {
        Toast.makeText(getApplicationContext(), messageEvent.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(NAOSavedEvent naoSavedEvent) {
        nao = naoSavedEvent.getNao();
    }
}

