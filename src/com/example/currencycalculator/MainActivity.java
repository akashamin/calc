package com.example.currencycalculator;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

@SuppressLint("NewApi")
public class MainActivity extends ActionBarActivity implements
NavigationDrawerFragment.NavigationDrawerCallbacks {
	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;
	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
	}


	public void onSectionAttached(int number) 
	{
		String[]titles=getResources().getStringArray(R.array.nav_drawer_items);
		switch (number) {
		case 1:
			mTitle = titles[0];
			break;
		/*case 2:
			mTitle = titles[1];
			break;*/
		case 2:
			mTitle = titles[1];
			break;
		case 3:
			mTitle = titles[2];
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}



	/**
	 * A placeholder fragment containing a simple view.
	 */

	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";

	@SuppressLint("NewApi")
	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// TODO Auto-generated method stub
		Fragment fragment=null;
		String[]titles=getResources().getStringArray(R.array.nav_drawer_items);

		switch(position)
		{
		case 0:
			fragment=new CalulatorFragment();
			break;

	/*	case 1:
			fragment=new CurrencyFragment();
			break;*/

		case 1:
			fragment=new ThemeFragment();
			break;

		case 2:
			fragment=new AboutFragment();
		}

		if(fragment!=null)
		{
			FragmentTransaction fm1=getSupportFragmentManager().beginTransaction();
			fm1.setCustomAnimations(R.animator.enter, R.animator.exit);
			fm1.replace(R.id.container, fragment).addToBackStack(null).commit();
			ActionBar actionBar = getSupportActionBar();
			actionBar.setTitle(titles[position]);
		}
		else
		{
			Log.e("MAin ACtivity", "Error creating fragment");
		}

	}

	
	boolean doubleBackToExitPressedOnce=false;
	@Override
	public void onBackPressed() {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		alertDialogBuilder.setTitle("Exit Application");
		alertDialogBuilder.setMessage("Are you sure ?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int id)
			{
				moveTaskToBack(true);
				android.os.Process.killProcess(android.os.Process.myPid());
				System.exit(1);
			}
		})

		.setNegativeButton("No", new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int id)
			{

				dialog.cancel();
			}
		});

		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
	
	}
}
