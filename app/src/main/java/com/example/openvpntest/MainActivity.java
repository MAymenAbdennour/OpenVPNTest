package com.example.openvpntest;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startVPN(View view) {
        Intent openVPN = new Intent("android.intent.action.VIEW");
        openVPN.setPackage("net.openvpn.openvpn");
        openVPN.setClassName("net.openvpn.openvpn", "net.openvpn.unified.MainActivity");
        openVPN.putExtra("net.openvpn.openvpn.AUTOSTART_PROFILE_NAME", "PC conf");
        openVPN.putExtra("net.openvpn.openvpn.AUTOCONNECT",true);
        startActivityForResult(openVPN, 0);
    }

    public void stopVPN(View view) {
        Intent openVPN = new Intent("net.openvpn.openvpn.DISCONNECT");
        openVPN.setPackage("net.openvpn.openvpn");
        openVPN.putExtra("net.openvpn.openvpn.STOP",true);
        openVPN.setClassName("net.openvpn.openvpn", "net.openvpn.unified.MainActivity");
        startActivityForResult(openVPN, 0);
    }
    
}
