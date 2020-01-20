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
        
        // 從資源類別R中取得介面元件
        btnDoSug = (Button)findViewById(R.id.btnDoSug);
    	edtSex = (EditText)findViewById(R.id.edtSex);
    	edtAge = (EditText)findViewById(R.id.edtAge);
    	txtResult = (TextView)findViewById(R.id.txtResult);
    	
    	// 設定button元件的事件listener
    	btnDoSug.setOnClickListener(btnDoSugOnClick);
    }
    
    private Button.OnClickListener btnDoSugOnClick = new Button.OnClickListener() {
		public void onClick(View v) {
			String strSex = edtSex.getText().toString();
			int iAge = Integer.parseInt(edtAge.getText().toString());
			
			String strSug = "結果："; // getString(R.string.promptResult);
			if (strSex.equals("男"))
				if (iAge < 28) {
					strSug += "不急";	//getString(R.string.sugNotHurry);
					Log.d("MarriSug", "man, don't hurry");
				}
				else if (iAge > 33) {
					strSug += "趕快結婚";	//getString(R.string.sugGetMarried);
					Log.d("MarriSug", "man, hurry to get married!");
				}
				else {
					strSug += "開始找對象";	//getString(R.string.sugFindCouple);
					Log.d("MarriSug", "man, start to find girlfriend!");
				}
			else
				if (iAge < 25) {
					strSug += "不急";	//getString(R.string.sugNotHurry);
					Log.d("MarriSug", "woman, don't hurry!");
				}
				else if (iAge > 30) {
					strSug += "趕快結婚";	//getString(R.string.sugGetMarried);
					Log.d("MarriSug", "woman, hurry to get married!");
				}
				else {
					strSug += "開始找對象";
					Log.d("MarriSug", "woman, start to find boyfriend!");
				}
			//getString(R.string.sugFindCouple);
			
			txtResult.setText(strSug);
		}
	};
}