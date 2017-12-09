package com.example.kinma.test_call_ws.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;


import com.example.kinma.test_call_ws.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.ButtonDemarrerApplication)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.StartActivity_label);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ButtonDemarrerApplication)
    public void DemarrerApplication() {
        Intent intent = new Intent(MainActivity.this, ConnexionActivity.class);
        startActivity(intent);
    }
}
