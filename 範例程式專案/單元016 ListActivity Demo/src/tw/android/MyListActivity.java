package tw.android;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MyListActivity extends ListActivity {
	
	private TextView mTxtResult;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setupViewComponent();
    }
    
    private void setupViewComponent() {
        mTxtResult = (TextView)findViewById(R.id.txtResult);
        
        ArrayAdapter<CharSequence> adapWeekday = ArrayAdapter.createFromResource(
				this, R.array.weekday, android.R.layout.simple_list_item_1);
        setListAdapter(adapWeekday);
        
        ListView listview = getListView();
        listview.setTextFilterEnabled(true);

        listview.setOnItemClickListener(listviewOnItemClkLis);
    }
	
	AdapterView.OnItemClickListener listviewOnItemClkLis = new AdapterView.OnItemClickListener() {
	    public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
	      // When clicked, show a toast with the TextView text
	      mTxtResult.setText(((TextView) view).getText());
	    }
    };
}