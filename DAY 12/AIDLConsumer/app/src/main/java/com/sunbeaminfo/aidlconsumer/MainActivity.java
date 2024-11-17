package com.sunbeaminfo.aidlconsumer;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import aidl.IRemoteService;

public class MainActivity extends AppCompatActivity {
    IRemoteService iRemoteService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            iRemoteService = IRemoteService.Stub.asInterface(binder);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    public void startService(View view){
        Intent intent = new Intent("myservice.AIDL");

        //To convert implicit intent to explicit
        ResolveInfo info = getPackageManager().queryIntentServices(intent,0).get(0);
        ComponentName componentName = new ComponentName(info.serviceInfo.packageName,info.serviceInfo.name);
        intent.setComponent(componentName);

        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
    }
    public void downloadFile(View view) throws RemoteException {
        iRemoteService.doWork();
    }
    public void stopService(View view){
        unbindService(serviceConnection);
    }
}