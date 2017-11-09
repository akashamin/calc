package com.example.currencycalculator;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper 
{
	static String dbname="history";


	public DatabaseHandler(Context context) 
	{
		super(context, dbname, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		String createtable="create table historytab(exp text,ans text)";
		db.execSQL(createtable);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


	}


	public void addHistory(History history)
	{
		SQLiteDatabase db=this.getWritableDatabase();

		ContentValues values=new ContentValues();
		values.put("exp", history.getexp());
		values.put("ans", history.getans());
		db.insert("historytab", null, values);
		db.close();
	}

	public List<History> getHistory()
	{
		List<History> historylist=new ArrayList<History>();

		String selectQuery="select * from historytab";
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor cursor=db.rawQuery(selectQuery, null);

		if(cursor.moveToFirst())
		{
			do
			{
				History history=new History();
				history.setexp(cursor.getString(0));
				history.setans(cursor.getString(1));
				historylist.add(history);
			}
			while(cursor.moveToNext());
		}
		db.close();
		
		return historylist;
	}
	
	public void clearHistory()
	{
		SQLiteDatabase db=this.getWritableDatabase();
		db.execSQL("delete from historytab");
		db.close();
	}


}
