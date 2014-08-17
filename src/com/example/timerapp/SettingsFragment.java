package com.example.timerapp;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsFragment extends Fragment implements TimerConstants
{
	private View view;
	private Timer timer;
	private int id;
	private int pos;
	private static final String TAG = "SettingsFrag";
	private TimerSet timerSet;
	
	private Spinner spinner1, spinner2;
	private Button btnSubmit;
	

	public static SettingsFragment newInstance(long timerId)
	{
		Bundle args = new Bundle();
		args.putLong(TIMER_ID, timerId);
		SettingsFragment settingsFragment = new SettingsFragment();
		settingsFragment.setArguments(args);
		
		return settingsFragment;
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
	
	
	public void addItemsOnSpinner2(View view) {
		  
			spinner2 = (Spinner) view.findViewById(R.id.spinner2);
			List<String> list = new ArrayList<String>();
			list.add("White");
			list.add("Yellow");
			list.add("Cyan");
			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_item, list);
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinner2.setAdapter(dataAdapter);
		  }
	
	public void addListenerOnSpinnerItemSelection(View view) {
			spinner1 = (Spinner) view.findViewById(R.id.spinner1);
			spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
		  }
		 
	  // get the selected dropdown list value
	public void addListenerOnButton(View view) {
	 
		spinner1 = (Spinner) view.findViewById(R.id.spinner1);
		spinner2 = (Spinner) view.findViewById(R.id.spinner2);
		btnSubmit = (Button) view.findViewById(R.id.btnSubmit);
	 
		btnSubmit.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	 
				    Toast.makeText(getActivity(),
					"OnClickListener : " + 
			                "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) + 
			                "\nSpinner 2 : "+ String.valueOf(spinner2.getSelectedItem()),
						Toast.LENGTH_SHORT).show();
				    				    
		  }
	 
		});
	  }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

	    view = inflater.inflate(R.layout.fragment_settings, container, false);
	
		initListButton();
		initSettingsButton();
		initShareButton();
		initDonateButton();
		
		addItemsOnSpinner2(view);
		addListenerOnButton(view);
		addListenerOnSpinnerItemSelection(view);
		
		Log.d(TAG, "Settings onCreate entered " + id);	
		return view;
	}
}

