package tw.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Main extends Activity {
	private Button mBtnLaunchAct;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setupViewComponent();
    }

    private void setupViewComponent() {
    	mBtnLaunchAct = (Button)findViewById(R.id.btnLaunchAct);
    	mBtnLaunchAct.setOnClickListener(btnLaunchActOnClickLis);
    }

    private Button.OnClickListener btnLaunchActOnClickLis = new Button.OnClickListener() {
		public void onClick(View v) {
			Intent it = new Intent();
			it.setClass(Main.this, Game.class);
			startActivity(it);
		}
	};
}