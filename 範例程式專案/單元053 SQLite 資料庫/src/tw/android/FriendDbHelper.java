package tw.android;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class FriendDbHelper extends SQLiteOpenHelper {
	
	public String sCreateTableCommand;

	public FriendDbHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		Log.d("FriendDbHelper", "FriendDbHelper()");
		
		sCreateTableCommand="";
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.d("FriendDbHelper", "onCreate()");
		
		if (sCreateTableCommand.isEmpty())
			return;
		
		db.execSQL(sCreateTableCommand);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
		// TODO Auto-generated method stub
		Log.d("FriendDbHelper", "onUpgrade()");
	}

}
