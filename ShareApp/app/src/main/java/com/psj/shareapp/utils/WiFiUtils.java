package com.psj.shareapp.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.provider.Settings;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;

import com.psj.shareapp.R;

import java.util.List;

public class WiFiUtils {



    private static final long SCAN_TIMEOUT=30000;

    public static String[] doWifiScan(Context context)
    {
        List<ScanResult> resultList;
        final boolean scanFlag[]=new boolean[1];
        final WifiManager wifiMan=(WifiManager)context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        BroadcastReceiver getScan=new BroadcastReceiver() {
            @Override
            @RequiresApi(23)
            public void onReceive(Context context, Intent intent) {
                scanFlag[0]=intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED,false);
            }
            };

        IntentFilter filter=new IntentFilter();
        filter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        context.registerReceiver(getScan,filter);


        boolean scanComplete=wifiMan.startScan();
        if (!scanComplete)
            resultList=scanFailed(wifiMan);
        else
            resultList=scanOver(wifiMan);
        return null;
    }

    @RequiresApi(23)
    private boolean checkGpsEnabled(final Context context)
    {
        LocationManager locationManager=(LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
        if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) return true;

        else
        {
          final  AlertDialog.Builder builder=new AlertDialog.Builder(context);
          builder.setMessage(R.string.alpha_gps_disabled)
                  .setCancelable(false)
                  .setPositiveButton("Enable", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                          Intent ok=new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                          context.startActivity(ok);
                      }
                  });
          final AlertDialog alertDialog=builder.create();
          alertDialog.show();
        }
        return false;
    }

    private static List<ScanResult> scanOver(WifiManager wifiManager)
    {
        List<ScanResult> scanResults=wifiManager.getScanResults();
        List<ScanResult> finalResults;
        ScanResult result;
        for (int i=0;i<scanResults.size();i++)
        {
            result=scanResults.get(i);

        }
        return null;
    }

    private static List<ScanResult> scanFailed(WifiManager wifiManager)
    {
        List<ScanResult> previousScanResults=wifiManager.getScanResults();
        return null;
    }

}
