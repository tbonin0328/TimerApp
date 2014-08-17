package com.example.timerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.format.Time;
import android.util.Log;

public class TimerDatabaseHelper extends SQLiteOpenHelper
{
	private static final String DB_NAME = "timer3.sqlight";
	private static final int VERSION = 1;
//	
//	private static final String TABLE_TIMER = "timer";
//	private static final String COLUMN_TIMER_ID = "_id";
//	private static final String COLUMN_TIMER_TITLE = "title";
//	private static final String COLUMN_TIMER_DESCRIPTION = "description";
//	private static final String COLUMN_TIMER_MESSAGE = "message";
//	private static final String COLUMN_TIMER_URL = "url";
//	private static final String COLUMN_TIMER_START = "abs_start_time";
//	private static final String COLUMN_TIMER_END = "abs_time_app_ended";
//	private static final String COLUMN_COUNTDOWN_AMT = "countdown_amt";
//	private static final String COLUMN_TIMER_TYPE = "type";
//	private static final String COLUMN_TIMER_STATUS = "status";
//	private static final String COLUMN_TIMER_PIC = "timer_pic";
//	
//	private static final String TAG = "DBHelper";
//	
	private static TimerDatabaseHelper databaseHelper;
//
	private TimerDatabaseHelper(Context context)
	{
		super(context, DB_NAME, null, VERSION);
	}
//	
	public static TimerDatabaseHelper get(Context context)
	{
		if(databaseHelper == null)
		{
			databaseHelper = new TimerDatabaseHelper(context.getApplicationContext());
		}
		
		return databaseHelper;
	}
//
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
//		db.execSQL("create table " + TABLE_TIMER +
//				"(_id integer primary key autoincrement, title TEXT, description TEXT, message TEXT, start TEXT, "
//				+ "end TEXT, amount LONG, url TEXT, type INT, status INT, pic TEXT)");
//		
//		Time now = new Time();
//		now.setToNow();
//		
//		insertTimer("20 Minute Timer", "Runs for 20 minutes", "", now.toString(), "", 120000, "www.facebook.com", 0, 0, 
//				"iconsmall.png");
//		
//		Log.d(TAG,"Created");
	}
//
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
//	
//	public long insertTimer(Timer timer)
//	{
//		Log.d(TAG,"insertTimer entered");
//		ContentValues cv = new ContentValues();
//		cv.put(COLUMN_TIMER_TITLE, timer.getTitle());
//		cv.put(COLUMN_TIMER_DESCRIPTION, timer.getDescription());
//		cv.put(COLUMN_TIMER_MESSAGE, timer.getMessage());
//		cv.put(COLUMN_TIMER_START, timer.getAbs_start_time());
//		cv.put(COLUMN_TIMER_END, timer.getAbs_time_app_ended());
//		cv.put(COLUMN_COUNTDOWN_AMT, timer.getCountdown_amt());
//		cv.put(COLUMN_TIMER_URL, timer.getURL());
//		cv.put(COLUMN_TIMER_TYPE, timer.getType());
//		cv.put(COLUMN_TIMER_STATUS, timer.getStatus());
//		cv.put(COLUMN_TIMER_PIC, timer.getTimer_pic());
//		
//		Log.d(TAG,"insertTimer exited");
//		
//		return getWritableDatabase().insert(TABLE_TIMER, null, cv);
//	}
//	
//	public long insertTimer (String title, String description, String message, String abs_start_time, String abs_time_app_ended, long countdown_amt, 
//			String URL, int type, int status, String timer_pic) 
//	{
//		ContentValues cv = new ContentValues();
//		cv.put(COLUMN_TIMER_TITLE, title);
//		cv.put(COLUMN_TIMER_DESCRIPTION, description);
//		cv.put(COLUMN_TIMER_MESSAGE, message);
//		cv.put(COLUMN_TIMER_START, abs_start_time);
//		cv.put(COLUMN_TIMER_END, abs_time_app_ended);
//		cv.put(COLUMN_COUNTDOWN_AMT, countdown_amt);
//		cv.put(COLUMN_TIMER_URL, URL);
//		cv.put(COLUMN_TIMER_TYPE, type);
//		cv.put(COLUMN_TIMER_STATUS, status);
//		cv.put(COLUMN_TIMER_PIC, timer_pic);
//		
//		return getWritableDatabase().insert(TABLE_TIMER, null, cv);
//		
//	}
//	
//	public void updateTimer(Timer timer)
//	{
//		Log.d(TAG,"updateTimer Entered");
//		ContentValues cv = new ContentValues();
//		cv.put(COLUMN_TIMER_TITLE, timer.getTitle());
//		cv.put(COLUMN_TIMER_DESCRIPTION, timer.getDescription());
//		cv.put(COLUMN_TIMER_MESSAGE, timer.getMessage());
//		cv.put(COLUMN_TIMER_START, timer.getAbs_start_time());
//		cv.put(COLUMN_TIMER_END, timer.getAbs_time_app_ended());
//		cv.put(COLUMN_TIMER_URL, timer.getURL());
//		cv.put(COLUMN_TIMER_TYPE, timer.getType());
//		cv.put(COLUMN_TIMER_STATUS, timer.getStatus());
//		
//		getWritableDatabase().update(TABLE_TIMER, cv, "_id=" + timer.getId(), null);
//		Log.d(TAG,"updateTimer done");
//	}
//	
//	public long deleteTimer(TimerCursor stuff, int id)
//	{
//		Log.d(TAG,"deleteTimer entered");
//		
//		return getWritableDatabase().delete(TABLE_TIMER, "_id=" + id, null);
//	}
//	
//	public TimerCursor queryTimers()
//	{
//		Log.d(TAG,"queryTimers entered");
//		Cursor cursor = getReadableDatabase().query(TABLE_TIMER, 
//				null, null, null, null, null,
//				COLUMN_TIMER_TITLE + " asc");
//		
//		Log.d(TAG,"queryTimers exited");
//		
//		return new TimerCursor(cursor);
//	
//	}
//	
//	public TimerCursor queryTimer(long id)
//	{
//		Log.d(TAG,"queryTimer entered");
//		Cursor cursor = getReadableDatabase().query(TABLE_TIMER, null, 
//				COLUMN_TIMER_ID + "=?", new String[]{String.valueOf(id)},
//				null, null, null, "1");
//		
//		Log.d(TAG,"queryTimer exited");
//		return new TimerCursor(cursor);
//	}
//		
//	public static class TimerCursor extends CursorWrapper
//	{
//		public TimerCursor(Cursor cursor)
//		{
//			super(cursor);
//		}
//		
//		public Timer getTimer()
//		{
//			Log.d(TAG,"getTimer entered");
//			
//			if(isBeforeFirst() || isAfterLast()) return null;
//	
//			Timer timer= new Timer(getString(getColumnIndex(COLUMN_TIMER_TITLE)),
//					getString(getColumnIndex(COLUMN_TIMER_DESCRIPTION)),
//					getString(getColumnIndex(COLUMN_TIMER_MESSAGE)),
//					getString(getColumnIndex(COLUMN_TIMER_START)),
//					getString(getColumnIndex(COLUMN_TIMER_END)),
//					getLong(getColumnIndex(COLUMN_COUNTDOWN_AMT)),
//					getString(getColumnIndex(COLUMN_TIMER_URL)),
//					getInt(getColumnIndex(COLUMN_TIMER_TYPE)),
//					getInt(getColumnIndex(COLUMN_TIMER_STATUS)),
//					getString(getColumnIndex(COLUMN_TIMER_PIC)));
//			timer.setId(getLong(getColumnIndex(COLUMN_TIMER_ID)));
//			
//			Log.d(TAG,"getTimer exited");
//			
//			return timer;
//		}
//	}
}
