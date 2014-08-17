package com.example.timerapp;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ShareFragment extends Fragment implements TimerConstants
{
	private View view;
	private Timer timer;
	private ArrayList<Timer> timers;
	private int id;
	private int pos;
	private static final String TAG = "ShareFrag";
	private TimerSet timerSet;
	
	//private UiLifecycleHelper uiHelper;
	
	EditText editText;

	public static ShareFragment newInstance(long timerId)
	{
		Bundle args = new Bundle();
		args.putLong(TIMER_ID, timerId);
		ShareFragment settingsFragment = new ShareFragment();
		settingsFragment.setArguments(args);
		
		return settingsFragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setRetainInstance(true);
		
		
		timers = TimerSet.newInstance().getTimers();
		timer = timers.get(0);
//		int id = 0;
//		
//		if(getArguments() == null)
//		{
//			id = getActivity().getIntent().getIntExtra(TIMER_ID, 0);
//		}
//		else
//		{
//			id = getArguments().getInt(TIMER_ID);
//		}
//		
//		timer = TimerSet.newInstance().getTimers().get(id);
//
//		setRetainInstance(true);

		Log.d(TAG, "Timer id is " + id);
	}
	
	private void addMessage(View view){

			
			//editText.addTextChangedListener(new TextWatcher() {
	       
			ImageButton facebookButton = (ImageButton) view.findViewById(R.id.imageButton1);
			editText = (EditText)view.findViewById(R.id.editText1);
	        facebookButton.setOnClickListener(new View.OnClickListener() {

	            @Override
	            public void onClick(View v) {
	                timer.setMessage(editText.getText().toString());
				    Toast.makeText(getActivity(),
					"OnClickListener : " + 
			                "Message: "+ editText.getText().toString(),
						Toast.LENGTH_SHORT).show();
	            }
				
				
//				@Override
//				public void afterTextChanged(Editable s) {}
//
//				@Override
//				public void beforeTextChanged(CharSequence s, int start, int count,
//						int after) {}
//
//				@Override
//				public void onTextChanged(CharSequence text, int start, int before,
//						int count) {
//					timer.setMessage(text.toString());
//				}
				
			});
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
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_share, container, false);
		
		initListButton();
		initSettingsButton();
		initShareButton();
		initDonateButton();
		addMessage(view);
		
		Log.d(TAG, "Share onCreate entered " + id);	
		return view;
	}
}