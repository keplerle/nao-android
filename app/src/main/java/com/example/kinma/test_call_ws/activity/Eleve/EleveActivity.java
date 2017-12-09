package com.example.kinma.test_call_ws.activity.Eleve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.kinma.test_call_ws.R;
import com.example.kinma.test_call_ws.manager.EleveManager;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class EleveActivity extends AppCompatActivity {
    EleveManager eleveManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleve);
        ButterKnife.bind(this);
        this.eleveManager=new EleveManager();

    }
@OnClick(R.id.ButtonCreerEleve)
    public void CreeEleve() {
        Intent intent = new Intent(EleveActivity.this, RegisterEleveActivity.class);
        startActivity(intent);
    }
}
