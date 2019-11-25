package com.xbrainz.networkbroadcastreciever.broadcast;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.xbrainz.networkbroadcastreciever.activities.MyAlertDialog;
import com.xbrainz.networkbroadcastreciever.application.BaseActivity;
import com.xbrainz.networkbroadcastreciever.utils.Util;

import static com.xbrainz.networkbroadcastreciever.utils.Util.checkNetworkConnection;

public class NetworkStateChecker extends BroadcastReceiver {

    public static ConnectivityReceiverListener connectivityReceiverListener;

    public NetworkStateChecker() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent arg1) {

        if(Util.checkNetworkConnection(context))
        {
            if (connectivityReceiverListener != null) {
                connectivityReceiverListener.onNetworkConnectionChanged(Util.checkNetworkConnection(context));
            }
        }
        else
        {
            Intent i=new Intent(context.getApplicationContext(), MyAlertDialog.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }

    }


    public interface ConnectivityReceiverListener {
        void onNetworkConnectionChanged(boolean isConnected);
    }
}
