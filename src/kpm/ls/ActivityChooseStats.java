package kpm.ls;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ActivityChooseStats extends PreferenceActivity {

	private boolean isChecked = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.choose_stat_preferences);
		setContentView(R.layout.activity_choose_stats);
		Button button = (Button) findViewById(R.id.choose_statsSelectBtn);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SharedPreferences getPrefs = PreferenceManager
						.getDefaultSharedPreferences(getApplicationContext());
				boolean isPolaczenia = getPrefs.getBoolean("polaczenia_check",
						false);
				boolean isSMS = getPrefs.getBoolean("sms_check", false);
				boolean isEmail = getPrefs.getBoolean("email_check", false);
				boolean isKlikniecia = getPrefs.getBoolean("klikniecia_check",
						false);
				boolean isKroki = getPrefs.getBoolean("kroki_check", false);
				boolean isLadowanie = getPrefs.getBoolean("ladowanie_check",
						false);
				boolean isAplikacje = getPrefs.getBoolean("aplikacje_check",
						false);
				boolean isInternet = getPrefs.getBoolean("internet_check",
						false);
				boolean isPion_Poziom = getPrefs.getBoolean(
						"pion_poziom_check", false);
				boolean isMuzyka = getPrefs.getBoolean("muzyka_check", false);
				boolean isSmartfon = getPrefs.getBoolean("smartfon_check",
						false);

				if (isPolaczenia || isSMS || isEmail || isKlikniecia || isKroki
						|| isLadowanie || isAplikacje || isInternet
						|| isPion_Poziom || isMuzyka || isSmartfon) {
					isChecked = true;
				}

				if (isChecked) {
					
					if (ActivityLogin.activity != null) {
						ActivityLogin.activity.finish();
					}
					if (ActivitySocialFriendsAdd.activity != null) {
						ActivitySocialFriendsAdd.activity.finish();
					}
					if (ActivitySynchronizationMain.activity != null) {
						ActivitySynchronizationMain.activity.finish();
					}

//					startActivity(new Intent(getApplicationContext(),
//							MainAppActivity.class));
					startActivity(new Intent(getApplicationContext(),
							ActivityMainApp.class));
					finish();
				} else {

					Toast.makeText(getApplicationContext(),
							"Wybierz statystykê", 0).show();
				}

			}
		});
	}
}
