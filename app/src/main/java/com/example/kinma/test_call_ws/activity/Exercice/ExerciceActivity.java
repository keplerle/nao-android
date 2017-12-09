package com.example.kinma.test_call_ws.activity.Exercice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

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
        this.naoManager=new NAOManager();
        setTitle(R.string.ExerciceActivity_label );
    }
    @OnClick(R.id.ButtonCreerExercice)
    public void CreerExercice(){
        Intent intent = new Intent(ExerciceActivity.this, LancerExerciceActivity.class);
        intent.putExtra("toto", "toti");
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
    public void onMessageEvent(NAOListEvent naoListEvent) {
        exerciceNAO=naoListEvent.getNaos();
        RobotNAOAdapter robotNAOAdapter = new RobotNAOAdapter(ExerciceActivity.this, exerciceNAO);
        listViewExerciceSynchronise.setAdapter(robotNAOAdapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent) {
        Toast.makeText(getApplicationContext(), messageEvent.getMessage(), Toast.LENGTH_LONG).show();
    }
}

