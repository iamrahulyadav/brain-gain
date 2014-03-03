package com.opendevsolutions.sql.lib;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLSaveData {
	public static final String KEY_ROWID = "_id";
	public static final String KEY_QNAME = "q_name";
	public static final String KEY_SCORE = "q_score";
	public static final String KEY_DATE = "q_date";
	
	private static final String DATABASE_NAME = "BrainGainDB";
	private static final String DATABASE_TABLE = "quiz_records";
	private static final int DATABASE_VERSION = 1;
	
	private DBHelper mHelper;
	private final Context mContext;
	private SQLiteDatabase mDatabase;
	
	private static class DBHelper extends SQLiteOpenHelper{

		public DBHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" + 
						KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
						KEY_QNAME + " TEXT NOT NULL, " + 
						KEY_SCORE + " TEXT NOT NULL, " + 
						KEY_DATE + " TEXT NOT NULL);");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}
		
	}
	
	public void createTable(){
		mDatabase.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" + 
				KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
				KEY_QNAME + " TEXT NOT NULL, " + 
				KEY_SCORE + " TEXT NOT NULL, " + 
				KEY_DATE + " TEXT NOT NULL);");
	}
	
	public void dropTable(){
		mDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
	}
	
	public SQLSaveData(Context c){
		mContext = c;
	}
	
	public SQLSaveData open() throws SQLException{
		mHelper = new DBHelper(mContext);
		mDatabase = mHelper.getWritableDatabase();
		return this;
	}
	
	public void close(){
		mHelper.close();
	}

	public long createData(String qName, String score, String date) {
		ContentValues cv = new ContentValues();
		cv.put(KEY_QNAME, qName);
		cv.put(KEY_SCORE, score);
		cv.put(KEY_DATE, date);
		return mDatabase.insert(DATABASE_TABLE, null, cv);
	}

	public String getData() {
		String[] column = new String[]{KEY_ROWID, KEY_QNAME, KEY_SCORE, KEY_DATE};
		Cursor c = mDatabase.query(DATABASE_TABLE, column, null, null, null, null, null);
		String result = "";
		
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iQName = c.getColumnIndex(KEY_QNAME);
		int iScore = c.getColumnIndex(KEY_SCORE);
		int iDate = c.getColumnIndex(KEY_DATE);
		
		for(c.moveToFirst(); !c.isAfterLast();c.moveToNext()){
			result = result + c.getString(iQName) + " | " + c.getString(iScore) + " | " + c.getString(iDate) + "\n";
		}
		
		return result;
	}
	
}
