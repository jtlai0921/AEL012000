package tw.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Main extends Activity {
	private Button mBtnLaunchAct;
	private	TextView mTxtResult;
	final private int LAUNCH_GAME = 0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
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
    		
    		String s = "�C�����G�G�A�`�@���F" + iCountSet +
    				   "��, Ĺ�F" + iCountPlayerWin +
    				   "��, ��F" + iCountComWin +
    				   "��, ����" + iCountDraw + "��";
    		mTxtResult.setText(s);
    		
    		break;
    	case RESULT_CANCELED:
    		mTxtResult.setText("�A��ܨ����C���C");
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