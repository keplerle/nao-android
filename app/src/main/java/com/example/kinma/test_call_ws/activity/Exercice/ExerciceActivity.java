package com.example.kinma.test_call_ws.activity.Exercice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.kinma.test_call_ws.R;

public class ExerciceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);
        setTitle(R.string.ExerciceActivity_label);
    }

    public void CreerExercice(View view){
        Intent intent = new Intent(ExerciceActivity.this, LancerExerciceActivity.class);
        startActivity(intent);
    }
}

