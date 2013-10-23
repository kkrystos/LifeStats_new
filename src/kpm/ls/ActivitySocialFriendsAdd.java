package kpm.ls;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ActivitySocialFriendsAdd extends Activity implements
		OnClickListener {
	static Activity activity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_social_friend);
		activity = this;
		ImageButton facebook_addBtn = (ImageButton) findViewById(R.id.social_friend_facebook_addBtn);
		facebook_addBtn.setOnClickListener(this);
		ImageButton twitter_addBtn = (ImageButton) findViewById(R.id.social_friend_twitter_addBtn);
		twitter_addBtn.setOnClickListener(this);
		ImageButton google_plus_addBtn = (ImageButton) findViewById(R.id.social_friend_google_plus_addBtn);
		google_plus_addBtn.setOnClickListener(this);
		ImageButton pinterest_addBtn = (ImageButton) findViewById(R.id.social_friend_pinterest_addBtn);
		pinterest_addBtn.setOnClickListener(this);
		Button continueBtn = (Button) findViewById(R.id.social_friendContinueBtn);
		continueBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.social_friend_facebook_addBtn:
			Toast.makeText(getApplicationContext(), "add friends from Facebook", 0).show();
			break;
		case R.id.social_friend_twitter_addBtn:
			Toast.makeText(getApplicationContext(), "add friends from Twitter", 0).show();
			break;
		case R.id.social_friend_google_plus_addBtn:
			Toast.makeText(getApplicationContext(), "add friends from Google +", 0)
					.show();
			break;
		case R.id.social_friend_pinterest_addBtn:
			Toast.makeText(getApplicationContext(), "add friends from Pinterest", 0).show();
			break;
		case R.id.social_friendContinueBtn:
			startActivity(new Intent(getApplicationContext(),
					ActivityChooseStats.class));
			break;
		}

	}
}
