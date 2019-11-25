package com.xbrainz.networkbroadcastreciever.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkStateChecker extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(checkNetworkConnection(context))
        {
            Toast.makeText(context,"Net on",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context,"No network",Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkNetworkConnection(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo!=null && networkInfo.isConnected());
    }
}
