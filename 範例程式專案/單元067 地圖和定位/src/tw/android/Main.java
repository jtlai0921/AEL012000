package tw.android;

import java.util.List;

import com.google.android.maps.*;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class Main extends MapActivity {
	
	private MyLocationOverlay mMyLocation;
	
	private static String[][] locations = {
			{"�x�W�j��", "25.019943,121.542353"},
	        {"�M�ؤj��", "24.795621,120.998153"},
	        {"��q�j��", "24.791704,121.003341"},
	        {"���\�j��", "23.000875,120.218017"}};

	private Spinner mSpnLocation;
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
    
    private void setupViewComponent() {
        mSpnLocation = (Spinner) this.findViewById(R.id.spnLocation);
        mMapView = (MapView) findViewById(R.id.map);

        mMapCtrl = mMapView.getController();
    	mMapCtrl.setZoom(18);

    	List<Overlay> mapOverlays = mMapView.getOverlays();

    	mMyLocation = new MyLocationOverlay(this, mMapView);
    	mMyLocation.runOnFirstFix(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mMapCtrl.animateTo(mMyLocation.getMyLocation());
			}
    	});
    	mapOverlays.add(mMyLocation);

    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item);

        for (int i = 0; i < locations.length; i++)
        	adapter.add(locations[i][0]);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpnLocation.setAdapter(adapter);
        mSpnLocation.setOnItemSelectedListener(mSpnLocationOnItemSelLis);
    }

    @Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mMyLocation.enableMyLocation();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		mMyLocation.disableMyLocation();
		super.onStop();
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

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}