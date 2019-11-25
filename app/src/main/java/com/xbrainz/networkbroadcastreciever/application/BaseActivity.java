package com.xbrainz.networkbroadcastreciever.application;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.xbrainz.networkbroadcastreciever.broadcast.NetworkStateChecker;

public class BaseActivity extends Application {

    private static BaseActivity mInstance;
    private NetworkStateChecker stateChecker= new NetworkStateChecker();

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        registerBroadcast();
    }

    public void registerBroadcast() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(stateChecker, filter);
        //check = 1;
    }

    public static synchronized BaseActivity getInstance() {
        return mInstance;
    }



    public void setConnectivityListener(NetworkStateChecker.ConnectivityReceiverListener listener) {
        NetworkStateChecker.connectivityReceiverListener = listener;
    }

}
