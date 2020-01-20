package tw.android;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

public class MyAppWidget extends AppWidgetProvider {

	private final String LOG_TAG = "myAppWidget";
	
	private static AlarmManager mAlarmManager;
	private static PendingIntent mPendingIntent;

	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onDeleted(context, appWidgetIds);
		Log.d(LOG_TAG, "onDeleted()");
	}

	@Override
	public void onDisabled(Context context) {
		// TODO Auto-generated method stub
		super.onDisabled(context);
		Log.d(LOG_TAG, "onDisabled()");
		mAlarmManager.cancel(mPendingIntent);
	}

	@Override
	public void onEnabled(Context context) {
		// TODO Auto-generated method stub
		super.onEnabled(context);
		Log.d(LOG_TAG, "onEnabled()");
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		super.onReceive(context, intent);
		if(!intent.getAction().equals("tw.android.MY_OWN_WIDGET_UPDATE"))
			return;
		
		Log.d(LOG_TAG, "onReceive()");
		
		Bundle extras = intent.getExtras();
		if(extras!=null) {
		    AppWidgetManager appWidgetMan = AppWidgetManager.getInstance(context);
		    ComponentName thisAppWidget = new ComponentName(context.getPackageName(), MyAppWidget.class.getName());
		    int[] appWidgetIds = appWidgetMan.getAppWidgetIds(thisAppWidget);

		    onUpdate(context, appWidgetMan, appWidgetIds);
		}
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		Log.d(LOG_TAG, "onUpdate()");

		// 更新 App Widget 程式的 view
/*		RemoteViews viewAppWidget = new RemoteViews(context.getPackageName(), R.layout.main);
		viewAppWidget.setImageViewResource(R.id.imgAppWidget, R.drawable.icon2);
		ComponentName appWidget = new ComponentName(context, MyAppWidget.class);
		appWidgetManager.updateAppWidget(appWidget, viewAppWidget);
*/	}
	
	static void SaveAlarmManager(AlarmManager alarmManager, PendingIntent pendingIntent)
	{
		mAlarmManager = alarmManager;
		mPendingIntent = pendingIntent;
	}

/*	如果設定 App Widget 組態設定程式, 就不會自動執行 onUpdate(),
	必須由 App Widget Configure程式自己執行更新.以下的方法是做第一次更新,
	第二次以後在 onReceive()方法中完成
	public static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
		int appWidgetId){
		RemoteViews updateViews = new RemoteViews(context.getPackageName(), R.layout.hellowidget_layout);
		updateViews.setTextViewText(R.id.widgettext, "[" + String.valueOf(appWidgetId) + "]" + strWidgetText);
		appWidgetManager.updateAppWidget(appWidgetId, updateViews);
	}
*/
}
