package kpm.ls;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActivityLogin extends Activity implements OnClickListener{

	static Activity activity;
	private Button manBtn;
	private Button womanBtn;
	SharedPreferences prefs;
	SharedPreferences.Editor edit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		activity = this;
		
		prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean isMan = prefs.getBoolean("isMan", true);
		
		Button button = (Button) findViewById(R.id.login_continueBtn);
		button.setOnClickListener(this);
		manBtn = (Button) findViewById(R.id.login_manBtn);
		manBtn.setOnClickListener(this);
		womanBtn = (Button) findViewById(R.id.login_womanBtn);
		womanBtn.setOnClickListener(this);

		if (isMan) {
			manBtn.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ikona_1, 0, 0, 0);
			womanBtn.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ikona_2_szara, 0, 0, 0);
			manBtn.setTextColor(Color.parseColor("#1FA4DC")); 
			womanBtn.setTextColor(Color.parseColor("#CCCCCC")); 
		}else {
			manBtn.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ikona_1_szara, 0, 0, 0);
			womanBtn.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ikona_2, 0, 0, 0);
			manBtn.setTextColor(Color.parseColor("#CCCCCC")); 
			womanBtn.setTextColor(Color.parseColor("#1FA4DC")); 
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.login_manBtn:

			manBtn.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ikona_1, 0, 0, 0);
			womanBtn.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ikona_2_szara, 0, 0, 0);
			manBtn.setTextColor(Color.parseColor("#1FA4DC")); 
			womanBtn.setTextColor(Color.parseColor("#CCCCCC")); 
			
			edit = prefs.edit();
			edit.putBoolean("isMan", Boolean.TRUE);
			edit.commit();
			
			break;
		case R.id.login_womanBtn:
			manBtn.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ikona_1_szara, 0, 0, 0);
			womanBtn.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ikona_2, 0, 0, 0);
			manBtn.setTextColor(Color.parseColor("#CCCCCC")); 
			womanBtn.setTextColor(Color.parseColor("#1FA4DC")); 
			
			edit = prefs.edit();
			edit.putBoolean("isMan", Boolean.FALSE);
			edit.commit();
			
			break;
		case R.id.login_continueBtn:
			startActivity(new Intent(getApplicationContext(), ActivitySynchronizationMain.class));
			break;
		}
	}
}
