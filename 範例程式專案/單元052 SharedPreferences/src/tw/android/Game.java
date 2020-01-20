package tw.android;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Game extends Activity {
	private int miCountSet = 0,
				miCountPlayerWin = 0,
				miCountComWin = 0,
				miCountDraw = 0;
	private Button mBtnShowResult,
				   mBtnSaveResult,
				   mBtnLoadResult,
				   mBtnClearResult;

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
    	mBtnSaveResult = (Button)findViewById(R.id.btnSaveResult);
    	mBtnLoadResult = (Button)findViewById(R.id.btnLoadResult);
    	mBtnClearResult = (Button)findViewById(R.id.btnClearResult);

    	mBtnScissors.setOnClickListener(btnScissorsLin);
    	mBtnStone.setOnClickListener(btnStoneLin);
    	mBtnNet.setOnClickListener(btnNetLin);
    	mBtnShowResult.setOnClickListener(btnShowResultLis);
    	mBtnSaveResult.setOnClickListener(btnSaveResultLis);
    	mBtnLoadResult.setOnClickListener(btnLoadResultLis);
    	mBtnClearResult.setOnClickListener(btnClearResultLis);
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
				showNotification("已經平手" + Integer.toString(miCountDraw) + "局");
			}
			else if (iComPlay == 2) {
				mImgComPlay.setImageResource(R.drawable.stone);
				miCountComWin++;
				Toast.makeText(Game.this, R.string.playerLose, Toast.LENGTH_LONG)
					.show();
				showNotification("已經輸" + Integer.toString(miCountComWin) + "局");
			}
			else {
				mImgComPlay.setImageResource(R.drawable.net);
				miCountPlayerWin++;
				Toast.makeText(Game.this, R.string.playerWin, Toast.LENGTH_LONG)
					.show();
				showNotification("已經贏" + Integer.toString(miCountPlayerWin) + "局");
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
				showNotification("已經贏" + Integer.toString(miCountPlayerWin) + "局");
			}
			else if (iComPlay == 2) {
				mImgComPlay.setImageResource(R.drawable.stone);
				miCountDraw++;
				Toast.makeText(Game.this, R.string.playerDraw, Toast.LENGTH_LONG)
					.show();
				showNotification("已經平手" + Integer.toString(miCountDraw) + "局");
			}
			else {
				mImgComPlay.setImageResource(R.drawable.net);
				miCountComWin++;
				Toast.makeText(Game.this, R.string.playerLose, Toast.LENGTH_LONG)
					.show();
				showNotification("已經輸" + Integer.toString(miCountComWin) + "局");
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
				showNotification("已經輸" + Integer.toString(miCountComWin) + "局");
			}
			else if (iComPlay == 2) {
				mImgComPlay.setImageResource(R.drawable.stone);
				miCountPlayerWin++;
				Toast.makeText(Game.this, R.string.playerWin, Toast.LENGTH_LONG)
					.show();
				showNotification("已經贏" + Integer.toString(miCountPlayerWin) + "局");
			}
			else {
				mImgComPlay.setImageResource(R.drawable.net);
				miCountDraw++;
				Toast.makeText(Game.this, R.string.playerDraw, Toast.LENGTH_LONG)
					.show();
				showNotification("已經平手" + Integer.toString(miCountDraw) + "局");
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
	
	private Button.OnClickListener btnSaveResultLis = new Button.OnClickListener() {
		public void onClick(View v) {
			SharedPreferences gameResultData = getSharedPreferences("GAME_RESULT", 0);
			
			gameResultData.edit()
				.putInt("COUNT_SET", miCountSet)
				.putInt("COUNT_PLAYER_WIN", miCountPlayerWin)
				.putInt("COUNT_COM_WIN", miCountComWin)
				.putInt("COUNT_DRAW", miCountDraw)
				.commit();
			
			Toast.makeText(Game.this, "儲存完成", Toast.LENGTH_LONG)
			.show();
		}
	};
	
	private Button.OnClickListener btnLoadResultLis = new Button.OnClickListener() {
		public void onClick(View v) {
			SharedPreferences gameResultData = getSharedPreferences("GAME_RESULT", 0);
			
			miCountSet = gameResultData.getInt("COUNT_SET", 0);
			miCountPlayerWin = gameResultData.getInt("COUNT_PLAYER_WIN", 0);
			miCountComWin = gameResultData.getInt("COUNT_COM_WIN", 0);
			miCountDraw = gameResultData.getInt("COUNT_DRAW", 0);
			
			Toast.makeText(Game.this, "載入完成", Toast.LENGTH_LONG)
			.show();
		}
	};
	
	private Button.OnClickListener btnClearResultLis = new Button.OnClickListener() {
		public void onClick(View v) {
			SharedPreferences gameResultData = getSharedPreferences("GAME_RESULT", 0);
			
			gameResultData.edit()
				.clear()
				.commit();
			
			Toast.makeText(Game.this, "清除完成", Toast.LENGTH_LONG)
			.show();
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
		
		noti.setLatestEventInfo(this, "遊戲結果", s, penIt);
		
		NotificationManager notiMgr =
			(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		notiMgr.notify(0, noti);
	}
}