package tw.android;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends Activity {
	private Button mBtnBrowseWWW,
				   mBtnPlayMP3,
				   mBtnViewImg,
				   mBtnMakeCall;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setupViewComponent();
    }

    private void setupViewComponent() {
    	mBtnBrowseWWW = (Button)findViewById(R.id.btnBrowseWWW);
		mBtnPlayMP3 = (Button)findViewById(R.id.btnPlayMP3);
		mBtnViewImg = (Button)findViewById(R.id.btnViewImg);
		mBtnMakeCall = (Button)findViewById(R.id.btnMakeCall);
				   
    	mBtnBrowseWWW.setOnClickListener(btnBrowseWWWOnClickLis);
		mBtnPlayMP3.setOnClickListener(btnPlayMP3OnClickLis);
		mBtnViewImg.setOnClickListener(btnViewImgOnClickLis);
		mBtnMakeCall.setOnClickListener(btnMakeCallOnClickLis);
    }

    private Button.OnClickListener btnBrowseWWWOnClickLis = new Button.OnClickListener() {
		public void onClick(View v) {
			Uri uri = Uri.parse("http://developer.android.com/");
			Intent it = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(it);
		}
	};

	private Button.OnClickListener btnPlayMP3OnClickLis = new Button.OnClickListener() {
		public void onClick(View v) {
			Intent it = new Intent(Intent.ACTION_VIEW);
			File file = new File("/sdcard/song.mp3");  
			it.setDataAndType(Uri.fromFile(file), "audio/*"); 
			startActivity(it);
		}
	};

	private Button.OnClickListener btnViewImgOnClickLis = new Button.OnClickListener() {
		public void onClick(View v) {
			Intent it = new Intent(Intent.ACTION_VIEW);
			File file = new File("/sdcard/image.png");  
			it.setDataAndType(Uri.fromFile(file), "image/*"); 
			startActivity(it);
		}
	};

	private Button.OnClickListener btnMakeCallOnClickLis = new Button.OnClickListener() {
		public void onClick(View v) {
			Uri uri = Uri.parse("tel:0921888168");
			Intent it = new Intent(Intent.ACTION_DIAL, uri);
			startActivity(it);
		}
	};
}