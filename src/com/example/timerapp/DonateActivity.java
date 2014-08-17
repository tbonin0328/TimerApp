package com.example.timerapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.support.v4.app.Fragment;
import android.util.Log;

public class DonateActivity extends SingleFragmentActivity implements TimerConstants
{	
	private static final String TAG = "TimerActivity";
	
	@Override
	protected Fragment createFragment() {
		long timerId= getIntent().getLongExtra(TIMER_ID, -1);
		
		if(timerId != -1)
		{
			Log.d(TAG, "newInstance if entered");
			return DonateFragment.newInstance(timerId);
		}
		else
		{
			Log.d(TAG, "newInstance else entered");
			return new DonateFragment();
		}
	}
}
