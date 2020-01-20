package tw.android;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import android.widget.TabHost.TabSpec;

public class Main extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setupViewComponent();
    }
    
    private void setupViewComponent() {
        // 從資源類別R中取得介面元件
    	TabHost tabHost = getTabHost();

    	Intent it = new Intent();
		it.setClass(Main.this, DateTimePicker.class);
    	TabSpec spec=tabHost.newTabSpec("tab1");
    	spec.setContent(it);
    	spec.setIndicator("日期和時間",
    			getResources().getDrawable(android.R.drawable.ic_lock_idle_alarm));
    	tabHost.addTab(spec);
    	
    	it = new Intent();
		it.setClass(Main.this, ProgBarDemo.class);
    	spec=tabHost.newTabSpec("tab2");
    	spec.setIndicator("ProgressBar Demo",
    			getResources().getDrawable(android.R.drawable.ic_dialog_alert));
    	spec.setContent(it);
    	tabHost.addTab(spec);

    	tabHost.setCurrentTab(0);
    }
}