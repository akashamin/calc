package com.example.currencycalculator;

import java.util.Stack;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class CalulatorFragment extends Fragment implements OnClickListener
{
	EditText et,etans;
	Button btn[] = new Button[16], clear, delete,history;
	int bid[] = { R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
			R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
			R.id.btnplus, R.id.btnminus, R.id.btnmul, R.id.btndiv,
			R.id.btnequal, R.id.btnpoint };
	AlertDialog.Builder alert;
	int i;
	int flag= 1, flag1 = 0,flagmin=0;
	int pos;
	int point;
	double aa,bb,cc;
	String aaa,bbb,aa1;
	Stack<Character> opstack=new Stack<Character>(); 
	Stack<String> vstack=new Stack<String>();
	char pl,mu,mi,di;
	InputMethodManager im1,im2;


	@SuppressLint("NewApi")
	public View onCreateView(LayoutInflater inflator,ViewGroup container, Bundle savedInstanceState)
	{

		SharedPreferences shared=getActivity().getSharedPreferences("theme",Context.MODE_PRIVATE);
		String themestyle=shared.getString("themecolor", "grey");
		View rootView=null;

		if(themestyle.equals("grey"))
		{
			rootView=inflator.inflate(R.layout.fragment_calculator,container,false);
		}

		else if(themestyle.equals("orange"))
		{
			rootView=inflator.inflate(R.layout.fragment_calculator_orange,container,false);	
		}
		
		else if(themestyle.equals("blue"))
		{
			rootView=inflator.inflate(R.layout.fragment_calculator_blue,container,false);
		}
		else if(themestyle.equals("green"))
		{
			rootView=inflator.inflate(R.layout.fragment_calculator_green,container,false);
		}
		else if(themestyle.equals("maroon"))
		{
			rootView=inflator.inflate(R.layout.fragment_calculator_maroon,container,false);
		}
		else if(themestyle.equals("pink"))
		{
			rootView=inflator.inflate(R.layout.fragment_calculator_pink,container,false);
		}
		else if(themestyle.equals("white"))
		{
			rootView=inflator.inflate(R.layout.fragment_calculator_white,container,false);
		}

		pl=getResources().getString(R.string.plus).charAt(0);
		mu=getResources().getString(R.string.mul).charAt(0);
		mi=getResources().getString(R.string.minus).charAt(0);
		di=getResources().getString(R.string.div).charAt(0);

		alert = new AlertDialog.Builder(rootView.getContext());

		et = (EditText) rootView.findViewById(R.id.etCalculator);
		etans=(EditText)rootView.findViewById(R.id.etAns);
		
		/*history=(Button)rootView.findViewById(R.id.history);
		
		history.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Fragment fragment=null;
				fragment=new HistoryFragment();
				FragmentTransaction fm1=getActivity().getSupportFragmentManager().beginTransaction();
				fm1.setCustomAnimations(R.animator.enter,R.animator.exit);
				fm1.replace(R.id.container, fragment).commit();
				
			}
		});*/

		et.setInputType(InputType.TYPE_NULL);
		etans.setInputType(InputType.TYPE_NULL);		

		et.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				im1=(InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
				im1.hideSoftInputFromWindow(et.getWindowToken(),0);
			}
		});
		etans.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				im2=(InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
				im2.hideSoftInputFromWindow(etans.getWindowToken(),0);
			}
		});

		for (i = 0; i < bid.length; i++) 
		{
			btn[i] = (Button) rootView.findViewById(bid[i]);
			btn[i].setOnClickListener(this);
		}

		clear = (Button) rootView.findViewById(R.id.btnClr);
		delete = (Button) rootView.findViewById(R.id.btnDel);
		delete.setVisibility(View.VISIBLE);
		clear.setVisibility(View.INVISIBLE);

		delete.setOnClickListener(new OnClickListener() 
		{

			@Override
			public void onClick(View v) 
			{

				String ss = et.getText().toString();

				if (ss.length() > 0) 
				{
					char ch = ss.charAt(ss.length() - 1);
					if (ch == '.') 
					{
						flag1 = 0;
					}
					else if(ch==mu || ch==di || ch==pl || ch==mi)
					{
						flag=0;
						flagmin=0;
					}
					ss = ss.substring(0, ss.length() - 1);
					if(ss.length()==0)
					{
						flag=1;
					}
					et.setText(ss);
				}
				else
				{
					flag=1;
					flagmin=0;
					flag1 = 0;
				}
			}
		});

		delete.setOnLongClickListener(new OnLongClickListener() 
		{

			@Override
			public boolean onLongClick(View v) 
			{
				flag=0;
				flagmin=0;
				flag1 = 0;
				et.setText("");
				return false;

			}
		});
		clear.setOnClickListener(new OnClickListener() 
		{

			@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
			@Override
			public void onClick(View v) 
			{
				et.setText("");
				etans.setText("");
				delete.setAlpha(0f);
				delete.setVisibility(View.VISIBLE);
				delete.animate().alpha(1f).setDuration(1000);
				clear.setVisibility(View.INVISIBLE);
				opstack.clear();
				vstack.clear();
				flag=1;
			}
		});





		return rootView;
	}


	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {

		Button b = (Button) v;

		if (b == btn[0] || b == btn[1] || b == btn[2] || b == btn[3]
				|| b == btn[4] || b == btn[5] || b == btn[6] || b == btn[7]
						|| b == btn[8] || b == btn[9]) 
		{
			if(et.getText().toString().contains("WRONG FORMAT"))
			{
				et.setText("");
			}
			if(etans.getText().toString().contains("="))
			{
				et.setText("");
				etans.setText("");
				delete.setAlpha(0f);
				delete.setVisibility(View.VISIBLE);
				delete.animate().alpha(1f).setDuration(1000);
				clear.setVisibility(View.INVISIBLE);
			}

			et.setText(et.getText() + b.getText().toString());
			et.setSelection(et.getText().length());
			flag = 0;
			flagmin=0;
		}

		else if (b == btn[10] && flag == 0) 
		{
			String sss=etans.getText().toString();
			if(sss.contains("="))
			{
				int start=sss.indexOf("=");
				sss=sss.substring(start+1,sss.length());
				et.setText(sss);

				delete.setAlpha(0f);
				delete.setVisibility(View.VISIBLE);
				delete.animate().alpha(1f).setDuration(1000);
				clear.setVisibility(View.INVISIBLE);					
			}
			flag = 1;
			flag1 = 0;
			et.setText(et.getText() + b.getText().toString());
			et.setSelection(et.getText().length());
			etans.setText("");
		}

		else if (b == btn[11] && flagmin == 0) 
		{
			String sss=etans.getText().toString();
			if(sss.contains("="))
			{
				int start=sss.indexOf("=");
				sss=sss.substring(start+1,sss.length());
				et.setText(sss);
				delete.setAlpha(0f);
				delete.setVisibility(View.VISIBLE);
				delete.animate().alpha(1f).setDuration(1000);
				clear.setVisibility(View.INVISIBLE);
				etans.setText("");
			}

			flagmin = 1;
			flag=1;
			et.setText(et.getText() + b.getText().toString());
			et.setSelection(et.getText().length());
			flag1 = 0;
		}

		else if (b == btn[12] && flag == 0) 
		{
			String sss=etans.getText().toString();
			if(sss.contains("="))
			{
				int start=sss.indexOf("=");
				sss=sss.substring(start+1,sss.length());
				et.setText(sss);
				delete.setAlpha(0f);
				delete.setVisibility(View.VISIBLE);
				delete.animate().alpha(1f).setDuration(1000);
				clear.setVisibility(View.INVISIBLE);
				etans.setText("");
			}
			flag = 1;
			flag1 = 0;
			et.setText(et.getText() + b.getText().toString());
			et.setSelection(et.getText().length());
		}

		else if (b == btn[13] && flag == 0) 
		{
			String sss=etans.getText().toString();
			if(sss.contains("="))
			{
				int start=sss.indexOf("=");
				sss=sss.substring(start+1,sss.length());
				et.setText(sss);
				delete.setAlpha(0f);
				delete.setVisibility(View.VISIBLE);
				delete.animate().alpha(1f).setDuration(1000);
				clear.setVisibility(View.INVISIBLE);
				etans.setText("");
			}
			flag = 1;
			et.setText(et.getText() + b.getText().toString());
			et.setSelection(et.getText().length());
			flag1 = 0;
		}

		else if (b == btn[15]) 
		{
			if (flag1 == 0) 
			{
				et.setText(et.getText() + b.getText().toString());
				et.setSelection(et.getText().length());
				flag1 = 1;
			}
		}

		else if (b == btn[14])			
		{
			String s = et.getText().toString();

			if(!s.contains(""+pl)  && !s.contains(""+mi)  && !s.contains(""+mu)  && !s.contains(""+di) || s.contains("="))
			{
				et.setText(s);
			}

			else if(s.endsWith(""+pl) || s.endsWith(""+mi) || s.endsWith(""+mu) || s.endsWith(""+di) || s.startsWith(""+pl) ||  s.startsWith("*") || s.startsWith(""+di))
			{
				et.setText("WRONG FORMAT");
				flag=1;
				clear.setAlpha(0f);
				delete.setVisibility(View.INVISIBLE);
				clear.setVisibility(View.VISIBLE);
				clear.animate().alpha(1f).setDuration(1000);
			}
			else
			{
				String st[] = new String[50];
				char operator[] = new char[50];
				if (s.length() > 0) {
					int pos[] = new int[50];
					int j = 0;
					int n = 0;
					int m = 0;
					char data[]= s.toCharArray();


					if(!s.startsWith(""+mi))
					{

						for (i = 0; i < s.length(); i++) 
						{
							if (data[i] == pl || data[i] == mu || data[i] == di || data[i] == mi) 
							{

								pos[j] = i;
								operator[m] = data[i];
								j++;
								n++;
								m++;
								if(data[i+1]==mi)
								{
									i++;
								}
							}
						}

					}
					else
					{
						for (i = 1; i < s.length(); i++) 
						{
							if (data[i] == pl || data[i] == mu || data[i] == di || data[i] == mi) 
							{
								pos[j] = i;
								operator[m] = data[i];
								j++;
								n++;
								m++;
								if(data[i+1]==mi)
								{
									i++;
								}
							}
						}
					}

					st[0] =s.substring(0, pos[0]);
					j = 1;
					for (i = 0; i < n; i++) 
					{
						if (i < n - 1) 
						{
							st[j] = s.substring(pos[i] + 1, pos[i + 1]);
							j++;
						}
						st[j] = s.substring(pos[i] + 1, s.length());
					}

					vstack.push(st[0]);

					opstack.push(operator[0]);

					vstack.push(st[1]);
					j = 2;
					for (i = 1; i < n+1; i++) 
					{


						if((opstack.peek()==pl || opstack.peek()==mi) && (operator[i]==mu || operator[i]==di))
						{

							opstack.push(operator[i]);
							vstack.push(st[j]);
							j++;
						}


						else if((opstack.peek()==mu || opstack.peek()==di) && (operator[i]==pl || operator[i]==mi))
						{
							char op=opstack.pop();
							aaa=vstack.pop();
							bbb=vstack.pop();

							{
								{
									if(aaa.startsWith(""+mi))
									{
										aaa=aaa.substring(1, aaa.length());
										aa=-Double.parseDouble(aaa);
									}
									else
									{
										aa=Double.parseDouble(aaa);
									}	
								}

								{
									if(bbb.startsWith(""+mi))
									{
										bbb=bbb.substring(1, bbb.length());
										bb=-Double.parseDouble(bbb);
									}
									else
									{
										bb=Double.parseDouble(bbb);
									}
								}
							}
							{
								if(op==mu)
								{
									cc=aa*bb;
									vstack.push(""+cc);
								}
								else if(op==di)
								{
									cc=bb/aa;
									vstack.push(""+cc);
								}
							}

							if(!opstack.isEmpty())
							{
								if(opstack.peek()==mi && operator[i]==pl)
								{
									op=opstack.pop();
									aaa=vstack.pop();
									bbb=vstack.pop();

									{
										{
											if(aaa.startsWith(""+mi))
											{
												aaa=aaa.substring(1, aaa.length());
												aa=-Double.parseDouble(aaa);
											}
											else
											{
												aa=Double.parseDouble(aaa);
											}	
										}

										{
											if(bbb.startsWith(""+mi))
											{
												bbb=bbb.substring(1, bbb.length());
												bb=-Double.parseDouble(bbb);
											}
											else
											{
												bb=Double.parseDouble(bbb);
											}
										}
									}
									if(!opstack.isEmpty())
									{
										if(opstack.peek()==mi)
										{
											cc=bb+aa;
										}
										else
										{
											cc=bb-aa;
										}
									}
									else
									{
										cc=bb-aa;
									}
									vstack.push(""+cc);
								}
							}
							opstack.push(operator[i]);
							vstack.push(st[j]);
							j++;
						}


						else if((opstack.peek()==mi || opstack.peek()==pl) &&  (operator[i]==pl || operator[i]==mi))
						{
							char op=opstack.pop();
							aaa=vstack.pop();
							bbb=vstack.pop();

							{
								{
									if(aaa.startsWith(""+mi))
									{
										aaa=aaa.substring(1, aaa.length());
										aa=-Double.parseDouble(aaa);
									}
									else
									{
										aa=Double.parseDouble(aaa);
									}	
								}

								{
									if(bbb.startsWith(""+mi))
									{
										bbb=bbb.substring(1, bbb.length());
										bb=-Double.parseDouble(bbb);
									}
									else
									{
										bb=Double.parseDouble(bbb);
									}
								}
							}

							if(op==pl)
							{
								if(!opstack.isEmpty())
								{
									if(opstack.peek()==mi)
									{
										cc=bb-aa;
									}
									else
									{
										cc=aa+bb;
									}
								}
								else
								{
									cc=aa+bb;
								}	vstack.push(""+cc);
							}
							else if(op==mi)
							{
								if(!opstack.isEmpty())
								{
									if(opstack.peek()==mi)
									{
										cc=bb+aa;
									}
									else
									{
										cc=bb-aa;
									}
								}
								else
								{
									cc=bb-aa;
								}
								vstack.push(""+cc);								
							}

							opstack.push(operator[i]);
							vstack.push(st[j]);
							j++;
						}



						else if((opstack.peek()==mu || opstack.peek()==di) && (operator[i]==mu || operator[i]==di))
						{
							char op=opstack.pop();
							aaa=vstack.pop();
							bbb=vstack.pop();
							{
								{
									if(aaa.startsWith(""+mi))
									{
										aaa=aaa.substring(1, aaa.length());
										aa=-Double.parseDouble(aaa);
									}
									else
									{
										aa=Double.parseDouble(aaa);
									}	
								}

								{
									if(bbb.startsWith(""+mi))
									{
										bbb=bbb.substring(1, bbb.length());
										bb=-Double.parseDouble(bbb);
									}
									else
									{
										bb=Double.parseDouble(bbb);
									}
								}
							}
							if(op==mu)
							{
								cc=aa*bb;
								vstack.push(""+cc);
							}
							else if(op==di)
							{
								cc=bb/aa;
								vstack.push(""+cc);
							}

							opstack.push(operator[i]);
							vstack.push(st[j]);
							j++;
						}
					}

					while(!opstack.isEmpty())
					{

						char op=opstack.pop();
						aaa=vstack.pop();
						bbb=vstack.pop();

						{
							{
								if(aaa.startsWith(""+mi))
								{
									aaa=aaa.substring(1, aaa.length());
									aa=-Double.parseDouble(aaa);
								}
								else
								{
									aa=Double.parseDouble(aaa);
								}	
							}

							{
								if(bbb.startsWith(""+mi))
								{
									bbb=bbb.substring(1, bbb.length());
									bb=-Double.parseDouble(bbb);
								}
								else
								{
									bb=Double.parseDouble(bbb);
								}
							}
						}

						if(op==pl)
						{
							if(!opstack.isEmpty())
							{
								if(opstack.peek()==mi)
								{
									cc=bb-aa;
								}
								else
								{
									cc=aa+bb;
								}
							}
							else
							{
								cc=aa+bb;
							}
							vstack.push(""+cc);
						}

						else if(op==mi)
						{
							if(!opstack.isEmpty())
							{
								if(opstack.peek()==mi)
								{
									cc=bb+aa;
								}
								else
								{
									cc=bb-aa;
								}
							}
							else
							{
								cc=bb-aa;
							}
							vstack.push(""+cc);
						}

						else if(op==mu)
						{
							cc=aa*bb;
							vstack.push(""+cc);
						}

						else if(op==di)
						{
							cc=bb/aa;
							vstack.push(""+cc);
						}
					}

					String ccc;
					ccc=vstack.pop();

					char pdata[]=ccc.toCharArray();
					int point=ccc.indexOf(".");
					int nn=0;

					String pc=ccc.substring(point+1,ccc.length());

					for(i=point+1;i<ccc.length();i++)
					{
						if(pdata[i]=='0')
						{
							nn++;
						}
					}

					if(nn==pc.length())
					{
						ccc=ccc.substring(0,point);
					}

					cc=Double.parseDouble(ccc);
//					String cd=BigDecimal.valueOf(cc).toPlainString();
					//if(cd.length()<=14)
					//{
	//etans.setText("="+cd);
					//}
					//else
					//{
						etans.setText("="+ccc);
					//}
					
						
					clear.setAlpha(0f);
					delete.setVisibility(View.INVISIBLE);
					clear.setVisibility(View.VISIBLE);
					clear.animate().alpha(1f).setDuration(1000);
				}
			}
		}
	}
}
