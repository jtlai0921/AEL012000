package tw.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.*;
import android.widget.*;
import android.widget.Gallery.LayoutParams;

public class ImageGallery extends Activity implements ViewSwitcher.ViewFactory {

	private ImageSwitcher imgSwi;
	private Gallery gal;
	private ImageGallery thisCont = this;

    private Integer[] imgArr = {
            R.drawable.img01, R.drawable.img02, R.drawable.img03,
            R.drawable.img04, R.drawable.img05, R.drawable.img06,
            R.drawable.img07, R.drawable.img08};
	
	private Integer[] thumbImgArr = {
            R.drawable.img01th, R.drawable.img02th, R.drawable.img03th,
            R.drawable.img04th, R.drawable.img05th, R.drawable.img06th,
            R.drawable.img07th, R.drawable.img08th};
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setupViewComponent();
    }
    
    private void setupViewComponent() {
        // 從資源類別R中取得介面元件
    	imgSwi = (ImageSwitcher) findViewById(R.id.imgSwi);
    	imgSwi.setFactory(this);	// 必須implements ViewSwitcher.ViewFactory
    	
/*    	當使用者在Gallery元件上點選時再隨機選擇動畫效果
    	ScaleAnimation anim_scale_in = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim_scale_in.setInterpolator(new LinearInterpolator());
        anim_scale_in.setStartOffset(700);
        anim_scale_in.setDuration(700);
        
    	RotateAnimation anim_rotate_in = new RotateAnimation(0, 360,
    			Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim_rotate_in.setInterpolator(new LinearInterpolator());
        anim_rotate_in.setStartOffset(700);
        anim_rotate_in.setDuration(700);

        AnimationSet anim_set = new AnimationSet(false);
    	anim_set.addAnimation(anim_scale_in);
    	anim_set.addAnimation(anim_rotate_in);
    	
        imgSwi.setInAnimation(anim_set);
*/
        ImageAdapter imgAdap = new ImageAdapter(this);
    	imgAdap.setImageArray(thumbImgArr);
    	
        gal = (Gallery) findViewById(R.id.gal);
        gal.setAdapter(imgAdap);
        gal.setOnItemSelectedListener(adaViewItemSelLis);
    }
    
    public View makeView() {
        ImageView v = new ImageView(this);
        v.setBackgroundColor(0xFF000000);
        v.setScaleType(ImageView.ScaleType.CENTER);
        v.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.FILL_PARENT));
        return v;
    }
    
    private AdapterView.OnItemSelectedListener adaViewItemSelLis =
    	new AdapterView.OnItemSelectedListener () {
		public void onItemSelected(AdapterView parent,
									View v,
									int position,
									long id) {
			switch ((int)(Math.random()*3 + 1)) {
			case 1:
				imgSwi.setInAnimation(AnimationUtils.loadAnimation(thisCont,
		                R.anim.anim_alpha_in));
				imgSwi.setOutAnimation(AnimationUtils.loadAnimation(thisCont,
		                R.anim.anim_alpha_out));
				break;
			case 2:
				imgSwi.setInAnimation(AnimationUtils.loadAnimation(thisCont,
		                R.anim.anim_trans_in));
				imgSwi.setOutAnimation(AnimationUtils.loadAnimation(thisCont,
		                R.anim.anim_trans_out));
				break;
			case 3:
				imgSwi.setInAnimation(AnimationUtils.loadAnimation(thisCont,
		                R.anim.anim_scale_rotate_in));
				imgSwi.setOutAnimation(AnimationUtils.loadAnimation(thisCont,
		                R.anim.anim_scale_rotate_out));
				break;
			}
			
			imgSwi.setImageResource(imgArr[position]);
		}
		public void onNothingSelected(AdapterView parent) {
		}
    };
}