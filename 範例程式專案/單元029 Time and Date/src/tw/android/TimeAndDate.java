package tw.android;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class TimeAndDate extends Activity {
	
	private DatePicker mDatePik;
	private TimePicker mTimePik;
	private TextView mTxtResult;
	private Button mBtnOK;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setupViewComponent();
    }
    
    private void setupViewComponent() {
        // �q�귽���OR�����o��������
    	mDatePik = (DatePicker)findViewById(R.id.datePik);
    	mTimePik = (TimePicker)findViewById(R.id.timePik);
    	mTxtResult = (TextView)findViewById(R.id.txtResult);
    	mBtnOK = (Button)findViewById(R.id.btnOK);

    	mBtnOK.setOnClickListener(btnDoOKOnClick);
    }
    
    private Button.OnClickListener btnDoOKOnClick = new Button.OnClickListener() {
		public void onClick(View v) {
			String s = getString(R.string.result);
			mTxtResult.setText(s + mDatePik.getYear() + "�~" +
								  (mDatePik.getMonth()+1) + "�� " +
								  mDatePik.getDayOfMonth() + "��" +
								  mTimePik.getCurrentHour() + "�I" +
								  mTimePik.getCurrentMinute() + "��");
		}
	};
}