package tw.android;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.*;
import android.graphics.drawable.shapes.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setupViewComponent();
    }

	private void setupViewComponent() {
    	Button btnStart = (Button)findViewById(R.id.btnStart);
    	btnStart.setOnClickListener(btnStartOnClick);
    }
    
    private Button.OnClickListener btnStartOnClick = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
	        ImageView imgView1 = (ImageView)findViewById(R.id.imgView1);
	        ImageView imgView2 = (ImageView)findViewById(R.id.imgView2);
	        ImageView imgView3 = (ImageView)findViewById(R.id.imgView3);
	        
	        Resources res = getResources();
	        
	        Drawable drawImg = res.getDrawable(R.drawable.img01);
	        imgView1.setBackgroundDrawable(drawImg);
	        
	        TransitionDrawable drawTran = (TransitionDrawable)res.getDrawable(R.drawable.tran_drawable);
	        imgView2.setImageDrawable(drawTran);
	        drawTran.startTransition(5000);

	        GradientDrawable gradShape = new GradientDrawable();
	        gradShape.setShape(GradientDrawable.OVAL);
			gradShape.setColor(0xffffff00);
	        imgView3.setBackgroundDrawable(gradShape);
		}
    };

}