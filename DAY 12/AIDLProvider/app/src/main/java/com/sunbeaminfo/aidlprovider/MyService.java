package com.sunbeaminfo.aidlprovider;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import aidl.IRemoteService;

public class MyService extends Service {
    public MyService() {
    }

    IRemoteService.Stub stubBinder = new IRemoteService.Stub() {
        @Override
        public void doWork() throws RemoteException {
            downloadFile();
        }
    };

    class MyBinder extends Binder{
        public MyService getMyService(){
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        //return  new MyBinder();
        return stubBinder;
    }

    public void downloadFile(){
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                Log.e("MyService",""+i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}