package k.Yp_Original;


import android.os.Bundle;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
	public final static String EXTRA_MESSAGE = "com.example.preparation.START";
	static String uname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.activity_main);  
       Button b1=(Button)findViewById(R.id.button1);
        Typeface font = Typeface.createFromAsset(this.getAssets(), "HappyFox.otf");
        b1.setTypeface(font);
               
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
       
            case R.id.action_settings:
            	Toast.makeText(this,"Placement Preparation App\nDevelopers: Zaman Asrar and Ramnath MV\nZamanInc. All Rights Reserved.", Toast.LENGTH_LONG).show();
            	return true;
           
        }
        return true;
        }
    
    public void ButtonClick(View v)
    {
    	EditText val=(EditText) findViewById(R.id.editText1);
    	uname=val.getText().toString();
    	if(uname.equals(""))
    	{
    		Toast.makeText(this,"Please Enter Your Name ",Toast.LENGTH_SHORT).show();
    	}
    	else
    	{
    		
    		Intent intent1 = new Intent(this, SelectionActivity.class);
    		intent1.putExtra(EXTRA_MESSAGE,uname);
    		startActivity(intent1);
    	}
    	
    }
    
    
}
