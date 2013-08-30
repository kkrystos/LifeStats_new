package kpm.ls;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;

public class MainFragmentActivity extends FragmentActivity  {

	TabsAdapter TabsAdapter;
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_fragment);

		mViewPager = (ViewPager) findViewById(R.id.pager);
		

		TabsAdapter = new TabsAdapter(getSupportFragmentManager(), mViewPager);
		
		final ActionBar bar = getActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		TabsAdapter.addTab(bar.newTab().setText("Fragment 1"), Fragment1.class, null);
		TabsAdapter.addTab(bar.newTab().setText("Fragment 2"), Fragment2.class, null);
		TabsAdapter.addTab(bar.newTab().setText("Fragment 3"), Fragment3.class, null);
		
//		bar.setSelectedNavigationItem(1);// ustawia startow¹ zak³adkê zak³adkê 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main_fragment, menu);
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
	

}