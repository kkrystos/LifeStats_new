package kpm.ls;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainAppActivity extends Activity {

	private ArrayList<String> arrayList;
	private int position = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

//		LinearLayout linearLayout = new LinearLayout(this);
//		linearLayout.setOrientation(LinearLayout.VERTICAL);
//
//		LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(
//				LinearLayout.LayoutParams.FILL_PARENT,
//				LinearLayout.LayoutParams.FILL_PARENT);
//		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//				LinearLayout.LayoutParams.MATCH_PARENT,
//				LinearLayout.LayoutParams.WRAP_CONTENT);
//
//		SharedPreferences prefs = PreferenceManager
//				.getDefaultSharedPreferences(getBaseContext());
//		boolean isStarted = prefs.getBoolean("isStarted", false);
//
//		if (!isStarted) {
//			SharedPreferences.Editor edit = prefs.edit();
//			edit.putBoolean("isStarted", Boolean.TRUE);
//			edit.commit();
//		}
//
//		SharedPreferences getPrefs = PreferenceManager
//				.getDefaultSharedPreferences(getApplicationContext());
//		boolean isPolaczenia = getPrefs.getBoolean("polaczenia_check", false);
//		boolean isSMS = getPrefs.getBoolean("sms_check", false);
//		boolean isEmail = getPrefs.getBoolean("email_check", false);
//		boolean isKlikniecia = getPrefs.getBoolean("klikniecia_check", false);
//		boolean isKroki = getPrefs.getBoolean("kroki_check", false);
//		boolean isLadowanie = getPrefs.getBoolean("ladowanie_check", false);
//		boolean isAplikacje = getPrefs.getBoolean("aplikacje_check", false);
//		boolean isInternet = getPrefs.getBoolean("internet_check", false);
//		boolean isPion_Poziom = getPrefs.getBoolean("pion_poziom_check", false);
//		boolean isMuzyka = getPrefs.getBoolean("muzyka_check", false);
//		boolean isSmartfon = getPrefs.getBoolean("smartfon_check", false);
//
//		arrayList = new ArrayList<String>();
//
//		if (isPolaczenia) {
//			arrayList.add("polaczenia");
//			addButton(getApplicationContext(), linearLayout, lp, "Polaczenia",
//					FragmentPolaczenia.class, position++);
//		}
//		if (isSMS) {
//			arrayList.add("sms");
//			addButton(getApplicationContext(), linearLayout, lp, "SMS",
//					FragmentSMS.class, position++);
//		}
//		if (isEmail) {
//			arrayList.add("email");
//			addButton(getApplicationContext(), linearLayout, lp, "Email",
//					FragmentEmail.class, position++);
//		}
//		if (isKlikniecia) {
//			arrayList.add("klikniecia");
//			addButton(getApplicationContext(), linearLayout, lp, "Klikniecia",
//					FragmentKlikniecia.class, position++);
//		}
//		if (isKroki) {
//			arrayList.add("kroki");
//			addButton(getApplicationContext(), linearLayout, lp, "Kroki",
//					FragmentKroki.class, position++);
//		}
//		if (isLadowanie) {
//			arrayList.add("ladowanie");
//			addButton(getApplicationContext(), linearLayout, lp, "Ladowanie",
//					FragmentLadowanie.class, position++);
//		}
//		if (isAplikacje) {
//			arrayList.add("aplikacje");
//			addButton(getApplicationContext(), linearLayout, lp, "Aplikacje",
//					FragmentUruchomieniaApp.class, position++);
//		}
//		if (isInternet) {
//			arrayList.add("internet");
//			addButton(getApplicationContext(), linearLayout, lp, "Internet",
//					FragmentInternet.class, position++);
//		}
//		if (isPion_Poziom) {
//			arrayList.add("pion/poziom");
//			addButton(getApplicationContext(), linearLayout, lp, "Pion_Poziom",
//					FragmentPionPoziom.class, position++);
//		}
//		if (isMuzyka) {
//			arrayList.add("muzyka");
//			addButton(getApplicationContext(), linearLayout, lp, "Muzyka",
//					FragmentMuzyka.class, position++);
//		}
//		if (isSmartfon) {
//			arrayList.add("smartfon");
//			addButton(getApplicationContext(), linearLayout, lp, "Smartfon",
//					FragmentSmartfon.class, position++);
//		}
//
//		setContentView(linearLayout, llp);
//		
//		if (!isPolaczenia & !isSMS & !isEmail & !isKlikniecia & !isKroki
//				& !isLadowanie & !isAplikacje & !isInternet
//				& !isPion_Poziom & !isMuzyka & !isSmartfon) {
//			Toast.makeText(getApplicationContext(), "Dodaj statystykê", 0).show();
//		}
		
		
		
	}

	public void addButton(final Context context, LinearLayout linearLayout,
			LinearLayout.LayoutParams lp, final String nazwaBtn, Class<?> cls,
			final int position) {
		final Class<?> klasa = cls;
		Button btn = new Button(context);
		btn.setText(nazwaBtn);
		btn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				// Toast.makeText(getApplicationContext(), ""+i,
				// Toast.LENGTH_SHORT).show();
				// startActivity(new Intent(getApplicationContext(),
				// MainFragmentActivity.class));

				Intent intent = new Intent(context.getApplicationContext(),
						MainFragmentActivity.class);
				intent.putExtra("position", position);
				startActivity(intent);

				// Intent intent = new
				// Intent(context.getApplicationContext(),klasa);
				// intent.putExtra("odchyleniePlusSrednia", 0.0);
				// intent.putExtra("arrayList", arrayList);
				// startActivity(intent);
				// Toast.makeText(getApplicationContext(), ""+ arrayList,
				// Toast.LENGTH_SHORT).show();
			}
		});
		btn.setLayoutParams(lp);
		linearLayout.addView(btn);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		new MenuInflater(this).inflate(R.menu.menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.login_item) {
			Intent preferenceIntent = new Intent(this, ActivityLogin.class);
			startActivity(preferenceIntent);
			finish();
			return (true);
		} else if (item.getItemId() == R.id.choose_stats_item) {
			Intent preferenceConIntent = new Intent(this,
					ActivityChooseStats.class);
			startActivity(preferenceConIntent);
			finish();
			return (true);
		} else if (item.getItemId() == R.id.finish_item) {
			finish();
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {

			Toast.makeText(getApplicationContext(), "BACK", 0).show();
			return true;
		}
		// else if (keyCode == KeyEvent.KEYCODE_){
		// return true;
		// }
		return super.onKeyDown(keyCode, event);
	}

}