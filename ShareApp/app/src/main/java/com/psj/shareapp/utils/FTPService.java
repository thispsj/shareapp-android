package com.psj.shareapp.utils;

import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceInfo;

import androidx.annotation.RequiresApi;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FTPService {

    private final String KEYS[]={"listenport","USER.NAME","FILE.NAMES","AUTH.TOKEN"};
    private final int SERVER_PORT=8080;

    @RequiresApi(16)
    public void startSendService(String user, File[] files,String fileNames)
    {
        Map<String, String> records=new HashMap<>();
        records.put(KEYS[0],String.valueOf(SERVER_PORT));
        records.put(KEYS[1],user);
        records.put(KEYS[2],fileNames);
        records.put(KEYS[3],"debugToken");
        WifiP2pDnsSdServiceInfo wifiP2pManager=WifiP2pDnsSdServiceInfo.newInstance("_test","_presence._tcp",records);

    }
}
