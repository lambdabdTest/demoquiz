package com.test.demoquiz;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class connection {
    public boolean getConnection(Context context){
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
}
