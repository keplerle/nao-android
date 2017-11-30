package com.example.kinma.test_call_ws.activity.RobotNAO;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.kinma.test_call_ws.R;
import com.example.kinma.test_call_ws.model.NAO;
import com.example.kinma.test_call_ws.RobotNAOAdapter;

import java.util.ArrayList;
import java.util.List;

public class RobotNAOActivity extends AppCompatActivity {

    ListView ListViewRobotSynchronise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot_nao);
        setTitle(R.string.RobotNAOActivity_label);
        ListViewRobotSynchronise = (ListView)findViewById(R.id.ListViewRobotSynchronise);
        afficherListeRobotNAO();

    }

    private List<NAO> synchroniserRobotNAO() {
        List<NAO> robotNAO = new ArrayList<NAO>();
        robotNAO.add(new NAO(2, "Robot 1", "IP Robot NAO: 192.168.0.40"));
        return robotNAO;
    }

    private void afficherListeRobotNAO() {
        List<NAO> robotNAO = synchroniserRobotNAO();
        RobotNAOAdapter robotNAOAdapter = new RobotNAOAdapter(RobotNAOActivity.this, robotNAO);
        ListViewRobotSynchronise.setAdapter(robotNAOAdapter);

    }


    public void SynchroniserRobotNAO1 (View view){
        Intent intent = new Intent(RobotNAOActivity.this, SynchroniserRobotNAOActivity.class);
        startActivity(intent);
    }
}

