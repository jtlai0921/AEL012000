package tw.android;

import java.util.Calendar;

import android.app.*;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;
import android.widget.TabHost.TabSpec;

public class TabPageDemo extends Activity {
	private DatePicker mDatePik;
	private TimePicker mTimePik;
	private TextView mTxtResult;
	private Button mBtnOK;
	
	private Handler mHandler = new Handler();

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setupViewComponent();
    }
    
    private void setupViewComponent() {
        // 從資源類別R中取得介面元件
    	TabHost tabHost = (TabHost)findViewById(R.id.tabHost);
    	tabHost.setup();

    	TabSpec spec=tabHost.newTabSpec("tab1");
    	spec.setContent(R.id.tab1);
    	spec.setIndicator("日期和時間",
    			getResources().getDrawable(android.R.drawable.ic_lock_idle_alarm));
    	tabHost.addTab(spec);
    	
    	spec=tabHost.newTabSpec("tab2");
    	spec.setIndicator("ProgressBar Demo",
    			getResources().getDrawable(android.R.drawable.ic_dialog_alert));
    	spec.setContent(R.id.tab2);
    	tabHost.addTab(spec);

    	tabHost.setCurrentTab(0);
    	
    	mDatePik = (DatePicker)findViewById(R.id.datePik);
    	mTimePik = (TimePicker)findViewById(R.id.timePik);
    	mTxtResult = (TextView)findViewById(R.id.txtResult);
    	mBtnOK = (Button)findViewById(R.id.btnOK);

    	mBtnOK.setOnClickListener(btnDoOKOnClick);
    	
    	final ProgressBar proBar = (ProgressBar)findViewById(R.id.proBar2);
    	
    	new Thread(new Runnable() {
            public void run() {
            	Calendar begin = Calendar.getInstance();
		    	do {
		    		Calendar now = Calendar.getInstance();
		    		final int iDiffSec = 60 * (now.get(Calendar.MINUTE) - begin.get(Calendar.MINUTE)) +
		    						now.get(Calendar.SECOND) - begin.get(Calendar.SECOND);
		    	
		    		if (iDiffSec * 2 > 100) {
		    			mHandler.post(new Runnable() {
			                public void run() {
			                	proBar.setProgress(100);
			                }
			            });
		    			
		    			break;
		    		}
		    		
		    		mHandler.post(new Runnable() {
		                public void run() {
		                	proBar.setProgress(iDiffSec * 2);
		                }
		            });
		    		
		    		if (iDiffSec * 4 < 100)
		    			mHandler.post(new Runnable() {
			                public void run() {
			                	proBar.setSecondaryProgress(iDiffSec * 4);
			                }
			            });
		    		else
		    			mHandler.post(new Runnable() {
			                public void run() {
			                	proBar.setSecondaryProgress(100);
			                }
			            });
		    	} while (true);
            }
        }).start();
    }
    
    private Button.OnClickListener btnDoOKOnClick = new Button.OnClickListener() {
		public void onClick(View v) {
			String s = getString(R.string.result);
			mTxtResult.setText(s + mDatePik.getYear() + "年" +
								  (mDatePik.getMonth()+1) + "月 " +
								  mDatePik.getDayOfMonth() + "日" +
								  mTimePik.getCurrentHour() + "點" +
								  mTimePik.getCurrentMinute() + "分");
		}
	};
}