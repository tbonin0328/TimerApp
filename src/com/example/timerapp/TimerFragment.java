package com.example.timerapp;

import java.io.Serializable;
import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class TimerFragment extends Fragment implements TimerConstants
{
	
	private Timer timer;
	private int id;
	private int pos;
	private static ArrayList<Timer> timerSet;
	
	private View view;
	private TextView viewTime;
    private long timeElapsed;
    private boolean timerHasStarted = false;
	
	ImageButton pauseImageButton;	
	
	private static final String TAG = "TimerFrag";
	private boolean pauseSwitcher = false;
	long s1 = 1200000;
	private CountDownTimer Counter;
	
	public static TimerFragment newInstance(long timerId)
	{
		
		Bundle args = new Bundle();
		args.putLong(TIMER_ID, timerId);
		TimerFragment timerFragment = new TimerFragment();
		timerFragment.setArguments(args);
		
		return timerFragment;
	}
	
	private void initListButton()
	{
		ImageButton imageButton = (ImageButton)view.findViewById(R.id.imageButton2);
		imageButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TimerListActivity.class);
				startActivity(intent);
			}
			
		});
	}
	
	private void initSettingsButton()
	{
		ImageButton imageButton = (ImageButton)view.findViewById(R.id.imageButton3);
		imageButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), SettingsActivity.class);
				startActivity(intent);
			}
			
		});
	}
	
	private void initShareButton()
	{
		ImageButton imageButton = (ImageButton)view.findViewById(R.id.imageButton4);
		imageButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), ShareActivity.class);
				startActivity(intent);
			}
			
		});
	}
	
	private void initDonateButton()
	{
		ImageButton imageButton = (ImageButton)view.findViewById(R.id.imageButton5);
		imageButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), DonateActivity.class);
				startActivity(intent);
			}
			
		});
	}
	
	
	
	public void initPauseButton(View view)
	{
		pauseImageButton = (ImageButton)view.findViewById(R.id.imageButton1);
		 
		pauseImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if(!pauseSwitcher) 
			    {
			    	Counter.cancel();
			        pauseSwitcher = true;
			        Log.d(TAG, "timer paused in SelectedTimerFragment" + s1);

			    }
			    else
			    {
			    	long timervalue = s1;
			        pauseSwitcher = false;
			        Counter = new CountDownTimer(timervalue, 1000) {

					    public void onTick(long millisUntilFinished) {
					        int seconds = (int) ((millisUntilFinished/1000)%60);
					        int minutes = (int) ((millisUntilFinished/1000)/60);
					        int hours = (int) ((millisUntilFinished/1000)/3600);
					        String startTime =String.format("%02d:%02d:%02d",hours,minutes,seconds);
					        viewTime.setText(startTime);
					        s1=millisUntilFinished;
					    }

					    public void onFinish() {
					        viewTime.setText("done!");
					    }   
					}.start();
			    }
			}		
		});
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
		
		timerSet = TimerSet.newInstance().getTimers();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_timer, container, false);
		
		initPauseButton(view);
		initListButton();
		initSettingsButton();
		initShareButton();
		initDonateButton();
		
		timer = timerSet.get(2);
		//timer.getCountdown_amt()
		{
			Counter = new CountDownTimer(timer.getCountdown_amt(), 1000) {

			    public void onTick(long millisUntilFinished) {
			        int seconds = (int) ((millisUntilFinished/1000)%60);
			        int minutes = (int) ((millisUntilFinished/1000)/60);
			        int hours = (int) ((millisUntilFinished/1000)/3600);
			        String startTime =String.format("%02d:%02d:%02d",hours,minutes,seconds);
			        viewTime = (TextView)view.findViewById(R.id.textView1);
			        viewTime.setText(startTime);
			        s1=millisUntilFinished;
			        Log.d(TAG, "timer running in TimerFragment " + s1);
			    }

			    public void onFinish() {
			        viewTime.setText("done!");
			    }   
			}.start();
	
		return view;
	}
}

}
