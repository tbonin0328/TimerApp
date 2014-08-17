package com.example.timerapp;

import java.util.ArrayList;

public class AllTimers {
	private String title;
	private ArrayList<Timer> arraylist;
	private int timer_Pic;
	
	public AllTimers(String title, ArrayList<Timer> arraylist, int timer_Pic)
	{
		this.title = title;
		this.arraylist = arraylist;
		this.timer_Pic = timer_Pic;
	}

	public int getTimer_Pic() {
		return timer_Pic;
	}

	public void setTimer_Pic(int timer_Pic) {
		this.timer_Pic = timer_Pic;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<Timer> getArraylist() {
		return arraylist;
	}

	public void setArraylist(ArrayList<Timer> arraylist) {
		this.arraylist = arraylist;
	}
	
	public String toString()
	{
		return title;
	}
	
}	
