package tw.android;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class Main extends Activity {
    private Button mBtnTimePicDlg,
	   			   mBtnDatePicDlg;
    
	private TextView mTxtResult;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setupViewComponent();
    }
    
    private void setupViewComponent() {
		mBtnTimePicDlg = (Button)findViewById(R.id.btnTimePicDlg);
		mBtnDatePicDlg = (Button)findViewById(R.id.btnDatePicDlg);
		mTxtResult = (TextView)findViewById(R.id.txtResult);

		mBtnTimePicDlg.setOnClickListener(btnTimePicDlgOnClkLis);
		mBtnDatePicDlg.setOnClickListener(btnDatePicDlgOnClkLis);
    }
	
    private Button.OnClickListener btnDatePicDlgOnClkLis = new Button.OnClickListener() {
		public void onClick(View v) {
			mTxtResult.setText("");

			Calendar now = Calendar.getInstance();

			DatePickerDialog datePicDlg = new DatePickerDialog(Main.this,
							datePicDlgOnDateSelLis,
							now.get(Calendar.YEAR),
							now.get(Calendar.MONTH),
							now.get(Calendar.DAY_OF_MONTH));
			datePicDlg.setTitle("��ܤ��");
			datePicDlg.setMessage("�п�ܾA�X�z�����");
			datePicDlg.setIcon(android.R.drawable.ic_dialog_info);
			datePicDlg.setCancelable(false);
			datePicDlg.show();
		}
	};
	
	private DatePickerDialog.OnDateSetListener datePicDlgOnDateSelLis = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet (DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			mTxtResult.setText("�A�]�w������O" +
							Integer.toString(year) + "�~" +
							Integer.toString(monthOfYear + 1) + "��" +
							Integer.toString(dayOfMonth) + "��");
		}
	};

    private Button.OnClickListener btnTimePicDlgOnClkLis = new Button.OnClickListener() {
		public void onClick(View v) {
			mTxtResult.setText("");

			Calendar now = Calendar.getInstance();

			TimePickerDialog timePicDlg = new TimePickerDialog(Main.this,
							timePicDlgOnTimeSelLis,
							now.get(Calendar.HOUR_OF_DAY),
							now.get(Calendar.MINUTE),
							true);
			timePicDlg.setTitle("��ܮɶ�");
			timePicDlg.setMessage("�п�ܾA�X�z���ɶ�");
			timePicDlg.setIcon(android.R.drawable.ic_dialog_info);
			timePicDlg.setCancelable(false);
			timePicDlg.show();
		}
	};
	
	private TimePickerDialog.OnTimeSetListener timePicDlgOnTimeSelLis = new TimePickerDialog.OnTimeSetListener() {
		public void onTimeSet (TimePicker  view, int hourOfDay, int minute) {
			mTxtResult.setText("�A�]�w���ɶ��O" +
							Integer.toString(hourOfDay) + "�I" +
							Integer.toString(minute) + "��");
		}
	};
}