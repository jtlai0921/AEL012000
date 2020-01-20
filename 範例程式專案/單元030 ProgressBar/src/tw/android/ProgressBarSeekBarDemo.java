package tw.android;

import java.util.Calendar;

import android.app.Activity;
import android.os.*;
import android.view.*;
import android.widget.*;

public class ProgressBarSeekBarDemo extends Activity {
	
	private Handler mHandler = new Handler();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setupViewComponent();
    }
    
    private void setupViewComponent() {
        // �q�귽���OR�����o��������
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
}