package ro.pub.cs.systems.pdsd.lab03.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class PhoneDialerActivity extends Activity {

	public static int[] BtnNumberIds = {
		R.id.button1,
		R.id.button2,
		R.id.button3,
		R.id.button4,
		R.id.button5,
		R.id.button6,
		R.id.button7,
		R.id.button8,
		R.id.button9,
		R.id.button0, 
		R.id.buttonstar,
		R.id.buttondiez
		
	};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);
        
        final EditText txt = (EditText)findViewById(R.id.editText1);
        
        for(int i = 0; i < BtnNumberIds.length; i++ ){
        	final Button btn = (Button)findViewById(BtnNumberIds[i]);	
        	btn.setOnClickListener(new OnClickListener() {
        		@Override
        		public void onClick(View vw) {            	
        			txt.setText(txt.getText().toString() + btn.getText().toString());
        		}
        	});
        }
        
        final Button btnBack = (Button)findViewById(R.id.buttondel);	
        btnBack.setOnClickListener(new OnClickListener() {
        		@Override
        		public void onClick(View vw) {        
        			String s = txt.getText().toString();
        			if(s.length() > 0)	
        			txt.setText(s.substring(0, s.length() - 1));
        		}
        	});
        	

    	final Button btncall = (Button)findViewById(R.id.buttoncall);	
    	btncall.setOnClickListener(new OnClickListener() {
    		@Override
    		public void onClick(View vw) {
    			Intent intent = new Intent(Intent.ACTION_CALL);
    	        intent.setData(Uri.parse("tel:" + txt.getText().toString()));
    	        startActivity(intent);    		
    	    }
    	});

        
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.phone_dialer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
