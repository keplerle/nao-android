package com.example.kinma.test_call_ws.activity.Exercice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kinma.test_call_ws.PublicContext;
import com.example.kinma.test_call_ws.R;
import com.example.kinma.test_call_ws.RobotNAOAdapter;
import com.example.kinma.test_call_ws.activity.Events.MessageEvent;
import com.example.kinma.test_call_ws.activity.Events.NAOListEvent;
import com.example.kinma.test_call_ws.activity.RobotNAO.RobotNAOActivity;
import com.example.kinma.test_call_ws.manager.NAOManager;
import com.example.kinma.test_call_ws.model.NAO;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExerciceActivity extends AppCompatActivity {
    ListView listViewExerciceSynchronise;
    NAOManager naoManager;
    List<NAO> exerciceNAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);
        ButterKnife.bind(this);
        List<NAO> robotNAO = new ArrayList<NAO>();
        this.naoManager = new NAOManager();
        this.naoManager.getAllNAOByProf(PublicContext.currentProf.getMail());
        setTitle(R.string.ExerciceActivity_label);
        PublicContext.currentNao = null;
        listViewExerciceSynchronise.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PublicContext.currentNao = (NAO) parent.getItemAtPosition(position);
                Intent intent = new Intent(ExerciceActivity.this, LancerExerciceActivity.class);
                startActivity(intent);
            }
        });
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
    public void onMessageEvent(NAOListEvent naoListEvent) {
        exerciceNAO = naoListEvent.getNaos();
        RobotNAOAdapter robotNAOAdapter = new RobotNAOAdapter(ExerciceActivity.this, exerciceNAO);
        listViewExerciceSynchronise.setAdapter(robotNAOAdapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent) {
        Toast.makeText(getApplicationContext(), messageEvent.getMessage(), Toast.LENGTH_LONG).show();
    }
}

