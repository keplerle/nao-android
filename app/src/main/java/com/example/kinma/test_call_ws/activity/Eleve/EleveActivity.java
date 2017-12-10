package com.example.kinma.test_call_ws.activity.Eleve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kinma.test_call_ws.EleveAdapter;
import com.example.kinma.test_call_ws.PublicContext;
import com.example.kinma.test_call_ws.R;
import com.example.kinma.test_call_ws.RobotNAOAdapter;
import com.example.kinma.test_call_ws.activity.Events.EleveListEvent;
import com.example.kinma.test_call_ws.activity.Events.MessageEvent;
import com.example.kinma.test_call_ws.manager.EleveManager;
import com.example.kinma.test_call_ws.model.Eleve;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class EleveActivity extends AppCompatActivity {
    EleveManager eleveManager;
    ListView listViewEleve;
    List<Eleve> eleves;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleve);
        ButterKnife.bind(this);
        this.eleveManager=new EleveManager();
        this.eleveManager.getAllEleveByProf(PublicContext.currentProf.getMail());

    }
@OnClick(R.id.ButtonCreerEleve)
    public void CreeEleve() {
        Intent intent = new Intent(EleveActivity.this, RegisterEleveActivity.class);
        startActivity(intent);
    }
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EleveListEvent eleveListEvent) {
        eleves = eleveListEvent.getEleves();
        EleveAdapter eleveAdapter = new EleveAdapter(EleveActivity.this, eleves);
        listViewEleve.setAdapter(eleveAdapter);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent) {
        Toast.makeText(getApplicationContext(), messageEvent.getMessage(), Toast.LENGTH_LONG).show();
    }
}
