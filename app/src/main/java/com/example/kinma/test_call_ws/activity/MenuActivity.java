package com.example.kinma.test_call_ws.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kinma.test_call_ws.R;
import com.example.kinma.test_call_ws.activity.Eleve.EleveActivity;
import com.example.kinma.test_call_ws.activity.Exercice.ExerciceActivity;
import com.example.kinma.test_call_ws.activity.RobotNAO.RobotNAOActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        setTitle(R.string.MenuActivity_label);
    }

    @OnClick(R.id.ButtonRobotNAO)
    public void RobotNAO() {
        Intent intent = new Intent(MenuActivity.this, RobotNAOActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.ButtonExercice)
    public void Exercice() {
        Intent intent = new Intent(MenuActivity.this, ExerciceActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.ButtonEleve)
    public void Eleve() {
        Intent intent = new Intent(MenuActivity.this, EleveActivity.class);
        startActivity(intent);
    }

}

