package teerayut.dev.vlife.utils;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import teerayut.dev.vlife.authentication.AuthenticationActivity;

/**
 * Created by OzoeSK on 7/5/2017.
 */

public class NetworkConnection extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        /*ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting();

        if (networkChangedListener != null) {
            networkChangedListener.onNetworkConnectionChanged(isConnected);
        }*/
        ComponentName comp = new ComponentName(context.getPackageName(),
                AuthenticationActivity.class.getName());
        intent.putExtra("isNetworkConnected",isConnected(context));
        context.startService(intent.setComponent(comp));
    }

    public  boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE));
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }

    public static boolean isInternetConnected(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE));
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}
