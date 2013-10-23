package kpm.ls;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ActivitySynchronizationMain extends Activity implements OnClickListener {
	static Activity activity;
	private ImageButton synchBtnF;
	private ImageButton synchBtnT;
	private ImageButton synchBtnP;
	private ImageButton synchBtnG;
	private SharedPreferences prefs;
	private SharedPreferences.Editor edit;
	boolean isF;
	boolean isG;
	boolean isT;
	boolean isP;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_synchronization);
		
		activity = this;
		
		prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		isF = prefs.getBoolean("isF", false);
		isG = prefs.getBoolean("isG", false);
		isT = prefs.getBoolean("isT", false);
		isP = prefs.getBoolean("isP", false);
		
		Button buttonContinue = (Button) findViewById(R.id.synch_continueBtn);
		buttonContinue.setOnClickListener(this);
		synchBtnF = (ImageButton)findViewById(R.id.synchBtnF);
		synchBtnF.setOnClickListener(this);
		synchBtnT = (ImageButton)findViewById(R.id.synchBtnT);
		synchBtnT.setOnClickListener(this);
		synchBtnP = (ImageButton)findViewById(R.id.synchBtnP);
		synchBtnP.setOnClickListener(this);
		synchBtnG = (ImageButton)findViewById(R.id.synchBtnG);
		synchBtnG.setOnClickListener(this);
		
		if (isF) {
			synchBtnF.setImageResource(R.drawable.facebook_kolor);
		}
		if (isG) {
			synchBtnG.setImageResource(R.drawable.google_plus_kolor);
		}
		if (isP) {
			synchBtnP.setImageResource(R.drawable.pinterest_kolor);
		}
		if (isT) {
			synchBtnT.setImageResource(R.drawable.twitter_kolor);
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		isF = prefs.getBoolean("isF", false);
		isG = prefs.getBoolean("isG", false);
		isT = prefs.getBoolean("isT", false);
		isP = prefs.getBoolean("isP", false);
		switch (v.getId()) {
		case R.id.synch_continueBtn:
			startActivity(new Intent(getApplicationContext(), ActivitySocialFriendsAdd.class));
			break;
		case R.id.synchBtnF:
			if (!isF) {
				synchBtnF.setImageResource(R.drawable.facebook_kolor);
				Toast.makeText(getApplicationContext(), "sync with Facebook will be added", 0).show();
				edit = prefs.edit();
				edit.putBoolean("isF", Boolean.TRUE);
				edit.commit();
			}else{
				synchBtnF.setImageResource(R.drawable.facebook);
				Toast.makeText(getApplicationContext(), "sync with Facebook will be disabled", 0).show();
				edit = prefs.edit();
				edit.putBoolean("isF", Boolean.FALSE);
				edit.commit();
			}
			break;
		case R.id.synchBtnT:
			if (!isT) {
				synchBtnT.setImageResource(R.drawable.twitter_kolor);
				Toast.makeText(getApplicationContext(), "sync with Tweeter will be added", 0).show();
				edit = prefs.edit();
				edit.putBoolean("isT", Boolean.TRUE);
				edit.commit();
			}else{
				synchBtnT.setImageResource(R.drawable.twitter);
				Toast.makeText(getApplicationContext(), "sync with Tweeter will be disabled", 0).show();
				edit = prefs.edit();
				edit.putBoolean("isT", Boolean.FALSE);
				edit.commit();
			}
			break;
		case R.id.synchBtnG:
			if (!isG) {
				synchBtnG.setImageResource(R.drawable.google_plus_kolor);
				Toast.makeText(getApplicationContext(), "sync with Google+ will be added", 0).show();
				edit = prefs.edit();
				edit.putBoolean("isG", Boolean.TRUE);
				edit.commit();
			}else{
				synchBtnG.setImageResource(R.drawable.google_plus);
				Toast.makeText(getApplicationContext(), "sync with Google+ will be disabled", 0).show();
				edit = prefs.edit();
				edit.putBoolean("isG", Boolean.FALSE);
				edit.commit();
			}
			break;
		case R.id.synchBtnP:
			if (!isP) {
				synchBtnP.setImageResource(R.drawable.pinterest_kolor);
				Toast.makeText(getApplicationContext(), "sync with Pinterest will be added", 0).show();
				edit = prefs.edit();
				edit.putBoolean("isP", Boolean.TRUE);
				edit.commit();
			}else{
				synchBtnP.setImageResource(R.drawable.pinterest);
				Toast.makeText(getApplicationContext(), "sync with Pinterest will be disabled", 0).show();
				edit = prefs.edit();
				edit.putBoolean("isP", Boolean.FALSE);
				edit.commit();
			}
			break;
		default:
			break;
		}
	}
}
