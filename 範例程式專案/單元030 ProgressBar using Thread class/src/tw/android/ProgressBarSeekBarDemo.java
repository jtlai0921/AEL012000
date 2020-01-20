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
    	
    	DoLengthyWork work = new DoLengthyWork();
    	work.setHandler(mHandler);
    	work.setProgressBar(proBar);
    	work.start();
    }
}