package tw.android;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Main extends Activity {
	
	private static final String DB_FILE = "friends.db",
								DB_TABLE = "friends";
	private SQLiteDatabase mFriDbRW;
	
	private EditText mEdtName,
					 mEdtSex,
					 mEdtAddr,
					 mEdtList;
	
	private Button mBtnAdd,
				   mBtnQuery,
				   mBtnList;

    @Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		mFriDbRW.close();
	}

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setupViewComponent();
        
        // �إߦۭq�� FriendDbHelper ����
        FriendDbHelper friDbHp = new FriendDbHelper(
        		getApplicationContext(), DB_FILE,
        		null, 1);
        
        // ���o�W�����w���ɦW��Ʈw�A�p�G���ɦW���s�b�N�|�۰ʫإߤ@�Ӹ�Ʈw�ɮ�
        // �M��I�s DbHelper ���� onCreate() ��k�A�ڭ̥i�H�b�Ӥ�k��
        // �إ߸�Ʈw���� table�A�άO�᭱�A�Q�Ψ��o�� SQLiteDatabase 
        // ����إ� table
        
        // �]�w�إ� table �����O
        friDbHp.sCreateTableCommand = "CREATE TABLE " + DB_TABLE + "(" +
        							"_id INTEGER PRIMARY KEY," +
        							"name TEXT NOT NULL," +
        							"sex TEXT," +
        							"address TEXT);";

        // �p�G���w����Ʈw�ɮפ��s�b�A�N�|���إ߸��ɡA�M�����W�����إ� table ���O
        mFriDbRW = friDbHp.getWritableDatabase();
    }
    
    private void setupViewComponent() {
    	mEdtName = (EditText)findViewById(R.id.edtName);
		mEdtSex = (EditText)findViewById(R.id.edtSex);
		mEdtAddr = (EditText)findViewById(R.id.edtAddr);
		mEdtList = (EditText)findViewById(R.id.edtList);

		mBtnAdd = (Button)findViewById(R.id.btnAdd);
		mBtnQuery = (Button)findViewById(R.id.btnQuery);
		mBtnList = (Button)findViewById(R.id.btnList);

		mBtnAdd.setOnClickListener(onClickBtnAdd);
		mBtnQuery.setOnClickListener(onClickBtnQuery);
		mBtnList.setOnClickListener(onClickBtnList);
    }

    private Button.OnClickListener onClickBtnAdd = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
	        
	        ContentValues newRow = new ContentValues();
	        newRow.put("name", mEdtName.getText().toString());
	        newRow.put("sex", mEdtSex.getText().toString());
	        newRow.put("address", mEdtAddr.getText().toString());
	        mFriDbRW.insert(DB_TABLE, null, newRow);
		}
    };

    private Button.OnClickListener onClickBtnQuery = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Cursor c = null;
			
			if (mEdtName.getText().toString().isEmpty() == false) {
				c = mFriDbRW.query(true, DB_TABLE, new String[]{"name", "sex", "address"},
						"name=" + "\"" + mEdtName.getText().toString() + "\"",
						null, null, null, null, null);
			}
			else if (mEdtSex.getText().toString().isEmpty() == false) {
				c = mFriDbRW.query(true, DB_TABLE, new String[]{"name", "sex", "address"},
						"sex=" + mEdtSex.getText().toString(),
						null, null, null, null, null);
			}
			else if (mEdtAddr.getText().toString().isEmpty() == false) {
				c = mFriDbRW.query(true, DB_TABLE, new String[]{"name", "sex", "address"},
						"address=" + mEdtAddr.getText().toString(),
						null, null, null, null, null);
			}
			
			if (c == null)
				return;

			if (c.getCount() == 0) {
				mEdtList.setText("");
				Toast.makeText(Main.this, "�S���o�����", Toast.LENGTH_LONG)
					.show();
			}
			else {
				c.moveToFirst();
				mEdtList.setText(c.getString(0) + c.getString(1)  + c.getString(2));
				
				while (c.moveToNext())
					mEdtList.append("\n" + c.getString(0) + c.getString(1)  + c.getString(2));
			}
		}
    };

    private Button.OnClickListener onClickBtnList = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Cursor c = mFriDbRW.query(true, DB_TABLE, new String[]{"name", "sex", "address"},
						null, null, null, null, null, null);
			
			if (c == null)
				return;

			if (c.getCount() == 0) {
				mEdtList.setText("");
				Toast.makeText(Main.this, "�S�����", Toast.LENGTH_LONG)
					.show();
			}
			else {
				c.moveToFirst();
				mEdtList.setText(c.getString(0) + c.getString(1)  + c.getString(2));
				
				while (c.moveToNext())
					mEdtList.append("\n" + c.getString(0) + c.getString(1)  + c.getString(2));
			}
		}
    };
}