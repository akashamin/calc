package com.example.currencycalculator;


import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class HistoryFragment extends Fragment 
{
	ListView listview;
	Button clear;
	DatabaseHandler handler;
	public View onCreateView(LayoutInflater inflator,ViewGroup container, Bundle savedInstanceState)
	{
		View rootView=inflator.inflate(R.layout.fragment_history,container,false);
		listview=(ListView)rootView.findViewById(R.id.listView1);
		clear=(Button)rootView.findViewById(R.id.clearhistory);
		
		handler=new DatabaseHandler(getActivity());
		
		List<History> history=handler.getHistory();
		
		ArrayAdapter<History> adapter=new ArrayAdapter<History>(getActivity(), android.R.layout.simple_list_item_1, history);
		listview.setAdapter(adapter);
		
		
		clear.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				handler.clearHistory();
				
			}
		});
		
		return rootView;
	}

}
