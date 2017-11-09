package com.example.currencycalculator;

public class NavDrawerItem {
	
	String title;
	int icon;
	
	public NavDrawerItem(String title,int icon) {
		
		this.title=title;
		this.icon=icon;
	}
	
	public  int getIcon() 
	{
		return this.icon;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public void setIcon(int icon)
	{
		this.icon=icon;
	}
	public void setTitle(String title)
	{
		this.title=title;
	}

}
