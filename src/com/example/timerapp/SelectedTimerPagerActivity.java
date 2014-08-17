package com.example.timerapp;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class SelectedTimerPagerActivity extends FragmentActivity implements TimerConstants 
{
	private ViewPager viewPager;
	private ArrayList<Timer> timerSet = TimerSet.newInstance().getTimers();;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		
		viewPager = new ViewPager(this);
		viewPager.setId(R.id.viewPager);
		setContentView(viewPager);
		
		FragmentManager manager = getSupportFragmentManager();
		viewPager.setAdapter(new FragmentStatePagerAdapter(manager){

			@Override
			public Fragment getItem(int position) {
				Timer item = timerSet.get(position);
				return SelectedTimerFragment.newInstance(position);
			}

			@Override
			public int getCount() {
				return timerSet.size();
			}
		});
		
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				System.out.println("onPageScrollStateChanged: " + arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				System.out.println("onPageScrolled:" + arg0 + ", " + arg1 + ", " + arg2);
			}

			@Override
			public void onPageSelected(int pos) {
				Timer item = timerSet.get(pos);
				setTitle(item.getTitle());
				System.out.println("onPageSelected:" + pos);
			}
		});
		int id = getIntent().getIntExtra(TIMER_ID, 0);
		viewPager.setCurrentItem(id);
	}
}
