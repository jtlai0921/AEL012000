package tw.android;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Main extends Activity {
	private Button mBtnLoginDlg;
	private TextView mTxtResult;
	private Dialog mLoginDlg;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setupViewComponent();
    }
    
    private void setupViewComponent() {
		mBtnLoginDlg = (Button)findViewById(R.id.btnLoginDlg);
		mTxtResult = (TextView)findViewById(R.id.txtResult);

		mBtnLoginDlg.setOnClickListener(btnLoginDlgOnClkLis);
    }

    private Button.OnClickListener btnLoginDlgOnClkLis = new Button.OnClickListener() {
		public void onClick(View v) {
			mTxtResult.setText("");
			
			mLoginDlg = new Dialog(Main.this);
			mLoginDlg.setTitle("�n�J�t��");
			mLoginDlg.setCancelable(false);
			mLoginDlg.setContentView(R.layout.login_dlg);
			Button loginBtnOK = (Button)mLoginDlg.findViewById(R.id.btnOK);
			Button loginBtnCancel = (Button)mLoginDlg.findViewById(R.id.btnCancel);
			loginBtnOK.setOnClickListener(loginDlgBtnOKOnClkLis);
			loginBtnCancel.setOnClickListener(loginDlgBtnCancelOnClkLis);
			mLoginDlg.show();			
		}
	};
	
    private Button.OnClickListener loginDlgBtnOKOnClkLis = new Button.OnClickListener() {
		public void onClick(View v) {
			EditText edtUserName = (EditText)mLoginDlg.findViewById(R.id.edtUserName);
			EditText edtPassword = (EditText)mLoginDlg.findViewById(R.id.edtPassword);

			mTxtResult.setText("�A��J���ϥΪ̦W�١G" + edtUserName.getText().toString() +
								"�A�K�X�G" + edtPassword.getText().toString());
			mLoginDlg.cancel();
		}
	};
	
    private Button.OnClickListener loginDlgBtnCancelOnClkLis = new Button.OnClickListener() {
		public void onClick(View v) {
			mTxtResult.setText("�A���U\"����\"���s�C");
			mLoginDlg.cancel();
		}
	};
}