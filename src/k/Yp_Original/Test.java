package k.Yp_Original;

import java.util.List;
import java.util.Random;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Test extends Activity {
	public int limit;
	public int score;
	public int count;
	public int flag;
	public int pause;
	List <Question> qlist;
	int qid;
	Question currentq;
	RadioButton r1,r2,r3;
	TextView t1;
	Button next;
	DbHelper db;
	boolean hash[]=new boolean[20];
	Random r=new Random();
	public CountDownTimer time;
	public  long startTime;
	public  long interval;
	public  long blinktime;
	public TextView t2;
	public boolean blink;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		setupActionBar();
		limit=20;
		score=0;
		count=0;
		flag=1;
		pause=0;
		startTime = 20* 60 * 1000;
		interval = 500;
		blinktime= 2*60*1000;
		for(int i=0;i<hash.length;i++)
				hash[i]=false;
		
		t1=(TextView)findViewById(R.id.textView1);
		r1=(RadioButton)findViewById(R.id.radio1);
		r2=(RadioButton)findViewById(R.id.radio2);
		r3=(RadioButton)findViewById(R.id.radio3);
		next=(Button)findViewById(R.id.button1);
		db=new DbHelper(this);
		qlist=db.getAllQuestions("Capps");
		qid=r.nextInt(limit);
		hash[qid]=true;
		currentq=qlist.get(qid);
		
		t2=(TextView) findViewById(R.id.textView2);
		time = new CountDownTimer(startTime,interval){
			
		@Override
			public void onFinish() {
			t2.setText("Time Up !");
			time.cancel();
			Intent res=new Intent(Test.this,Res.class);
			Bundle b=new Bundle();
			b.putInt("score",score);
			res.putExtras(b);
			pause=1;
			startActivity(res);
				
			}

		@Override
		public void onTick(long millisUntilFinished) {
			long seconds = millisUntilFinished / 1000;

			if (millisUntilFinished < blinktime) 
			{
				t2.setTextAppearance(getApplicationContext(),R.style.blinkText);
				if(flag==1)
				{
					Toast.makeText(Test.this,"2 minutes Remaining",Toast.LENGTH_SHORT).show();
					flag=0;
				}
				if (blink) 
				{
					t2.setVisibility(View.VISIBLE);
					
				} else
				{
					t2.setVisibility(View.INVISIBLE);
				}

				blink = !blink; 
			}
			t2.setText(String.format("%02d", seconds / 60)
					+ ":" + String.format("%02d", seconds % 60));
			
		}
		}.start();
		setQuestionView();
	}
	
	public void setQuestionView()
	{
		RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
		grp.clearCheck();
		Integer i=Integer.valueOf(count+1);
		t1.setText(i.toString()+") "+currentq.getQUESTION());
		r1.setText(currentq.getOPTA());
		r2.setText(currentq.getOPTB());
		r3.setText(currentq.getOPTC());
		count++;
		
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setupActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
        getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {		
		 switch (item.getItemId()) {
	        case android.R.id.home:	    		
	    				move();
	        			return true;
	        case R.id.Cancel:
	        	move();
	        	return true;
	        	
	                     }	
		return super.onOptionsItemSelected(item);
	}

	public void move()
	{
		Intent Home=new Intent(this,SelectionActivity.class);
		Home.putExtra(MainActivity.EXTRA_MESSAGE,MainActivity.uname);
		startActivity(Home);
	}
	public void NextClicked(View v)
	{
		RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
		if((grp.getCheckedRadioButtonId())!=-1)
			{
				if(count<20)
					{
		
						RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
						if(currentq.getANSWER().trim().equals(answer.getTag().toString().trim())) 
						{
							score++;
						}
				if(count==5)
				{
					limit=10;
					qlist=db.getAllQuestions("Probability");
					for(int i=0;i<hash.length;i++)
						hash[i]=false;
		
				}
				else if(count==10)
				{
					
					qlist=db.getAllQuestions("POT");
					for(int i=0;i<hash.length;i++)
						hash[i]=false;
				}
				else if(count==15)
				{
					
					qlist=db.getAllQuestions("TAW");
					for(int i=0;i<hash.length;i++)
						hash[i]=false;
				}
				
				else if(count==19)
				{
					next.setText("Submit");		
					
				}
					do{
						qid=r.nextInt(limit);
					}while(hash[qid]);
					hash[qid]=true;
					currentq=qlist.get(qid);		
				    setQuestionView();
				 
				
			}
	else
	{
		time.cancel();
		Intent res=new Intent(this,Res.class);
		Bundle b=new Bundle();
		b.putInt("score",score);
		b.putFloat("rating",(float)score/(float)4.0);
		res.putExtras(b);
		pause=1;
		startActivity(res);
	}
   }
		else
		{
			Toast.makeText(this, "Select one Option",Toast.LENGTH_SHORT).show();
		}
	}

	public void onPause()
	{
		
		super.onPause();
		time.cancel();
		if(pause==0)
			{
			Toast.makeText(Test.this,"Test Cancelled",Toast.LENGTH_SHORT).show();
			this.finish();
			}
		else if(pause==1)
			Toast.makeText(Test.this,"Test Completed",Toast.LENGTH_SHORT).show();
		
	}	
	  @Override
	  public void onBackPressed() {
		  			move();
	  }
	 }




