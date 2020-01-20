package tw.android;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
	
	private final String LOG_TAG = "service demo";
	
	public class LocalBinder extends Binder {
	     MyService getService() {
	        return  MyService.this;
	    }
	}
	
	private LocalBinder mLocBin = new LocalBinder();
	
	public void myMethod() {
		Log.d(LOG_TAG, "myMethod()");
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.d(LOG_TAG, "onCreate()");
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.d(LOG_TAG, "onDestroy()");
		super.onDestroy();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		Log.d(LOG_TAG, "onStart()");
		super.onStart(intent, startId);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		Log.d(LOG_TAG, "onUnbind()");
		return super.onUnbind(intent);
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		Log.d(LOG_TAG, "onBind()");
		
		// 一定要傳回一個Binder物件才會執行ServiceConnection物件的
		// onServiceConnected()方法
		return mLocBin;
	}

}
