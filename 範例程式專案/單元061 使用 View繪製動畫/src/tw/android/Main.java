package tw.android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ShapeView shapeView = new ShapeView(this);
        setContentView(shapeView);
    }
}