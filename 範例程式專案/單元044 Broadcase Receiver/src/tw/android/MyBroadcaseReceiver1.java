package tw.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcaseReceiver1 extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String sender = intent.getExtras().getString("sender_name");
		Toast.makeText(context, "BroadcastReceiver1����" + sender + "�o�e��Broadcase�T��", Toast.LENGTH_LONG).show();
	}

}
