package com.example.kinma.test_call_ws.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.kinma.test_call_ws.R;
import com.example.kinma.test_call_ws.activity.Eleve.EleveActivity;
import com.example.kinma.test_call_ws.activity.Exercice.ExerciceActivity;
import com.example.kinma.test_call_ws.activity.RobotNAO.RobotNAOActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setTitle(R.string.MenuActivity_label);

    }

    public void RobotNAO (View view){
        Intent intent = new Intent(MenuActivity.this, RobotNAOActivity.class);
        startActivity(intent);
    }
    public void Exercice (View view){
        Intent intent = new Intent(MenuActivity.this, ExerciceActivity.class);
        startActivity(intent);
    }

    public void Eleve (View view){
        Intent intent = new Intent(MenuActivity.this, EleveActivity.class);
        startActivity(intent);
    }

}

