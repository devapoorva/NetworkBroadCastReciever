package com.xbrainz.networkbroadcastreciever.activities;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AlertDialog;

import com.xbrainz.networkbroadcastreciever.R;
import com.xbrainz.networkbroadcastreciever.application.BaseActivity;
import com.xbrainz.networkbroadcastreciever.broadcast.NetworkStateChecker;
import com.xbrainz.networkbroadcastreciever.dialog.InternetDialog;
import com.xbrainz.networkbroadcastreciever.utils.Util;

public class MyAlertDialog extends Activity implements NetworkStateChecker.ConnectivityReceiverListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //hide activity title

        InternetDialog dialog = new InternetDialog(MyAlertDialog.this, new InternetDialog.onRetry() {
            @Override
            public void onReload() {
                if(Util.checkNetworkConnection(MyAlertDialog.this))
                {
                    onBackPressed();
                }
            }
        });
        dialog.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        BaseActivity.getInstance().setConnectivityListener(this);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        if(isConnected)
        {
            onBackPressed();
        }
    }
}
