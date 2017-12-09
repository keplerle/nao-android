package com.example.kinma.test_call_ws.activity.RobotNAO;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kinma.test_call_ws.PublicContext;
import com.example.kinma.test_call_ws.R;
import com.example.kinma.test_call_ws.activity.Events.MessageEvent;
import com.example.kinma.test_call_ws.activity.Events.NAOFoundEvent;
import com.example.kinma.test_call_ws.activity.Events.NAOSavedEvent;
import com.example.kinma.test_call_ws.activity.Events.NAOUpdatedEvent;
import com.example.kinma.test_call_ws.activity.MenuActivity;
import com.example.kinma.test_call_ws.manager.NAOManager;
import com.example.kinma.test_call_ws.model.NAO;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SynchroniserRobotNAOActivity extends AppCompatActivity {
    @BindView(R.id.EtatConnexionRobotNAO)
    ImageView EtatConnexionRobotNAO;
    @BindView(R.id.EditTextIPRobot)
    EditText EditTextIPRobot;
    @BindView(R.id.EditTextNomRobot)
    EditText EditTextNomRobot;
    NAOManager naoManager;
    String IPRobotNAO;
    String NomRobotNAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synchroniser_robot_nao);
        setTitle(R.string.SynchroniserRobotNAOActivity_label);
        ButterKnife.bind(this);
        this.naoManager = new NAOManager();
    }

    @OnClick(R.id.ButtonTesterRobot)
    public void TesterRobotNAO() {
        IPRobotNAO = EditTextIPRobot.getText().toString();
        if (IPRobotNAO.trim().equals("")) {
            String text = "Veuillez renseigner l'adresse IP";
            Spannable centeredText = new SpannableString(text);
            centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                    0, text.length() - 1,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            Toast.makeText(getApplicationContext(), centeredText, Toast.LENGTH_LONG).show();
            EtatConnexionRobotNAO.setVisibility(View.INVISIBLE);
        } else {
            naoManager.getNAOByIp(IPRobotNAO);

        }
    }

    @OnClick(R.id.ButtonSynchronisationRobot)
    public void SynchroniserRobotNAO() {
        IPRobotNAO = EditTextIPRobot.getText().toString();
        NomRobotNAO = EditTextNomRobot.getText().toString();

        if (IPRobotNAO.trim().equals("") || NomRobotNAO.trim().equals("")) {
            if (IPRobotNAO.equals("") && NomRobotNAO.equals("")) {
                String text = "Veuillez renseigner tout les champs";
                Spannable centeredText = new SpannableString(text);
                centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                        0, text.length() - 1,
                        Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                Toast.makeText(getApplicationContext(), centeredText, Toast.LENGTH_LONG).show();
            } else if (IPRobotNAO.trim().equals("")) {
                String text = "Veuillez renseigner l'adresse IP";
                Spannable centeredText = new SpannableString(text);
                centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                        0, text.length() - 1,
                        Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                Toast.makeText(getApplicationContext(), centeredText, Toast.LENGTH_LONG).show();
            } else {
                String text = "Veuillez renseigner le nom du robot";
                Spannable centeredText = new SpannableString(text);
                centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                        0, text.length() - 1,
                        Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                Toast.makeText(getApplicationContext(), centeredText, Toast.LENGTH_LONG).show();
            }
        } else {

            NAO nao = new NAO();
            nao.setIp(IPRobotNAO);
            nao.setNom(NomRobotNAO);
            nao.setMailprof(PublicContext.currentProf.getMail());
            this.naoManager.saveNAO(nao);
        }

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
    public void onMessageEvent(NAOUpdatedEvent naoUpdatedEvent) {
        Intent intent = new Intent(SynchroniserRobotNAOActivity.this, MenuActivity.class);
        startActivity(intent);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NAOFoundEvent naoFoundEvent) {
        if (naoFoundEvent.getNao() != null && naoFoundEvent.getNao().getIp().equals(IPRobotNAO)) {
            //Icone vert à affiché
        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NAOSavedEvent naoSavedEvent) {
        Intent intent = new Intent(SynchroniserRobotNAOActivity.this, RobotNAOActivity.class);
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent) {
        Toast.makeText(getApplicationContext(), messageEvent.getMessage(), Toast.LENGTH_LONG).show();
    }
}
