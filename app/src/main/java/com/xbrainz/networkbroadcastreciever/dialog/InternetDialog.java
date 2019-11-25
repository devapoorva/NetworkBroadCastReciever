package com.xbrainz.networkbroadcastreciever.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.xbrainz.networkbroadcastreciever.R;
import com.xbrainz.networkbroadcastreciever.utils.Util;

public class InternetDialog extends Dialog {
    public InternetDialog(@NonNull Context context) {
        super(context);
    }
    onRetry on_retry;

    public InternetDialog(@NonNull final Context context, final onRetry on_retry) {
        super(context);
        setContentView(R.layout.no_internet);
        setCancelable(false);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        // Button buttonRetry = findViewById(R.id.btn_retry);

        /*buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });*/

        /*buttonRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Util.checkNetworkConnection(context)){
                    on_retry.onReload();
                    dismiss();}
            }
        });*/
    }

    public interface onRetry{
        void onReload();
    }
}

