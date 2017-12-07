package com.example.kinma.test_call_ws.activity.RobotNAO;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.kinma.test_call_ws.R;
import com.example.kinma.test_call_ws.activity.Events.ConnexionEvent;
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

public class RobotNAOActivity extends AppCompatActivity {
    @BindView(R.id.ListViewRobotSynchronise)
    ListView ListViewRobotSynchronise;
    NAOManager naoManager;
    Prof prof;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot_nao);
        setTitle(R.string.RobotNAOActivity_label);
        ButterKnife.bind(this);
        afficherListeRobotNAO();
        this.naoManager=new NAOManager();

    }

    private List<NAO> synchroniserRobotNAO() {
        List<NAO> robotNAO = new ArrayList<NAO>();
        robotNAO.add(new NAO(2, "Robot 1", "IP Robot NAO: 192.168.0.40"));
        return robotNAO;
    }

    private void afficherListeRobotNAO() {
        this.naoManager.getNAOByProf(prof.getMail());
        List<NAO> robotNAO = synchroniserRobotNAO();
        RobotNAOAdapter robotNAOAdapter = new RobotNAOAdapter(RobotNAOActivity.this, robotNAO);
        ListViewRobotSynchronise.setAdapter(robotNAOAdapter);

    }


    public void SynchroniserRobotNAO1 (View view){
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
}

