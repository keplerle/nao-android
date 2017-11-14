package com.example.kinma.test_call_ws.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kinma.test_call_ws.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_content)
    TextView textView;
//@BindView(R.id.button_load)  Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        textView.setText("Toto");
    }
//Catcher l'event, recuperer l'objet, utiliser l'objet pour initialiser le front
    @OnClick(R.id.button_load)
    public void onClickEvent() {
        textView.setText("Titi");

    }
}
