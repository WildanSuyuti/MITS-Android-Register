package com.mits.kakaroto.formregister;

import android.app.Application;

/**
 * Created by sunari on 29/12/16.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SessionManager.init(this);
    }
}
