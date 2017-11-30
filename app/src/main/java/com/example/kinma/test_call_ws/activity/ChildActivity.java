package com.example.kinma.test_call_ws.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.kinma.test_call_ws.R;
import com.example.kinma.test_call_ws.event.PleaseRefreshEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.CollationElementIterator;


public class ChildActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(PleaseRefreshEvent event){

        textView.setText(event.getMyString());
    }
}
