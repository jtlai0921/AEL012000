package tw.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main extends Activity {
	private Button mBtnAlertDlg,
		   mBtnAlertDlgBld;
	
	private TextView mTxtResult;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setupViewComponent();
    }
    
    private void setupViewComponent() {
		mBtnAlertDlg = (Button)findViewById(R.id.btnAlertDlg);
		mBtnAlertDlgBld = (Button)findViewById(R.id.btnAlertDlgBld);
		mTxtResult = (TextView)findViewById(R.id.txtResult);

		mBtnAlertDlg.setOnClickListener(btnAlertDlgOnClkLis);
		mBtnAlertDlgBld.setOnClickListener(btnAlertDlgBldOnClkLis);
    }

    private Button.OnClickListener btnAlertDlgOnClkLis = new Button.OnClickListener() {
		public void onClick(View v) {
			mTxtResult.setText("");
			
			MyAlertDialog myAltDlg = new MyAlertDialog(Main.this);
			
			myAltDlg.setTitle("AlertDialog");
			myAltDlg.setMessage("�ϥ�AlertDialog�l�����O");
			myAltDlg.setIcon(android.R.drawable.ic_dialog_info);
			myAltDlg.setCancelable(false);
			myAltDlg.setButton(DialogInterface.BUTTON_POSITIVE, "�O", altDlgOnClkPosiBtnLis);
			myAltDlg.setButton(DialogInterface.BUTTON_NEGATIVE, "�_", altDlgOnClkPosiBtnLis);
			myAltDlg.setButton(DialogInterface.BUTTON_NEUTRAL, "����", altDlgOnClkPosiBtnLis);
			myAltDlg.show();			
		}
	};
	
	private  DialogInterface.OnClickListener altDlgOnClkPosiBtnLis = new  DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			mTxtResult.setText("�A�ҰʤFAlertDialog�ӥB���U�F\"�O\"���s");
		}
	};

	private  DialogInterface.OnClickListener altDlgOnClkNegaBtnLis = new  DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			mTxtResult.setText("�A�ҰʤFAlertDialog�ӥB���U�F\"�_\"���s");
		}
	};

	private  DialogInterface.OnClickListener altDlgOnClkNeutBtnLis = new  DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			mTxtResult.setText("�A�ҰʤFAlertDialog�ӥB���U�F\"����\"���s");
		}
	};

    private Button.OnClickListener btnAlertDlgBldOnClkLis = new Button.OnClickListener() {
		public void onClick(View v) {
			mTxtResult.setText("");
			
			AlertDialog.Builder altDlgBldr = new AlertDialog.Builder(Main.this);
			
			altDlgBldr.setTitle("AlertDialog");
			altDlgBldr.setMessage("�ϥ�AlertDialog.Builder���O");
			altDlgBldr.setIcon(android.R.drawable.ic_dialog_info);
			altDlgBldr.setCancelable(false);
			altDlgBldr.setPositiveButton("�O",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						mTxtResult.setText("�A�ҰʤFAlertDialogBuilder�ӥB���U�F\"�O\"���s");
					}
				});
			altDlgBldr.setNegativeButton("�_",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						mTxtResult.setText("�A�ҰʤFAlertDialogBuilder�ӥB���U�F\"�_\"���s");
					}
				});
			altDlgBldr.setNeutralButton("����",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						mTxtResult.setText("�A�ҰʤFAlertDialogBuilder�ӥB���U�F\"����\"���s");
					}
				});
			altDlgBldr.show();			
		}
	};
}