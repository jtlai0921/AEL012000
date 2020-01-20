package tw.android;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Game extends Activity {
	private int miCountSet = 0,
				miCountPlayerWin = 0,
				miCountComWin = 0,
				miCountDraw = 0;
	private Button mBtnShowResult;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setupViewComponent();
    }
    
    private TextView mTxtResult;
    private ImageView mImgComPlay;
    private ImageButton mBtnScissors,
    					mBtnStone,
    					mBtnNet;
    
    private void setupViewComponent() {
    	mImgComPlay = (ImageView)findViewById(R.id.imgComPlay);
    	mBtnScissors = (ImageButton)findViewById(R.id.btnScissors);
    	mBtnStone = (ImageButton)findViewById(R.id.btnStone);
    	mBtnNet = (ImageButton)findViewById(R.id.btnNet);
    	mBtnShowResult = (Button)findViewById(R.id.btnShowResult);

    	mBtnScissors.setOnClickListener(btnScissorsLin);
    	mBtnStone.setOnClickListener(btnStoneLin);
    	mBtnNet.setOnClickListener(btnNetLin);
    	mBtnShowResult.setOnClickListener(btnShowResultLis);
    }

    private Button.OnClickListener btnScissorsLin = new Button.OnClickListener() {
		public void onClick(View v) {
			// Decide computer play.
			int iComPlay = (int)(Math.random()*3 + 1);
			
			miCountSet++;

			// 1 - scissors, 2 - stone, 3 - net.
			if (iComPlay == 1) {
				mImgComPlay.setImageResource(R.drawable.scissors);
				miCountDraw++;
				Toast.makeText(Game.this, R.string.playerDraw, Toast.LENGTH_LONG)
					.show();
				showNotification("�w�g����" + Integer.toString(miCountDraw) + "��");
			}
			else if (iComPlay == 2) {
				mImgComPlay.setImageResource(R.drawable.stone);
				miCountComWin++;
				Toast.makeText(Game.this, R.string.playerLose, Toast.LENGTH_LONG)
					.show();
				showNotification("�w�g��" + Integer.toString(miCountComWin) + "��");
			}
			else {
				mImgComPlay.setImageResource(R.drawable.net);
				miCountPlayerWin++;
				Toast.makeText(Game.this, R.string.playerWin, Toast.LENGTH_LONG)
					.show();
				showNotification("�w�gĹ" + Integer.toString(miCountPlayerWin) + "��");
			}
		}
	};
	
    private Button.OnClickListener btnStoneLin = new Button.OnClickListener() {
		public void onClick(View v) {
			int iComPlay = (int)(Math.random()*3 + 1);
			
			miCountSet++;

			// 1 - scissors, 2 - stone, 3 - net.
			if (iComPlay == 1) {
				mImgComPlay.setImageResource(R.drawable.scissors);
				miCountPlayerWin++;
				Toast.makeText(Game.this, R.string.playerWin, Toast.LENGTH_LONG)
					.show();
				showNotification("�w�gĹ" + Integer.toString(miCountPlayerWin) + "��");
			}
			else if (iComPlay == 2) {
				mImgComPlay.setImageResource(R.drawable.stone);
				miCountDraw++;
				Toast.makeText(Game.this, R.string.playerDraw, Toast.LENGTH_LONG)
					.show();
				showNotification("�w�g����" + Integer.toString(miCountDraw) + "��");
			}
			else {
				mImgComPlay.setImageResource(R.drawable.net);
				miCountComWin++;
				Toast.makeText(Game.this, R.string.playerLose, Toast.LENGTH_LONG)
					.show();
				showNotification("�w�g��" + Integer.toString(miCountComWin) + "��");
			}
		}
	};
	
    private Button.OnClickListener btnNetLin = new Button.OnClickListener() {
		public void onClick(View v) {
			int iComPlay = (int)(Math.random()*3 + 1);
			
			miCountSet++;

			// 1 - scissors, 2 - stone, 3 - net.
			if (iComPlay == 1) {
				mImgComPlay.setImageResource(R.drawable.scissors);
				miCountComWin++;
				Toast.makeText(Game.this, R.string.playerLose, Toast.LENGTH_LONG)
					.show();
				showNotification("�w�g��" + Integer.toString(miCountComWin) + "��");
			}
			else if (iComPlay == 2) {
				mImgComPlay.setImageResource(R.drawable.stone);
				miCountPlayerWin++;
				Toast.makeText(Game.this, R.string.playerWin, Toast.LENGTH_LONG)
					.show();
				showNotification("�w�gĹ" + Integer.toString(miCountPlayerWin) + "��");
			}
			else {
				mImgComPlay.setImageResource(R.drawable.net);
				miCountDraw++;
				Toast.makeText(Game.this, R.string.playerDraw, Toast.LENGTH_LONG)
					.show();
				showNotification("�w�g����" + Integer.toString(miCountDraw) + "��");
			}
		}
	};
	
	private Button.OnClickListener btnShowResultLis = new Button.OnClickListener() {
		public void onClick(View v) {
			Intent it = new Intent();
			it.setClass(Game.this, GameResult.class);
			
			Bundle bundle = new Bundle();
			bundle.putInt("KEY_COUNT_SET", miCountSet);
			bundle.putInt("KEY_COUNT_PLAYER_WIN", miCountPlayerWin);
			bundle.putInt("KEY_COUNT_COM_WIN", miCountComWin);
			bundle.putInt("KEY_COUNT_DRAW", miCountDraw);
			it.putExtras(bundle);
			
			startActivity(it);
		}
	};
	
	private void showNotification(String s) {
		Notification noti = new Notification(
				android.R.drawable.btn_star_big_on,
				s,
				System.currentTimeMillis());
		
		Intent it = new Intent();
		it.setClass(this, GameResult.class);
		it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Bundle bundle = new Bundle();
		bundle.putInt("KEY_COUNT_SET", miCountSet);
		bundle.putInt("KEY_COUNT_PLAYER_WIN", miCountPlayerWin);
		bundle.putInt("KEY_COUNT_COM_WIN", miCountComWin);
		bundle.putInt("KEY_COUNT_DRAW", miCountDraw);
		it.putExtras(bundle);
		
		PendingIntent penIt = PendingIntent.getActivity(
				this, 0, it,
				PendingIntent.FLAG_UPDATE_CURRENT);
		
		noti.setLatestEventInfo(this, "�C�����G", s, penIt);
		
		NotificationManager notiMgr =
			(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		notiMgr.notify(0, noti);
	}
}