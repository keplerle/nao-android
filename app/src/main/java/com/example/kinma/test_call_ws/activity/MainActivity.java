package com.example.kinma.test_call_ws.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kinma.test_call_ws.R;
import com.example.kinma.test_call_ws.event.PleaseRefreshEvent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {

    /*@BindView(R.id.main_content)
    TextView textView;*/
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    //Catcher l'event, recuperer l'objet, utiliser l'objet pour initialiser le front
    @OnClick(R.id.button)
    public void onClickEvent() {
        EventBus.getDefault().post(new PleaseRefreshEvent("toto"));

    }
}
