package com.example.mvp.tomaszkrol.app;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends BaseActivity {
    public static final Class<?> TAG = MainActivity.class;

    String applicationData;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        applicationData = "AAAAAAAAAAAAAAAAA";

        AppFragment fragment = (AppFragment) getSupportFragmentManager()
                .findFragmentByTag(AppFragment.class.getSimpleName());

        if(fragment != null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment, AppFragment.class.getSimpleName())
                    .commit();
        }
        else{
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new AppFragment(), AppFragment.class.getSimpleName())
                    .commit();
        }
    }

    @Nullable
    @Override
    public Object saveCustomState() {
        return applicationData;
    }

    @Override
    public void loadCustomState(Object retainedState) {
        applicationData = (String) retainedState;
    }
}
