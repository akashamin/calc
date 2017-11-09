package com.example.currencycalculator;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NavDrawerListAdapter extends ArrayAdapter<NavDrawerItem> 
{
	Context context;
	ArrayList<NavDrawerItem> navDrawerItems;
	int resource;
	ImageView imgIcon;
	TextView txtTitle;
	
	NavDrawerListAdapter(Context context,int resource,ArrayList<NavDrawerItem> navDrawerItem)
	{
		super(context,resource,navDrawerItem);
		this.context=context;
		this.navDrawerItems=navDrawerItem;
		this.resource=resource;
	}
	
	@Override
	public View getView(int position,View convertView,ViewGroup parent)
	{
		if(convertView==null)
		{
			LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView=mInflater.inflate(resource,parent,false);
		}
		

		imgIcon=(ImageView)convertView.findViewById(R.id.icon);
		txtTitle=(TextView)convertView.findViewById(R.id.title);
		imgIcon.setImageResource(navDrawerItems.get(position).getIcon());
		txtTitle.setText(navDrawerItems.get(position).getTitle());
		
		return convertView;
	}

}
