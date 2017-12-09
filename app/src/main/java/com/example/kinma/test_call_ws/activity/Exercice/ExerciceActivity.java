package com.example.kinma.test_call_ws.activity.Exercice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.kinma.test_call_ws.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExerciceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);
        ButterKnife.bind(this);
        setTitle(R.string.ExerciceActivity_label );
    }
    @OnClick(R.id.ButtonCreerExercice)
    public void CreerExercice(){
        Intent intent = new Intent(ExerciceActivity.this, LancerExerciceActivity.class);
        intent.putExtra("toto", "toti");
        startActivity(intent);
    }
}

