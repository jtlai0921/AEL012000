package tw.android;

import android.app.Activity;
import android.os.Bundle;
import android.util.*;
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
			
			String strSug = "���G�G"; // getString(R.string.promptResult);
			if (strSex.equals("�k"))
				if (iAge < 28) {
					strSug += "����";	//getString(R.string.sugNotHurry);
					Log.d("MarriSug", "man, don't hurry");
				}
				else if (iAge > 33) {
					strSug += "���ֵ��B";	//getString(R.string.sugGetMarried);
					Log.d("MarriSug", "man, hurry to get married!");
				}
				else {
					strSug += "�}�l���H";	//getString(R.string.sugFindCouple);
					Log.d("MarriSug", "man, start to find girlfriend!");
				}
			else
				if (iAge < 25) {
					strSug += "����";	//getString(R.string.sugNotHurry);
					Log.d("MarriSug", "woman, don't hurry!");
				}
				else if (iAge > 30) {
					strSug += "���ֵ��B";	//getString(R.string.sugGetMarried);
					Log.d("MarriSug", "woman, hurry to get married!");
				}
				else {
					strSug += "�}�l���H";
					Log.d("MarriSug", "woman, start to find boyfriend!");
				}
			//getString(R.string.sugFindCouple);
			
			txtResult.setText(strSug);
		}
	};
}