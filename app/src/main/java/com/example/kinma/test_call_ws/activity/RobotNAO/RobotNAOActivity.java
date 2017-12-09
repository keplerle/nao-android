package com.example.kinma.test_call_ws.activity.RobotNAO;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kinma.test_call_ws.PublicContext;
import com.example.kinma.test_call_ws.R;
import com.example.kinma.test_call_ws.activity.Events.MessageEvent;
import com.example.kinma.test_call_ws.activity.Events.NAOListEvent;
import com.example.kinma.test_call_ws.manager.NAOManager;
import com.example.kinma.test_call_ws.model.NAO;
import com.example.kinma.test_call_ws.RobotNAOAdapter;
import com.example.kinma.test_call_ws.model.Prof;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RobotNAOActivity extends AppCompatActivity {
    @BindView(R.id.ListViewRobotSynchronise)
    ListView ListViewRobotSynchronise;
    NAOManager naoManager;
    Prof prof;
    List<NAO> robotNAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot_nao);
        setTitle(R.string.RobotNAOActivity_label);
        ButterKnife.bind(this);
        List<NAO> robotNAO = new ArrayList<NAO>();
        this.naoManager = new NAOManager();
        afficherListeRobotNAO();


    }

    private void afficherListeRobotNAO() {
        this.naoManager.getAllNAOByProf(PublicContext.currentProf.getMail());
    }

    @OnClick(R.id.ButtonSynchroniserRobot)
    public void synchroniserRobotNAO() {
        Intent intent = new Intent(RobotNAOActivity.this, SynchroniserRobotNAOActivity.class);
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
            robotNAO = naoListEvent.getNaos();
            RobotNAOAdapter robotNAOAdapter = new RobotNAOAdapter(RobotNAOActivity.this, robotNAO);
            ListViewRobotSynchronise.setAdapter(robotNAOAdapter);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent) {
        Toast.makeText(getApplicationContext(), messageEvent.getMessage(), Toast.LENGTH_LONG).show();
    }
}

