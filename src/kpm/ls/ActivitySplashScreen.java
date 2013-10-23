package kpm.ls;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class ActivitySplashScreen extends Activity {
	boolean isStarted = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		isStarted = prefs.getBoolean("isStarted", false);

		new Handler().postDelayed(new Runnable() {
			public void run() {
				if (!isStarted) {
					startActivity(new Intent(getApplicationContext(),
							ActivityLogin.class));
//					Toast.makeText(getApplicationContext(), "!isStarted", 0)
//							.show();
				} else {
					startActivity(new Intent(getApplicationContext(),
							ActivityMainApp.class));
//					Toast.makeText(getApplicationContext(), "isStarted", 0)
//							.show();
				}
				finish();
			}
		}, 1000);
	}

}
