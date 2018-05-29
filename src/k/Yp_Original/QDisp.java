package k.Yp_Original;

import java.util.List;

import k.Yp_Original.R;
import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QDisp extends Activity {
	public int score;
	List <Question> qlist;
	int qid;
	int limit;
	Question currentq;
	RadioButton r1,r2,r3;
	TextView t1;
	Button next,sol;
	String tname;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle b=getIntent().getExtras();
		tname=b.getString("DataBaseName");
		 qid=0;
		 score=0;
		
		if(tname.equals("Capps")) setTitle("Capps");
			
		else if(tname.equals("Probability")) setTitle("Probability");
			
		else if(tname.equals("TAW")) setTitle("Time And Work");
			
		else setTitle("Problems On Train");
			
		
		setContentView(R.layout.activity_qdisp);
		setupActionBar();

		limit=(tname.equals("Capps"))? 20:10;
		
		DbHelper db=new DbHelper(this);
		qlist=db.getAllQuestions(tname);
		currentq=qlist.get(qid);
		
		t1=(TextView)findViewById(R.id.textView1);
		r1=(RadioButton)findViewById(R.id.radio1);
		r2=(RadioButton)findViewById(R.id.radio2);
		r3=(RadioButton)findViewById(R.id.radio3);
		next=(Button)findViewById(R.id.button1);
		
		
		setQuestionView();
			
	}
	
	public void setQuestionView()
	{
		RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
		grp.clearCheck();
		Integer i=Integer.valueOf(qid+1);
		t1.setText(i.toString()+") "+currentq.getQUESTION());
		r1.setText(currentq.getOPTA());
		r2.setText(currentq.getOPTB());
		r3.setText(currentq.getOPTC());
		qid++;
		
		
	}
	   @TargetApi(Build.VERSION_CODES.HONEYCOMB)
	    private void setupActionBar() {
	        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
	        
	        getActionBar().setDisplayHomeAsUpEnabled(true);
	        }
	    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.capps, menu);
		return true;
	}
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
        			Intent i1=new Intent(this,SelectionActivity.class);        			
        			i1.putExtra(MainActivity.EXTRA_MESSAGE,MainActivity.uname);
        			startActivity(i1);
        			return true;
        case R.id.about:
        	Toast.makeText(this,"Placement Preparation App\nDevelopers: Zaman Asrar and Ramnath MV\nZamanInc. All Rights Reserved.", Toast.LENGTH_LONG).show();
        	return true;
        	
                     }
        return super.onOptionsItemSelected(item);
    }
	
	
	
	public void NextClicked(View v)
	{
		
		RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
		if((grp.getCheckedRadioButtonId())!=-1)
		{
		RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
		Log.d("yourans", currentq.getANSWER()+" "+answer.getTag());
		if(currentq.getANSWER().trim().equals(answer.getTag().toString().trim())) 
		{
			
			score++;
			Log.d("score", "Your score"+score);
		}

		if(qid<limit)
		{
			currentq=qlist.get(qid);
			setQuestionView();
		}
		
		else
		{
			Intent res=new Intent(this,Res.class);
			Bundle b=new Bundle();
			b.putInt("score",score);
			b.putFloat("rating",(tname.equals("Capps"))? ((float)score/(float)4.0):((float)score/(float)2.0));
			res.putExtras(b);
			startActivity(res);
					  
		}
		}
		else
		{
			Toast.makeText(this, "Select one Option",Toast.LENGTH_SHORT).show();
		}
		
		
	}
	public void sol(View v)
	{
		String disp=currentq.getSOL();
		Toast.makeText(QDisp.this,disp,Toast.LENGTH_LONG).show();
			
	}
	
	  @Override
	   public void onBackPressed() {
			Intent i1=new Intent(this,SelectionActivity.class);        			
			i1.putExtra(MainActivity.EXTRA_MESSAGE,MainActivity.uname);
			startActivity(i1);
	   }
	
	}


