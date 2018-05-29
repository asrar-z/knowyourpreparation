package k.Yp_Original;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;


public class Res extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_res);
		RatingBar rb=(RatingBar) findViewById(R.id.ratingBar1);
		TextView t1=(TextView) findViewById(R.id.textView1);
		
		Bundle b=getIntent().getExtras();
		int score=b.getInt("score");
		Integer i=Integer.valueOf(score);
		t1.append(i.toString());
		rb.setRating(b.getFloat("rating"));


		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.res, menu);
		return true;
	}
public void HomeClicked(View v)
{
	Intent Home=new Intent(Res.this,SelectionActivity.class);
	Home.putExtra(MainActivity.EXTRA_MESSAGE,MainActivity.uname);
	startActivity(Home);
	
}

@Override
public void onBackPressed() {
	Intent i1=new Intent(this,SelectionActivity.class);        			
	i1.putExtra(MainActivity.EXTRA_MESSAGE,MainActivity.uname);
	startActivity(i1);
}
}
