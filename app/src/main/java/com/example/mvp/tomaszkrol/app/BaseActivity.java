package com.example.mvp.tomaszkrol.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * Created by tomasz.krol on 2016-07-29.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Object savedState = getLastCustomNonConfigurationInstance();
        if (savedState != null) {
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            int fragmentCount = 0;
            if (fragments != null) {
                fragmentCount = fragments.size();
            }

            Object[] configState = (Object[]) savedState;

            for (int stateIterator = 0; stateIterator < fragmentCount * 2; stateIterator++) {
                BaseFragment fragmentToLoad = (BaseFragment) fragments.get(stateIterator);
                fragmentToLoad.loadCustomState(configState[stateIterator]);
                stateIterator++;
                fragmentToLoad.loadChildStateState(configState[stateIterator]);
            }
            this.loadCustomState(configState[fragmentCount * 2]);
        }
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        super.onRetainCustomNonConfigurationInstance();

        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        int fragmentCount = fragments.size();
        Object[] configState = new Object[fragmentCount * 2 + 1];

        for (int stateIterator = 0; stateIterator < fragmentCount * 2; stateIterator++) {
            if (!(fragments instanceof BaseFragment)) {
                stateIterator = +2;
            }
            BaseFragment fragmentToLoad = (BaseFragment) fragments.get(stateIterator);
            configState[stateIterator] = fragmentToLoad.saveCustomState();
            stateIterator++;
            configState[stateIterator] = fragmentToLoad.saveChildStateState();
        }
        configState[fragmentCount * 2] = this.saveCustomState();

        return configState;

    }

    @Nullable
    public Object saveCustomState() {
        return null;
    }

    public void loadCustomState(Object retainedState) {

    }
}
