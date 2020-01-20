package tw.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MarriSug extends Activity {
	
	private Button btnDoSug;
    private EditText edtSex, edtAge;
    private TextView txtResult;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setupViewComponent();
    }
    
    private void setupViewComponent() {
        // �q�귽���OR�����o��������
        btnDoSug = (Button)findViewById(R.id.btnDoSug);
    	edtSex = (EditText)findViewById(R.id.edtSex);
    	edtAge = (EditText)findViewById(R.id.edtAge);
    	txtResult = (TextView)findViewById(R.id.txtResult);
    	
    	// �]�wbutton���󪺨ƥ�listener
    	btnDoSug.setOnClickListener(btnDoSugOnClick);
    }
    
    private Button.OnClickListener btnDoSugOnClick = new Button.OnClickListener() {
		public void onClick(View v) {
			String strSex = edtSex.getText().toString();
			int iAge = Integer.parseInt(edtAge.getText().toString());
			
			String strSug = getString(R.string.sugResult);
			if (strSex.equals(getString(R.string.sexMale)))
				if (iAge < 28)
					strSug += getString(R.string.sugNotHurry);
				else if (iAge > 33)
					strSug += getString(R.string.sugGetMarried);
				else
					strSug += getString(R.string.sugFindCouple);
			else
				if (iAge < 25)
					strSug += getString(R.string.sugNotHurry);
				else if (iAge > 30)
					strSug += getString(R.string.sugGetMarried);
				else
					strSug += getString(R.string.sugFindCouple);
			
			txtResult.setText(strSug);
		}
	};
}