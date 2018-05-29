package k.Yp_Original;

import k.Yp_Original.R;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;

public class SelectionActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        setupActionBar();
        TextView t1=(TextView) findViewById(R.id.editText1);
        Typeface font = Typeface.createFromAsset(this.getAssets(), "HappyFox.otf");
        t1.setTypeface(font);
        Button b21,b22,b23,b24,b25;
        b21=(Button)findViewById(R.id.button21);
        b22=(Button)findViewById(R.id.button22);
        b23=(Button)findViewById(R.id.button23);
        b24=(Button)findViewById(R.id.button24);
        b25=(Button)findViewById(R.id.button25);
        b21.setTypeface(font);
        b22.setTypeface(font);
        b23.setTypeface(font);
        b24.setTypeface(font);
        b25.setTypeface(font);
        
        Bundle b=getIntent().getExtras();      
		String uname=b.getString(MainActivity.EXTRA_MESSAGE);
		t1.setText("Welcome  " + uname +" !");
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
        getMenuInflater().inflate(R.menu.selection, menu);
        return true;
    }
    

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.action_settings:
            	Toast.makeText(this,"Placement Preparation App\nDevelopers: Zaman Asrar and Ramnath MV\nZamanInc. All Rights Reserved.", Toast.LENGTH_LONG).show();
            	return true;
           
           
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void clickedCApps(View v)
    {
    	Intent i2=new Intent(this,QDisp.class);
    	Bundle b=new Bundle();
    	b.putString("DataBaseName","Capps");
    	i2.putExtras(b);
    	
    	startActivity(i2);
    	
    	
    }
    public void clickedProbabilty(View v)
    {
    	Intent i2=new Intent(this,QDisp.class);
    	Bundle b=new Bundle();
    	b.putString("DataBaseName","Probability");
    	i2.putExtras(b);
    	startActivity(i2);
    	
    }
    public void clickedProblemsOnTrain(View v)
    {
    	Intent i2=new Intent(this,QDisp.class);
    	Bundle b=new Bundle();
    	b.putString("DataBaseName","POT");
    	i2.putExtras(b);
    	startActivity(i2);
    }
    
    public void clickedTimeandWork(View v)
    {
    	Intent i2=new Intent(this,QDisp.class);
    	Bundle b=new Bundle();
    	b.putString("DataBaseName","TAW");
    	i2.putExtras(b);
    	startActivity(i2);
    }
    
    public void Test(View v)
    {
    	Intent i2=new Intent(this,Test.class);
    	startActivity(i2);
    }

	   public void onBackPressed() {
		  Intent i=new Intent(this,MainActivity.class);
		  i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		  startActivity(i);
	   }

}
