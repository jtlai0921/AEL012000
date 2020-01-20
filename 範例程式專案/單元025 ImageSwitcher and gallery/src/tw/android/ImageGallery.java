package tw.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.*;
import android.widget.Gallery.LayoutParams;

public class ImageGallery extends Activity implements ViewSwitcher.ViewFactory {

	private ImageSwitcher imgSwi;
	private Gallery gal;

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
        // �q�귽���OR�����o��������
    	imgSwi = (ImageSwitcher) findViewById(R.id.imgSwi);
    	imgSwi.setFactory(this);	// ����implements ViewSwitcher.ViewFactory
    	imgSwi.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
    	imgSwi.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));

    	ImageAdapter imgAdap = new ImageAdapter(this);
    	imgAdap.setImageArray(thumbImgArr);
    	
        gal = (Gallery) findViewById(R.id.gal);
        gal.setAdapter(imgAdap);
        gal.setOnItemSelectedListener(adaViewItemSelLis);
    }
    
    public View makeView() {
        ImageView v = new ImageView(this);
        v.setBackgroundColor(0xFF000000);
        v.setScaleType(ImageView.ScaleType.FIT_CENTER);
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
			imgSwi.setImageResource(imgArr[position]);
		}
		public void onNothingSelected(AdapterView parent) {
		}
    };
}