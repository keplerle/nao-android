package com.example.kinma.test_call_ws.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.kinma.test_call_ws.R;
import com.example.kinma.test_call_ws.manager.EleveManager;
import com.example.kinma.test_call_ws.model.Eleve;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {


    /*@BindView(R.id.button)
    Button button;
    @BindView(R.id.textView)
    TextView textView;*/
    //EleveManager eleveManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.StartActivity_label);
        //ButterKnife.bind(this);
        //this.eleveManager = new EleveManager();
    }

    //Catcher l'event, recuperer l'objet, utiliser l'objet pour initialiser le front
    /*@OnClick(R.id.button)
    public void onClickEvent() {
        this.eleveManager.getEleve();

    }*/
/*
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Eleve eleve) {
       //textView.setText(eleve.getNom());
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
    }*/

    public void DemarerApplication (View view){
        Intent intent = new Intent(MainActivity.this, ConnexionActivity.class);
        startActivity(intent);
    }
}
