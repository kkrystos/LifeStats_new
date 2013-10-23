package kpm.ls;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityMainApp extends Activity{

	
	GridView gridView;
	private ArrayList<String> arrayList;
	private int position = 0;

	static final String[] MOBILE_OS = new String[] { "Android", "iOS",
			"Windows", "Blackberry" ,"Android", "iOS",
			"Windows", "Blackberry"};

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_app);
		
		
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		boolean isStarted = prefs.getBoolean("isStarted", false);

		if (!isStarted) {
			SharedPreferences.Editor edit = prefs.edit();
			edit.putBoolean("isStarted", Boolean.TRUE);
			edit.commit();
		}

		SharedPreferences getPrefs = PreferenceManager
				.getDefaultSharedPreferences(getApplicationContext());
		boolean isPolaczenia = getPrefs.getBoolean("polaczenia_check", false);
		boolean isSMS = getPrefs.getBoolean("sms_check", false);
		boolean isEmail = getPrefs.getBoolean("email_check", false);
		boolean isKlikniecia = getPrefs.getBoolean("klikniecia_check", false);
		boolean isKroki = getPrefs.getBoolean("kroki_check", false);
		boolean isLadowanie = getPrefs.getBoolean("ladowanie_check", false);
		boolean isAplikacje = getPrefs.getBoolean("aplikacje_check", false);
		boolean isInternet = getPrefs.getBoolean("internet_check", false);
		boolean isPion_Poziom = getPrefs.getBoolean("pion_poziom_check", false);
		boolean isMuzyka = getPrefs.getBoolean("muzyka_check", false);
		boolean isSmartfon = getPrefs.getBoolean("smartfon_check", false);

		arrayList = new ArrayList<String>();

		if (isPolaczenia) {
			arrayList.add("Polaczenia");
//			addButton(getApplicationContext(), linearLayout, lp, "Polaczenia",
//					FragmentPolaczenia.class, position++);
		}
		if (isSMS) {
			arrayList.add("SMS");
//			addButton(getApplicationContext(), linearLayout, lp, "SMS",
//					FragmentSMS.class, position++);
		}
		if (isEmail) {
			arrayList.add("Email");
//			addButton(getApplicationContext(), linearLayout, lp, "Email",
//					FragmentEmail.class, position++);
		}
		if (isKlikniecia) {
			arrayList.add("Klikniecia");
//			addButton(getApplicationContext(), linearLayout, lp, "Klikniecia",
//					FragmentKlikniecia.class, position++);
		}
		if (isKroki) {
			arrayList.add("Kroki");
//			addButton(getApplicationContext(), linearLayout, lp, "Kroki",
//					FragmentKroki.class, position++);
		}
		if (isLadowanie) {
			arrayList.add("£adowanie");
//			addButton(getApplicationContext(), linearLayout, lp, "Ladowanie",
//					FragmentLadowanie.class, position++);
		}
		if (isAplikacje) {
			arrayList.add("Aplikacje");
//			addButton(getApplicationContext(), linearLayout, lp, "Aplikacje",
//					FragmentUruchomieniaApp.class, position++);
		}
		if (isInternet) {
			arrayList.add("Internet");
//			addButton(getApplicationContext(), linearLayout, lp, "Internet",
//					FragmentInternet.class, position++);
		}
		if (isPion_Poziom) {
			arrayList.add("Pion/Poziom");
//			addButton(getApplicationContext(), linearLayout, lp, "Pion_Poziom",
//					FragmentPionPoziom.class, position++);
		}
		if (isMuzyka) {
			arrayList.add("Muzyka");
//			addButton(getApplicationContext(), linearLayout, lp, "Muzyka",
//					FragmentMuzyka.class, position++);
		}
		if (isSmartfon) {
			arrayList.add("Smartfon");
//			addButton(getApplicationContext(), linearLayout, lp, "Smartfon",
//					FragmentSmartfon.class, position++);
		}

		gridView = (GridView) findViewById(R.id.gridView1);
		gridView.setAdapter(new ImageAdapter(this, arrayList));
		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
//				Toast.makeText(
//						getApplicationContext(),
//						((TextView) v.findViewById(R.id.grid_item_label))
//								.getText(), Toast.LENGTH_SHORT).show();
				
				Intent intent = new Intent(getApplicationContext(),
						MainFragmentActivity.class);
				intent.putExtra("position", position);
				startActivity(intent);

			}
		});

	}
	
	class ImageAdapter extends BaseAdapter {
		private Context context;
		private final ArrayList<String>  mobileValues;

		public ImageAdapter(Context context, ArrayList<String> arrayList) {
			this.context = context;
			this.mobileValues = arrayList;
		}

		public View getView(int position, View convertView, ViewGroup parent) {

			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			View gridView;

			if (convertView == null) {

				gridView = new View(context);
				gridView = inflater.inflate(R.layout.activity_main_app_grid, null);
				TextView textView = (TextView) gridView
						.findViewById(R.id.grid_item_label);
				textView.setText(mobileValues.get(position));
				ImageView imageView = (ImageView) gridView
						.findViewById(R.id.grid_item_image);

				String mobile = mobileValues.get(position);

				if (mobile.equals("Windows")) {
					imageView.setImageResource(R.drawable.przykladowa_ikona);
				} else if (mobile.equals("iOS")) {
					imageView.setImageResource(R.drawable.przykladowa_ikona);
				} else if (mobile.equals("Blackberry")) {
					imageView.setImageResource(R.drawable.przykladowa_ikona);
				} else {
					imageView.setImageResource(R.drawable.przykladowa_ikona);
				}

			} else {
				gridView = (View) convertView;
			}

			return gridView;
		}

		@Override
		public int getCount() {
			return mobileValues.size();
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

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
