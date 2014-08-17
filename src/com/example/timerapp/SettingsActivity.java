package com.example.timerapp;

import android.support.v4.app.Fragment;
import android.util.Log;

public class SettingsActivity extends SingleFragmentActivity implements TimerConstants
{	
	private static final String TAG = "TimerActivity";
	
	@Override
	protected Fragment createFragment() {
		long timerId= getIntent().getLongExtra(TIMER_ID, -1);
		
		if(timerId != -1)
		{
			Log.d(TAG, "newInstance if entered");
			return SettingsFragment.newInstance(timerId);
		}
		else
		{
			Log.d(TAG, "newInstance else entered");
			return new SettingsFragment();
		}
	}
}