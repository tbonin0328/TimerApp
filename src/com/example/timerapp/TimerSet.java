package com.example.timerapp;

import java.util.ArrayList;

import android.text.format.Time;

public class TimerSet {
	
	private static TimerSet timerSet;
	private static ArrayList<Timer> timers = new ArrayList<Timer>();
	
	private TimerSet()
	{
		Time now = new Time();
		now.setToNow();
		
		timers.add(new Timer("3 Minute Timer", //title
				"Runs for 3 minutes", //description 
				"", //message
				now.toString(), //abs_start_time
				"", //abs_time_app_ended 
				180000, //countdown_amt
				"www.facebook.com", //URL
				0, //status
				0, //type
				R.drawable.iconsmall_3m)); //timer_pic
		timers.add(new Timer("5 Minute Timer", //title
				"Runs for 5 minutes", //description 
				"", //message
				now.toString(), //abs_start_time
				"", //abs_time_app_ended 
				3000000, //countdown_amt
				"www.facebook.com", //URL
				0, //status
				0, //type
				R.drawable.iconsmall_5m)); //timer_pic
		timers.add(new Timer("20 Minute Timer", //title
				"Runs for 20 minutes", //description 
				"", //message
				now.toString(), //abs_start_time
				"", //abs_time_app_ended 
				1200000, //countdown_amt
				"www.facebook.com", //URL
				0, //status
				0, //type
				R.drawable.iconsmall)); //timer_pic
		timers.add(new Timer("30 Minute Timer", //title
				"Runs for 30 minutes", //description 
				"", //message
				now.toString(), //abs_start_time
				"", //abs_time_app_ended 
				1800000, //countdown_amt
				"www.facebook.com", //URL
				0, //status
				0, //type
				R.drawable.iconsmall_30m)); //timer_pic
		timers.add(new Timer("45 Minute Timer", //title
				"Runs for 45 minutes", //description 
				"", //message
				now.toString(), //abs_start_time
				"", //abs_time_app_ended 
				2700000, //countdown_amt
				"www.facebook.com", //URL
				0, //status
				0, //type
				R.drawable.iconsmall_45m)); //timer_pic
		
		timers.add(new Timer("60 Minute Timer", //title
				"Runs for 60 minutes", //description 
				"", //message
				now.toString(), //abs_start_time
				"", //abs_time_app_ended 
				3600000, //countdown_amt
				"www.facebook.com", //URL
				0, //status
				0, //type
				R.drawable.iconsmall_60m)); //timer_pic
	}
	
	public static TimerSet newInstance()
	{
		if(timerSet == null)
		{
			timerSet = new TimerSet();
		}
		
		return timerSet;
	}
	
	public ArrayList<Timer> getTimers()
	{
		return timers;
	}
	
	public static void addTimer(Timer timer)
	{
		timers.add(timer);
	}
	
	public static void deleteTimer(Timer timer)
	{
		timers.remove(timer);
	}
		
}
	