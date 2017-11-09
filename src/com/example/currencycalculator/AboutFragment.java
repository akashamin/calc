package com.example.currencycalculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AboutFragment extends Fragment
{
	public View onCreateView(LayoutInflater inflator,ViewGroup container, Bundle savedInstanceState)
	{
		View rootView=inflator.inflate(R.layout.fragment_about,container,false);
		
		return rootView;
	}
}
