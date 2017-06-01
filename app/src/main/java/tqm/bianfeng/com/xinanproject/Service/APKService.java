package tqm.bianfeng.com.xinanproject.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by johe on 2017/4/20.
 */

public class APKService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //复制assets中apk到手机


        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void getApk(int index){

    }


}
