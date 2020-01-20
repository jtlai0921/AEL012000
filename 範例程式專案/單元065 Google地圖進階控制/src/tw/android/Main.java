package tw.android;

import com.google.android.maps.*;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class Main extends MapActivity {

	private static String[][] locations = {
			{"�x�W�j��", "25.019943,121.542353"},
	        {"�M�ؤj��", "24.795621,120.998153"},
	        {"��q�j��", "24.791704,121.003341"},
	        {"���\�j��", "23.000875,120.218017"}};

	private static String[] mapType = {
			"��D��",
		 	"�ìP��"};

	private Spinner mSpnLocation, mSpnMapType;
	private MapView mMapView;
	private MapController mMapCtrl;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setupViewComponent();

        setMapLocation();
    }
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		
		int nextZoom, zoom;
		switch (keyCode) {
		case KeyEvent.KEYCODE_I:
			nextZoom = mMapView.getZoomLevel() + 1;
			zoom = nextZoom > mMapView.getMaxZoomLevel() ?
					mMapView.getMaxZoomLevel() : nextZoom;
			mMapCtrl.setZoom(zoom);
			break;
		case KeyEvent.KEYCODE_O:
			nextZoom = mMapView.getZoomLevel() - 1;
			zoom = nextZoom < 1 ?
					1 : nextZoom;
			mMapCtrl.setZoom(zoom);
			break;
		}

		return super.onKeyDown(keyCode, event);
	}
    
    private void setupViewComponent() {
        mSpnLocation = (Spinner) this.findViewById(R.id.spnLocation);
        mSpnMapType = (Spinner) this.findViewById(R.id.spnMapType);
        mMapView = (MapView) findViewById(R.id.map);
        
        mMapCtrl = mMapView.getController();
        mMapView.setBuiltInZoomControls(true);
    	mMapCtrl.setZoom(18);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item);

        for (int i = 0; i < locations.length; i++)
        	adapter.add(locations[i][0]);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpnLocation.setAdapter(adapter);
        mSpnLocation.setOnItemSelectedListener(mSpnLocationOnItemSelLis);

        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item);

        for (int i = 0; i < mapType.length; i++)
        	adapter.add(mapType[i]);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpnMapType.setAdapter(adapter);
        mSpnMapType.setOnItemSelectedListener(mSpnMapTypeOnItemSelLis);
    }

    private OnItemSelectedListener mSpnLocationOnItemSelLis = new OnItemSelectedListener() {
 		@Override
		public void onItemSelected(AdapterView parent, View v, int position, long id) {
			// TODO Auto-generated method stub

 			setMapLocation();
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		}
    };

    public void setMapLocation() {
    	int iSelect = mSpnLocation.getSelectedItemPosition();
    	String[] sLocation = locations[iSelect][1].split(",");
    	double dLat = Double.parseDouble(sLocation[0]);	// �n�_�n
    	double dLon = Double.parseDouble(sLocation[1]);	// �F��g
    	GeoPoint gp = new GeoPoint((int)(dLat * 1e6), (int)(dLon * 1e6));
    	mMapCtrl.animateTo(gp);
    }

    private OnItemSelectedListener mSpnMapTypeOnItemSelLis = new OnItemSelectedListener() {
 		@Override
		public void onItemSelected(AdapterView parent, View v, int position, long id) {
			// TODO Auto-generated method stub

 			switch (position) {
 			case 0:
 				mMapView.setSatellite(false);
 				break;
 			case 1:
 				mMapView.setSatellite(true);
 				break;
 			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		}
    };

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}