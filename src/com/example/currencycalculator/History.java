package com.example.currencycalculator;

public class History 
{
	String _exp;
	String _ans;
	
	public History()
	{
		
	}
	
	public History(String exp, String ans)
	{
		this._exp=exp;
		this._ans=ans;
	}
	
	public String getexp()
	{
		return this._exp;
	}
	
	public String getans()
	{
		return this._ans;
	}
	
	public void setexp(String exp)
	{
		this._exp=exp;
	}
	
	public void setans(String ans)
	{
		this._ans=ans;
	}

}
