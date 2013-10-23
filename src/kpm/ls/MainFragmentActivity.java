package kpm.ls;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainFragmentActivity extends FragmentActivity  {

	TabsAdapter TabsAdapter;
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(savedInstanceState == null){
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
			setContentView(R.layout.activity_main_fragment);

			mViewPager = (ViewPager) findViewById(R.id.pager);
			TabsAdapter = new TabsAdapter(getSupportFragmentManager(), mViewPager);
			final ActionBar bar = getActionBar();
			bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
			
			
	        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
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
			
			Bundle bundle = getIntent().getExtras();
			
			int position = bundle.getInt("position");
			
			
			if (isPolaczenia) {
				TabsAdapter.addTab(bar.newTab().setText("Polaczenia"), FragmentPolaczenia.class, null);
			}
			if (isSMS) {
				TabsAdapter.addTab(bar.newTab().setText("SMS"), FragmentSMS.class, null);
			}
			if (isEmail) {
				TabsAdapter.addTab(bar.newTab().setText("Email"), FragmentEmail.class, null);
			}
			if (isKlikniecia) {
				TabsAdapter.addTab(bar.newTab().setText("Klikniêcia"), FragmentKlikniecia.class, null);
			}
			if (isKroki) {
				TabsAdapter.addTab(bar.newTab().setText("Kroki"), FragmentKroki.class, null);
			}
			if (isLadowanie) {
				TabsAdapter.addTab(bar.newTab().setText("£adowanie"), FragmentLadowanie.class, null);
			}
			if (isAplikacje) {
				TabsAdapter.addTab(bar.newTab().setText("Aplikacje"), FragmentUruchomieniaApp.class, null);
			}
			if (isInternet) {
				TabsAdapter.addTab(bar.newTab().setText("Internet"), FragmentInternet.class, null);
			}
			if (isPion_Poziom) {
				TabsAdapter.addTab(bar.newTab().setText("Pion/Poziom"), FragmentPionPoziom.class, null);
			}
			if (isMuzyka) {
				TabsAdapter.addTab(bar.newTab().setText("Muzyka"), FragmentMuzyka.class, null);
			}
			if (isSmartfon) {
				TabsAdapter.addTab(bar.newTab().setText("Smartfon"), FragmentSmartfon.class, null);
			}

//			TabsAdapter.addTab(bar.newTab().setText("Fragment 1"), Fragment1.class, null);
//			TabsAdapter.addTab(bar.newTab().setText("Fragment 2"), Fragment2.class, null);
//			TabsAdapter.addTab(bar.newTab().setText("Fragment 3"), Fragment3.class, null);
//			
			bar.setSelectedNavigationItem(position);// ustawia startow¹ zak³adkê zak³adkê 
		}
		else {
			
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	
	
	public class TabsAdapter extends FragmentPagerAdapter implements ActionBar.TabListener,  ViewPager.OnPageChangeListener{
		private final Context mContext;
		private final ActionBar mActionBar;
		private final ViewPager mViewPager;
		private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();
		
		
		 final class TabInfo{
			private final Class<?> clss;
			private final Bundle args;
			
			TabInfo(Class<?> _class, Bundle _args){
				clss = _class;
				args = _args;
			}
		}
		 
		 
		public TabsAdapter(FragmentManager fm, ViewPager pager) {
			super(fm);
			mContext = getApplicationContext();
			mActionBar = getActionBar();
			mViewPager = pager;
			mViewPager.setAdapter(this);
			mViewPager.setOnPageChangeListener(this);			
		}
		
		public void addTab(ActionBar.Tab tab, Class<?> clss, Bundle args){
			TabInfo info = new TabInfo(clss, args);
			tab.setTag(info);
			tab.setTabListener(this);
			mTabs.add(info);
			mActionBar.addTab(tab);
			notifyDataSetChanged();
		}
		
		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			mViewPager.setCurrentItem(tab.getPosition());
			Log.v("tag", "clicked");
			Object tag = tab.getTag();
			for (int i = 0; i<mTabs.size(); i++){
				if (mTabs.get(i) == tag){
					mViewPager.setCurrentItem(i);
				}
			}
			
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			
		}

		@Override
		public Fragment getItem(int position) {
			TabInfo info = mTabs.get(position);
			return Fragment.instantiate(mContext, info.clss.getName(), info.args);
		}

		@Override
		public int getCount() {
			return mTabs.size();
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageSelected(int position) {
			mActionBar.setSelectedNavigationItem(position);
			
		}
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.login_item) {
			Intent preferenceIntent = new Intent(this, ActivityLogin.class);
			startActivity(preferenceIntent);
			finish();
			return (true);
		} else if (item.getItemId() == R.id.choose_stats_item) {
			Intent preferenceConIntent = new Intent(this, ActivityChooseStats.class);
			startActivity(preferenceConIntent);
			finish();
			return (true);
		} else if (item.getItemId() == R.id.finish_item) {
			finish();
		}

		return super.onOptionsItemSelected(item);
	}
	

}