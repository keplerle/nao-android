package com.example.kinma.test_call_ws.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.example.kinma.test_call_ws.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.StartActivity_label);

    }


    public void DemarerApplication(View view) {
        Intent intent = new Intent(MainActivity.this, ConnexionActivity.class);
        startActivity(intent);
    }
}
