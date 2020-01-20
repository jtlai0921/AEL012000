package tw.android;
import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyAppWidget extends AppWidgetProvider {

	private final String LOG_TAG = "myAppWidget";

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
	}

	@Override
	public void onEnabled(Context context) {
		// TODO Auto-generated method stub
		super.onEnabled(context);
		Log.d(LOG_TAG, "onEnabled()");

		Calendar alarmTime = Calendar.getInstance();
		alarmTime.setTimeInMillis(System.currentTimeMillis());
		alarmTime.add(Calendar.SECOND, 30);
		setAlarm(context, alarmTime);
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		Log.d(LOG_TAG, "onUpdate()");
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		super.onReceive(context, intent);
		if(!intent.getAction().equals("tw.android.MY_OWN_WIDGET_UPDATE"))
			return;
		
		Log.d(LOG_TAG, "onReceive()");
	}
	
	private void setAlarm(Context context, Calendar alarmTime) {
		Intent it = new Intent("tw.android.MY_OWN_WIDGET_UPDATE");
		PendingIntent penIt = PendingIntent.getBroadcast(context, 0, it, 0);
		AlarmManager alarmMan = (AlarmManager)context.getSystemService(context.ALARM_SERVICE);
		alarmMan.set(AlarmManager.RTC_WAKEUP, alarmTime.getTimeInMillis(), penIt);
	}

/*	�p�G�]�w Alarm Manager�w�ɰ��� App Widget, �N���|�۰ʰ��� onUpdate(),
	������ App Widget Configure�{���ۤv�����s.�H�U����k�O���Ĥ@����s,
	�ĤG���H��b onReceive()��k������
	public static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
		int appWidgetId){
		RemoteViews updateViews = new RemoteViews(context.getPackageName(), R.layout.hellowidget_layout);
		updateViews.setTextViewText(R.id.widgettext, "[" + String.valueOf(appWidgetId) + "]" + strWidgetText);
		appWidgetManager.updateAppWidget(appWidgetId, updateViews);
	}
*/
}
