package tw.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class Main extends Activity {
	
	private final String LOG_TAG = "activity lifecycle";
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		Log.d(LOG_TAG, "Main.onDestroy()");
		super.onDestroy();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		Log.d(LOG_TAG, "Main.onRestart()");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		Log.d(LOG_TAG, "Main.onResume()");
		super.onResume();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		Log.d(LOG_TAG, "Main.onStart()");
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		Log.d(LOG_TAG, "Main.onStop()");
		super.onStop();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		Log.d(LOG_TAG, "Main.onPause()");
		super.onPause();
	}

	private Button mBtnLaunchAct;
	private	TextView mTxtResult;
	final private int LAUNCH_GAME = 0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	Log.d(LOG_TAG, "Main.onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setupViewComponent();
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent  data) {
    	if (requestCode != LAUNCH_GAME)
    		return;
    	
    	switch (resultCode) {
    	case RESULT_OK:
    		Bundle bundle = data.getExtras();
    		
    		int iCountSet = bundle.getInt("KEY_COUNT_SET");
    		int iCountPlayerWin = bundle.getInt("KEY_COUNT_PLAYER_WIN");
    		int iCountComWin = bundle.getInt("KEY_COUNT_COM_WIN");
    		int iCountDraw = bundle.getInt("KEY_COUNT_DRAW");
    		
    		String s = "遊戲結果：你總共玩了" + iCountSet +
    				   "局, 贏了" + iCountPlayerWin +
    				   "局, 輸了" + iCountComWin +
    				   "局, 平手" + iCountDraw + "局";
    		mTxtResult.setText(s);
    		
    		break;
    	case RESULT_CANCELED:
    		mTxtResult.setText("你選擇取消遊戲。");
    	}
    	
    }

    private void setupViewComponent() {
    	mBtnLaunchAct = (Button)findViewById(R.id.btnLaunchAct);
    	mTxtResult = (TextView)findViewById(R.id.txtResult);
    	mBtnLaunchAct.setOnClickListener(btnLaunchActOnClickLis);
    }

    private Button.OnClickListener btnLaunchActOnClickLis = new Button.OnClickListener() {
		public void onClick(View v) {
			Intent it = new Intent();
			it.setClass(Main.this, Game.class);
			startActivityForResult(it, LAUNCH_GAME);
		}
	};
	
	
}