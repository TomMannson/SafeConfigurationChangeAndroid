package com.example.mvp.tomaszkrol.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tomasz.krol on 2016-07-29.
 */
public class AppFragment extends BaseFragment {

    String resourceToSave;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        resourceToSave = "onCreateView";
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Nullable
    @Override
    public Object saveCustomState() {
        return resourceToSave;
    }

    @Override
    public void loadCustomState(Object retainedState) {
        resourceToSave = (String) retainedState;
    }
}
