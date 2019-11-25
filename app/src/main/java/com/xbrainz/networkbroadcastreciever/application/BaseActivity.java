package com.xbrainz.networkbroadcastreciever.application;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.xbrainz.networkbroadcastreciever.broadcast.NetworkStateChecker;

public class BaseActivity extends Application {
    NetworkStateChecker stateChecker = new NetworkStateChecker();
    @Override
    public void onCreate() {
        super.onCreate();
        registerBroadcast();
    }

    public void registerBroadcast() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(stateChecker, filter);
        //check = 1;
    }

   /* public void unRegisterReceiver()
    {
        unregisterReceiver(stateChecker);
    }*/

}
