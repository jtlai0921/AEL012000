package tw.android;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

public class MapItemizedOverlay extends ItemizedOverlay<OverlayItem> {
	
	private OverlayItem mOverlayItem;
	
	Context mContext;

	public MapItemizedOverlay(Drawable d, Context context) {
		super(d);
		// TODO Auto-generated constructor stub
		mContext = context;
	}

	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		// TODO Auto-generated method stub
		super.draw(canvas, mapView, false);
	}

	@Override
	protected boolean onTap(int index) {
		// TODO Auto-generated method stub
//		OverlayItem item = mOverlayItems.get(index);
		AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
		dialog.setTitle(mOverlayItem.getTitle());
		dialog.setMessage(mOverlayItem.getSnippet());
		dialog.show();
		return super.onTap(0);
	}

	public void addOverlay(OverlayItem overlayItem) {
		mOverlayItem = overlayItem;
		populate();
	}

	@Override
	protected OverlayItem createItem(int i) {
		// TODO Auto-generated method stub
		return mOverlayItem;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 1;
	}
}
