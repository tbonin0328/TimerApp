package com.example.timerapp;

import java.io.Serializable;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.CursorAdapter;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.AdapterContextMenuInfo;


public class TimerListFragment extends ListFragment implements TimerConstants
{
	private static final int REQUEST_NEW_TIMER = 0;
	private static final int REQUEST_UPDATE_TIMER = 1;
	//private TimerCursor timerCursor;
	//private TimerDatabaseHelper dbHelper;
	ArrayList<Timer> timerSet;
	
	private Callbacks callbacks; //callback needs to be startreklistactivity that holds this fragment
	
	private static final String TAG = "ListFrag";
	
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setHasOptionsMenu(true);
//		
//		dbHelper = TimerDatabaseHelper.get(getActivity());
//		timerCursor = dbHelper.queryTimers();
//		TimerCursorAdapter adapter = new TimerCursorAdapter(getActivity(), timerCursor);
//		setListAdapter(adapter);
//	}
	
	public interface Callbacks
	{
		public void onTimerSelected (int timerId);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		callbacks = (Callbacks)activity;
	}

	@Override
	public void onDetach() {
		super.onDetach();
		callbacks = null;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		timerSet = TimerSet.newInstance().getTimers();
		
		ArrayAdapter<Timer> adapter = new TimerAdapter(timerSet);
		setListAdapter(adapter);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.timer_list, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId())
		{
			case R.id.menu_item_add_timer:
				Intent intent = new Intent(getActivity(), SelectedTimerActivity.class);
				startActivityForResult(intent, REQUEST_NEW_TIMER);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
//	@Override
//	public void onListItemClick(ListView l, View v, int position, long id) {
//		super.onListItemClick(l, v, position, id);
		
//		Timer item = (Timer)getListAdapter().getItem(position);
//		
//		Serializable timer= item.getClass();
//		
//		Intent intent = new Intent(getActivity(), SelectedTimerPagerActivity.class);
//		Bundle args = new Bundle();
//		args.putSerializable(EXTRA_POSITION_ID, timer);
//		intent.putExtra(TIMER_ID, position);
//		intent.putExtras(args);
//		startActivity(intent);
		
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		callbacks.onTimerSelected(position);
		
	}


	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		getActivity().getMenuInflater().inflate(R.menu.timer_list_context, menu);
	}
	
	private class TimerAdapter extends ArrayAdapter<Timer>
	{
		public TimerAdapter(ArrayList<Timer> timerSet) {
			super(getActivity(), 0, timerSet);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if(convertView == null);
			{
				convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_list, null);
			}
			
			Timer timer = getItem(position);
			
			TextView titleView = (TextView)convertView.findViewById(R.id.timer_list_item_title_textview);
			titleView.setText(timer.getTitle());
			
			TextView descView = (TextView)convertView.findViewById(R.id.timer_list_item_desc_textview);
			descView.setText(timer.getTitle());
			
			ImageView smallImage = (ImageView)convertView.findViewById(R.id.list_view_imageView);
			smallImage.setImageResource(timer.getTimer_pic()); 
			
			return convertView;
		}
		
	}

	
	
	
}
