package com.example.timerapp;

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

public class SelectedTimerFragment extends Fragment implements TimerConstants
{
	
	private Timer timer;
	private int id;
	private int pos;

	private TimerSet timerSet;
	
	private View view;
	private TextView viewTime;
    private long timeElapsed;
    private boolean timerHasStarted = false;
	
	ImageButton pauseImageButton;	
	
	private static final String TAG = "TimerFrag";
	private boolean pauseSwitcher = false;
	long s1 = 0;
	private CountDownTimer Counter;
	
	public static SelectedTimerFragment newInstance(long timerId)
	{
		Bundle args = new Bundle();
		args.putLong(TIMER_ID, timerId);
		SelectedTimerFragment selectedTimerFragment = new SelectedTimerFragment();
		selectedTimerFragment.setArguments(args);
		
		return selectedTimerFragment;
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
					        Log.d(TAG, "timer running in SelectedTimerFragment " + s1);
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
		//setRetainInstance(true);
		
		int id = 0;
		
		if(getArguments() == null)
		{
			id = getActivity().getIntent().getIntExtra(TIMER_ID, 0);
		}
		else
		{
			id = getArguments().getInt(TIMER_ID);
		}
		
		timer = TimerSet.newInstance().getTimers().get(id);

		setRetainInstance(true);

		Log.d(TAG, "Timer id is " + id);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_selected_timer, container, false);
		
		initPauseButton(view);
		initListButton();
		initSettingsButton();
		initShareButton();
		initDonateButton();
		
		Log.d(TAG, "Timer id is " + id);
		s1 = timer.getCountdown_amt();
		//timer.getCountdown_amt()
		{
			Log.d(TAG, "onCreateView of SelectedTimerFragement entered and amount equals" + s1);
			Counter = new CountDownTimer(s1, 1000) {

			    public void onTick(long millisUntilFinished) {
			        int seconds = (int) ((millisUntilFinished/1000)%60);
			        int minutes = (int) ((millisUntilFinished/1000)/60);
			        int hours = (int) ((millisUntilFinished/1000)/3600);
			        String startTime =String.format("%02d:%02d:%02d",hours,minutes,seconds);
			        viewTime = (TextView)view.findViewById(R.id.textView1);
			        viewTime.setText(startTime);
			        s1=millisUntilFinished;
			        Log.d(TAG, "timer running in SelectedTimerFragement " + s1);
			    }

			    public void onFinish() {
			        viewTime.setText("done!");
			    }   
			}.start();
	
		return view;
	}
}

}

