package com.example.currencycalculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class ThemeFragment extends Fragment
{
	ImageButton ib1,ib2,ib3,ib4,ib5,ib6,ib7;

	public View onCreateView(LayoutInflater inflator,ViewGroup container, Bundle savedInstanceState)
	{
		View rootView=inflator.inflate(R.layout.fragment_theme,container,false);
		View calView=inflator.inflate(R.layout.fragment_calculator,container,false);

		ib1=(ImageButton)rootView.findViewById(R.id.imageButton1);
		ib2=(ImageButton)rootView.findViewById(R.id.imageButton2);
		ib3=(ImageButton)rootView.findViewById(R.id.imageButton3);
		ib4=(ImageButton)rootView.findViewById(R.id.imageButton4);
		ib5=(ImageButton)rootView.findViewById(R.id.imageButton5);
		ib6=(ImageButton)rootView.findViewById(R.id.imageButton6);
		ib7=(ImageButton)rootView.findViewById(R.id.imageButton7);

		ib1.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {

				SharedPreferences shared=getActivity().getSharedPreferences("theme",Context.MODE_PRIVATE);
				SharedPreferences.Editor edit=shared.edit();
				edit.putString("themecolor","grey");
				edit.commit();
				Fragment fragment=null;
				String[]titles=getResources().getStringArray(R.array.nav_drawer_items);
				fragment=new CalulatorFragment();
				FragmentTransaction fm1=getActivity().getSupportFragmentManager().beginTransaction();
				fm1.setCustomAnimations(R.animator.enter,R.animator.exit);
				fm1.replace(R.id.container, fragment).commit();
			}
		});

		ib2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SharedPreferences shared=getActivity().getSharedPreferences("theme",Context.MODE_PRIVATE);
				SharedPreferences.Editor edit=shared.edit();
				edit.putString("themecolor","orange");
				edit.commit();
				Fragment fragment=null;
				String[]titles=getResources().getStringArray(R.array.nav_drawer_items);
				fragment=new CalulatorFragment();
				FragmentTransaction fm1=getActivity().getSupportFragmentManager().beginTransaction();
				fm1.setCustomAnimations(R.animator.enter,R.animator.exit);
				fm1.replace(R.id.container, fragment).commit();

			}
		});

		ib3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SharedPreferences shared=getActivity().getSharedPreferences("theme",Context.MODE_PRIVATE);
				SharedPreferences.Editor edit=shared.edit();
				edit.putString("themecolor","blue");
				edit.commit();
				Fragment fragment=null;
				String[]titles=getResources().getStringArray(R.array.nav_drawer_items);
				fragment=new CalulatorFragment();
				FragmentTransaction fm1=getActivity().getSupportFragmentManager().beginTransaction();
				fm1.setCustomAnimations(R.animator.enter,R.animator.exit);
				fm1.replace(R.id.container, fragment).commit();

			}
		});
		ib4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SharedPreferences shared=getActivity().getSharedPreferences("theme",Context.MODE_PRIVATE);
				SharedPreferences.Editor edit=shared.edit();
				edit.putString("themecolor","maroon");
				edit.commit();
				Fragment fragment=null;
				String[]titles=getResources().getStringArray(R.array.nav_drawer_items);
				fragment=new CalulatorFragment();
				FragmentTransaction fm1=getActivity().getSupportFragmentManager().beginTransaction();
				fm1.setCustomAnimations(R.animator.enter,R.animator.exit);
				fm1.replace(R.id.container, fragment).commit();

			}
		});

		ib5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SharedPreferences shared=getActivity().getSharedPreferences("theme",Context.MODE_PRIVATE);
				SharedPreferences.Editor edit=shared.edit();
				edit.putString("themecolor","green");
				edit.commit();
				Fragment fragment=null;
				String[]titles=getResources().getStringArray(R.array.nav_drawer_items);
				fragment=new CalulatorFragment();
				FragmentTransaction fm1=getActivity().getSupportFragmentManager().beginTransaction();
				fm1.setCustomAnimations(R.animator.enter,R.animator.exit);
				fm1.replace(R.id.container, fragment).commit();

			}
		});

		ib6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SharedPreferences shared=getActivity().getSharedPreferences("theme",Context.MODE_PRIVATE);
				SharedPreferences.Editor edit=shared.edit();
				edit.putString("themecolor","pink");
				edit.commit();
				Fragment fragment=null;
				String[]titles=getResources().getStringArray(R.array.nav_drawer_items);
				fragment=new CalulatorFragment();
				FragmentTransaction fm1=getActivity().getSupportFragmentManager().beginTransaction();
				fm1.setCustomAnimations(R.animator.enter,R.animator.exit);
				fm1.replace(R.id.container, fragment).commit();

			}
		});

		ib7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SharedPreferences shared=getActivity().getSharedPreferences("theme",Context.MODE_PRIVATE);
				SharedPreferences.Editor edit=shared.edit();
				edit.putString("themecolor","white");
				edit.commit();
				Fragment fragment=null;
				String[]titles=getResources().getStringArray(R.array.nav_drawer_items);
				fragment=new CalulatorFragment();
				FragmentTransaction fm1=getActivity().getSupportFragmentManager().beginTransaction();
				fm1.setCustomAnimations(R.animator.enter,R.animator.exit);
				fm1.replace(R.id.container, fragment).commit();
				
				

			}
		});

		return rootView;
	}
	
	
	/*public void onKeyDown(int keyCode, KeyEvent event) {

		if(keyCode==KeyEvent.KEYCODE_BACK)
		{
			Fragment fragment=null;
			fragment=new CalulatorFragment();
			FragmentTransaction fm1=getActivity().getSupportFragmentManager().beginTransaction();
			fm1.setCustomAnimations(R.animator.enter,R.animator.exit);
			fm1.replace(R.id.container, fragment).commit();
		}
	}
	*/

}
