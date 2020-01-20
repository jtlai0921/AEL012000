package tw.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class HobbySel extends Activity {
	
	private CheckBox chbMusic,
					 chbSing,
					 chbDance,
					 chbTravel,
					 chbReading,
					 chbWriting,
					 chbClimbing,
					 chbSwim,
					 chbExercise,
					 chbFitness;
	private Button btnSelOK;
	private TextView txtHobList;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setupViewComponent();
    }
    
    private void setupViewComponent() {
        // �q�귽���OR�����o��������
    	chbMusic = (CheckBox)findViewById(R.id.chbMusic);
    	chbSing = (CheckBox)findViewById(R.id.chbSing);
    	chbDance = (CheckBox)findViewById(R.id.chbDance);
    	chbTravel = (CheckBox)findViewById(R.id.chbTravel);
    	chbReading = (CheckBox)findViewById(R.id.chbReading);
    	chbWriting = (CheckBox)findViewById(R.id.chbWriting);
    	chbClimbing = (CheckBox)findViewById(R.id.chbClimbing);
    	chbSwim = (CheckBox)findViewById(R.id.chbSwim);
    	chbExercise = (CheckBox)findViewById(R.id.chbExercise);
    	chbFitness = (CheckBox)findViewById(R.id.chbFitness);
        btnSelOK = (Button)findViewById(R.id.btnSelOK);
    	txtHobList = (TextView)findViewById(R.id.txtHobList);
    	
    	// �]�wbutton���󪺨ƥ�listener
    	btnSelOK.setOnClickListener(btnSelOKOnClick);
    }
    
    private Button.OnClickListener btnSelOKOnClick = new Button.OnClickListener() {
		public void onClick(View v) {
			String s = getString(R.string.hobList);
			
			if (chbMusic.isChecked())
				s += chbMusic.getText().toString();
			
			if (chbSing.isChecked())
				s += chbSing.getText().toString();
			
			if (chbDance.isChecked())
				s += chbDance.getText().toString();
			
			if (chbTravel.isChecked())
				s += chbTravel.getText().toString();
			
			if (chbReading.isChecked())
				s += chbReading.getText().toString();
			
			if (chbWriting.isChecked())
				s += chbWriting.getText().toString();
			
			if (chbClimbing.isChecked())
				s += chbClimbing.getText().toString();
			
			if (chbSwim.isChecked())
				s += chbSwim.getText().toString();
			
			if (chbExercise.isChecked())
				s += chbExercise.getText().toString();
			
			if (chbFitness.isChecked())
				s += chbFitness.getText().toString();
			
			txtHobList.setText(s);
		}
	};
}