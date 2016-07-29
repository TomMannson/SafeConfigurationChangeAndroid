package com.example.mvp.tomaszkrol.app;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import java.util.List;

/**
 * Created by tomasz.krol on 2016-07-29.
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    public abstract Object saveCustomState();

    public Object saveChildStateState(){

        List<Fragment> fragments = getChildFragmentManager().getFragments();
        if(fragments == null){
            return null;
        }
        int fragmentCount = fragments.size();
        Object[] configState = new Object[fragmentCount * 2 + 1];

        for (int stateIterator = 0; stateIterator < fragmentCount * 2; stateIterator++) {
            BaseFragment fragmentToLoad = (BaseFragment) fragments.get(stateIterator);
            configState[stateIterator] = fragmentToLoad.saveCustomState();
            stateIterator++;
            configState[stateIterator] = fragmentToLoad.saveChildStateState();
        }
        configState[fragmentCount * 2] = this.saveCustomState();

        return configState;
    }

    public abstract void loadCustomState(Object retainedState);

    @CallSuper
    public void loadChildStateState(Object retainedState){

        Object[] savedState = (Object[]) retainedState;

        if (savedState != null) {
            List<Fragment> fragments = getChildFragmentManager().getFragments();
            int fragmentCount = fragments.size();

            for (int stateIterator = 0; stateIterator < fragmentCount; stateIterator++) {
                BaseFragment fragmentToLoad = (BaseFragment) fragments.get(stateIterator);
                fragmentToLoad.loadCustomState(savedState[stateIterator]);
            }
        }
    }


}
