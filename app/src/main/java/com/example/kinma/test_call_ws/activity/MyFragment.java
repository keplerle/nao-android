package com.example.kinma.test_call_ws.activity;
import butterknife.BindView;
import butterknife.ButterKnife;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;
import com.example.kinma.test_call_ws.R;
import com.example.kinma.test_call_ws.event.PleaseRefreshEvent;

import android.os.Bundle;
import de.greenrobot.event.EventBus;

public class MyFragment extends Fragment {

    @BindView(R.id.main_content)
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = (TextView) view.findViewById(R.id.text);
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

    //This object can receive a PleaseRefreshEvent
    public void onEvent(PleaseRefreshEvent event){
        textView.setText(event.getMyString());
    }
}
