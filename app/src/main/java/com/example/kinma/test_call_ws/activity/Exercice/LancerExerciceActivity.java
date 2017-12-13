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
import android.widget.Switch;
import android.widget.Toast;

import com.example.kinma.test_call_ws.PublicContext;
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
import butterknife.OnClick;

public class LancerExerciceActivity extends AppCompatActivity {
    @BindView(R.id.RadioButtonMultiplication)
    RadioButton RadioButtonMultiplication;
    @BindView(R.id.RadioButtonDivision)
    RadioButton RadioButtonDivision;
    @BindView(R.id.RadioButtonSoustraction)
    RadioButton RadioButtonSoustraction;
    @BindView(R.id.RadioButtonAddition)
    RadioButton RadioButtonAddition;
    @BindView(R.id.SwitchOperande)
    Switch switchOperande;
    @BindView(R.id.SwitchNiveau)
    Switch switchNiveau;
    NAOManager naoManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancer_exercice);
        setTitle(R.string.LancerExerciceActivity_label);
        ButterKnife.bind(this);
        this.naoManager = new NAOManager();
        RadioButtonAddition.setChecked(PublicContext.currentNao.isPlus());
        RadioButtonSoustraction.setChecked(PublicContext.currentNao.isMoins());
        RadioButtonMultiplication.setChecked(PublicContext.currentNao.isMultiple());
        RadioButtonDivision.setChecked(PublicContext.currentNao.isDivise());
        switchOperande.setChecked(PublicContext.currentNao.isOperateur());
        switchNiveau.setChecked(PublicContext.currentNao.isOperande());
        /*
        if(PublicContext.currentNao.getSigne_possible==1){
        RadioButtonAddition.setChecked(PublicContext.currentNao.isPlus());
        RadioButtonSoustraction.setChecked(PublicContext.currentNao.isMoins());
        RadioButtonMultiplication.setChecked(PublicContext.currentNao.isMultiple());
        RadioButtonDivision.setChecked(PublicContext.currentNao.isDivise());
        }
        else if(PublicContext.currentNao.getSigne_possible==2){
        RadioButtonAddition.setChecked(PublicContext.currentNao.isPlus());
        RadioButtonSoustraction.setChecked(PublicContext.currentNao.isMoins());
        RadioButtonMultiplication.setChecked(PublicContext.currentNao.isMultiple());
        RadioButtonDivision.setChecked(PublicContext.currentNao.isDivise());
        }
        else if(PublicContext.currentNao.getSigne_possible==3){
        RadioButtonAddition.setChecked(PublicContext.currentNao.isPlus());
        RadioButtonSoustraction.setChecked(PublicContext.currentNao.isMoins());
        RadioButtonMultiplication.setChecked(PublicContext.currentNao.isMultiple());
        RadioButtonDivision.setChecked(PublicContext.currentNao.isDivise());
        }
        else if(PublicContext.currentNao.getSigne_possible==4){
        RadioButtonAddition.setChecked(PublicContext.currentNao.isPlus());
        RadioButtonSoustraction.setChecked(PublicContext.currentNao.isMoins());
        RadioButtonMultiplication.setChecked(PublicContext.currentNao.isMultiple());
        RadioButtonDivision.setChecked(PublicContext.currentNao.isDivise());
        }
        else if(PublicContext.currentNao.getSigne_possible==5){
        RadioButtonAddition.setChecked(PublicContext.currentNao.isPlus());
        RadioButtonSoustraction.setChecked(PublicContext.currentNao.isMoins());
        RadioButtonMultiplication.setChecked(PublicContext.currentNao.isMultiple());
        RadioButtonDivision.setChecked(PublicContext.currentNao.isDivise());
        }
        else if(PublicContext.currentNao.getSigne_possible==6){
        RadioButtonAddition.setChecked(PublicContext.currentNao.isPlus());
        RadioButtonSoustraction.setChecked(PublicContext.currentNao.isMoins());
        RadioButtonMultiplication.setChecked(PublicContext.currentNao.isMultiple());
        RadioButtonDivision.setChecked(PublicContext.currentNao.isDivise());
        }
        else if(PublicContext.currentNao.getSigne_possible==7){
        RadioButtonAddition.setChecked(PublicContext.currentNao.isPlus());
        RadioButtonSoustraction.setChecked(PublicContext.currentNao.isMoins());
        RadioButtonMultiplication.setChecked(PublicContext.currentNao.isMultiple());
        RadioButtonDivision.setChecked(PublicContext.currentNao.isDivise());
        }
        else if(PublicContext.currentNao.getSigne_possible==8){
        RadioButtonAddition.setChecked(PublicContext.currentNao.isPlus());
        RadioButtonSoustraction.setChecked(PublicContext.currentNao.isMoins());
        RadioButtonMultiplication.setChecked(PublicContext.currentNao.isMultiple());
        RadioButtonDivision.setChecked(PublicContext.currentNao.isDivise());
        }
        else if(PublicContext.currentNao.getSigne_possible==9){
        RadioButtonAddition.setChecked(PublicContext.currentNao.isPlus());
        RadioButtonSoustraction.setChecked(PublicContext.currentNao.isMoins());
        RadioButtonMultiplication.setChecked(PublicContext.currentNao.isMultiple());
        RadioButtonDivision.setChecked(PublicContext.currentNao.isDivise());
        }
        else if(PublicContext.currentNao.getSigne_possible==10){
        RadioButtonAddition.setChecked(PublicContext.currentNao.isPlus());
        RadioButtonSoustraction.setChecked(PublicContext.currentNao.isMoins());
        RadioButtonMultiplication.setChecked(PublicContext.currentNao.isMultiple());
        RadioButtonDivision.setChecked(PublicContext.currentNao.isDivise());
        }
        else if(PublicContext.currentNao.getSigne_possible==11){
        RadioButtonAddition.setChecked(PublicContext.currentNao.isPlus());
        RadioButtonSoustraction.setChecked(PublicContext.currentNao.isMoins());
        RadioButtonMultiplication.setChecked(PublicContext.currentNao.isMultiple());
        RadioButtonDivision.setChecked(PublicContext.currentNao.isDivise());
        }
        else if(PublicContext.currentNao.getSigne_possible==12){
        RadioButtonAddition.setChecked(PublicContext.currentNao.isPlus());
        RadioButtonSoustraction.setChecked(PublicContext.currentNao.isMoins());
        RadioButtonMultiplication.setChecked(PublicContext.currentNao.isMultiple());
        RadioButtonDivision.setChecked(PublicContext.currentNao.isDivise());
        }
        else if(PublicContext.currentNao.getSigne_possible==13){
        RadioButtonAddition.setChecked(PublicContext.currentNao.isPlus());
        RadioButtonSoustraction.setChecked(PublicContext.currentNao.isMoins());
        RadioButtonMultiplication.setChecked(PublicContext.currentNao.isMultiple());
        RadioButtonDivision.setChecked(PublicContext.currentNao.isDivise());
        }
        else if(PublicContext.currentNao.getSigne_possible==14){
        RadioButtonAddition.setChecked(PublicContext.currentNao.isPlus());
        RadioButtonSoustraction.setChecked(PublicContext.currentNao.isMoins());
        RadioButtonMultiplication.setChecked(PublicContext.currentNao.isMultiple());
        RadioButtonDivision.setChecked(PublicContext.currentNao.isDivise());
        }
        else if(PublicContext.currentNao.getSigne_possible==15){
        RadioButtonAddition.setChecked(PublicContext.currentNao.isPlus());
        RadioButtonSoustraction.setChecked(PublicContext.currentNao.isMoins());
        RadioButtonMultiplication.setChecked(PublicContext.currentNao.isMultiple());
        RadioButtonDivision.setChecked(PublicContext.currentNao.isDivise());
        }
        else if(PublicContext.currentNao.getSigne_possible==16){
        RadioButtonAddition.setChecked(PublicContext.currentNao.isPlus());
        RadioButtonSoustraction.setChecked(PublicContext.currentNao.isMoins());
        RadioButtonMultiplication.setChecked(PublicContext.currentNao.isMultiple());
        RadioButtonDivision.setChecked(PublicContext.currentNao.isDivise());
        }
        */
    }

    @OnClick(R.id.ButtonCreationExercice)
    public void LancerExercice() {

        if (!RadioButtonAddition.isChecked() && !RadioButtonDivision.isChecked() && !RadioButtonMultiplication.isChecked() && !RadioButtonSoustraction.isChecked()) {
            String text = "Veuillez sélectionner au moins un type d'opérateur";
            Spannable centeredText = new SpannableString(text);
            centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                    0, text.length() - 1,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            Toast.makeText(getApplicationContext(), centeredText, Toast.LENGTH_LONG).show();
        } else {
            if (RadioButtonAddition.isChecked()) {
                PublicContext.currentNao.setPlus(true);
            } else {
                PublicContext.currentNao.setPlus(false);
            }

            if (RadioButtonSoustraction.isChecked()) {
                PublicContext.currentNao.setMoins(true);
            } else {
                PublicContext.currentNao.setMoins(false);
            }

            if (RadioButtonDivision.isChecked()) {
                PublicContext.currentNao.setDivise(true);
            } else {
                PublicContext.currentNao.setDivise(false);
            }

            if (RadioButtonMultiplication.isChecked()) {
                PublicContext.currentNao.setMultiple(true);
            } else {
                PublicContext.currentNao.setMultiple(false);
            }
            if(switchNiveau.isChecked()){
                PublicContext.currentNao.setOperande(true);
            }else{
                PublicContext.currentNao.setOperande(false);
            }
            if(switchOperande.isChecked()){
                PublicContext.currentNao.setOperateur(true);
            }else{
                PublicContext.currentNao.setOperateur(false);
            }
/*

            if(RadioButtonAddition.isChecked()&&){
             PublicContext.currentNao.setSigne_possible(1);
            }
            else if(){
                PublicContext.currentNao.setSigne_possible(2);
            }
            else if(){
                PublicContext.currentNao.setSigne_possible(3);
            }
            else if(){
                PublicContext.currentNao.setSigne_possible(4);
            }
            else if(){
                PublicContext.currentNao.setSigne_possible(5);
            }
            else if(){
                PublicContext.currentNao.setSigne_possible(6);
            }
            else if(){
                PublicContext.currentNao.setSigne_possible(7);
            }
            else if(){
                PublicContext.currentNao.setSigne_possible(8);
            }
            else if(){
                PublicContext.currentNao.setSigne_possible(9);
            }
            else if(){
                PublicContext.currentNao.setSigne_possible(10);
            }
            else if(){
                PublicContext.currentNao.setSigne_possible(11);
            }
            else if(){
                PublicContext.currentNao.setSigne_possible(12);
            }
            else if(){
                PublicContext.currentNao.setSigne_possible(13);
            }
            else if(){
                PublicContext.currentNao.setSigne_possible(14);
            }
            else if(){
                PublicContext.currentNao.setSigne_possible(15);
            }
            else if(){
                PublicContext.currentNao.setSigne_possible(16);
            }
      */
            this.naoManager.updateNAO(PublicContext.currentNao);
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
}

