package com.example.timerapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class TimerListActivity extends SingleFragmentActivity 
implements TimerListFragment.Callbacks, TimerConstants
{

	@Override
	protected Fragment createFragment() {
		return new TimerListFragment();
	}
	
	protected int getLayoutResId()
	{
		return R.layout.activity_master_layout;
	}

	@Override
	public void onTimerSelected(int timerId) {
		
		if(findViewById(R.id.fragment_container) == null)  //portrait
		{
			Intent intent = new Intent(this, SelectedTimerActivity.class);
			intent. putExtra(TIMER_ID, timerId);
			startActivity(intent);
		}
		else //landscape
		{
			FragmentManager manager = getSupportFragmentManager();
			FragmentTransaction transaction = manager.beginTransaction();
			
			Fragment oldFragment =
					manager.findFragmentById(R.id.fragment_container);
			Fragment newFragment = 
					SelectedTimerFragment.newInstance(timerId);
			
			if(oldFragment != null) //if there was a startrek in the details
			{
				transaction.remove(oldFragment);
			}
			
			transaction.add(R.id.fragment_container, newFragment);
			transaction.commit();	
		}	
	}
}


