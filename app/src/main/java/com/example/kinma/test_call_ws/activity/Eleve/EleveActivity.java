package com.example.kinma.test_call_ws.activity.Eleve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.kinma.test_call_ws.R;
import com.example.kinma.test_call_ws.activity.Eleve.EleveActivity;

public class EleveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleve);
        setTitle(R.string.EleveActivity_label);
    }

    public void CreeEleve(View view) {
        Intent intent = new Intent(EleveActivity.this, RegisterEleveActivity.class);
        startActivity(intent);
    }
}
