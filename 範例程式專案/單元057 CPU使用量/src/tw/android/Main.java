package tw.android;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btnDoLoop = (Button)findViewById(R.id.btnDoLoop);
        btnDoLoop.setOnClickListener(onClickBtnDoLoop);
    }

    private Button.OnClickListener onClickBtnDoLoop = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			for (int i = 0; i < 1000000; i++)
				Math.exp(3.5);
			
			Toast.makeText(Main.this, "°j°é°õ¦æ§¹¦¨", Toast.LENGTH_LONG)
				.show();
		}
    };
}