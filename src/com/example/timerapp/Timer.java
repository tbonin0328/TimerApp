package com.example.timerapp;

import java.sql.Time;
import java.util.Date;

public class Timer {

	private long id;
	private String title = "";
	private String description = "";
	private String message = "";
	private String abs_start_time = "";
	private String abs_time_app_ended = "";
	private long countdown_amt = 0;
	private String URL = "";
	private int type = 0;
	private int status = 0;
	private int timer_pic = 0;
	
	public Timer(String title, String description, String message, String abs_start_time, String abs_time_app_ended, long countdown_amt, 
			String URL, int type, int status, int timer_pic) //boolean type, boolean status)
	{
		id=-1;
		this.title = title;
		this.description = description;
		this.message = message;
		this.abs_start_time = abs_start_time;
		this.abs_time_app_ended = abs_time_app_ended;
		this.countdown_amt = countdown_amt;
		this.URL = URL;
		this.type = type;
		this.status = status;
		this.timer_pic = timer_pic;
	}
	
	//store absolute start time
	//store absolute time app ended
	//decrement amount (20 minutes) no decrement is -1 if timer is going up till you stop it (better to use 0)
	
	//use "int" not "Integer" (only this one can be null)
	
	//get a piece of paper and show different pages and how they connect.

	public long getCountdown_amt() {
		return countdown_amt;
	}

	public void setCountdown_amt(long countdown_amt) {
		this.countdown_amt = countdown_amt;
	}

	public int getTimer_pic() {
		return timer_pic;
	}

	public void setTimer_pic(int timer_pic) {
		this.timer_pic = timer_pic;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getAbs_start_time() {
		return abs_start_time;
	}

	public void setAbs_start_time(String abs_start_time) {
		this.abs_start_time = abs_start_time;
	}

	public String getAbs_time_app_ended() {
		return abs_time_app_ended;
	}

	public void setAbs_time_app_ended(String abs_time_app_ended) {
		this.abs_time_app_ended = abs_time_app_ended;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
//App stores start date and time for timer.
//App stores description for timer.
//App store social media URL for timer.
//App gets social media URL for timer.