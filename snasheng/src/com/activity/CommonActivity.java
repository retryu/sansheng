package com.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.example.sansheng.R;

public class CommonActivity extends SherlockFragmentActivity {
	public static int THEME = R.style.Theme_Sherlock_Light;
	TextView tvTitle;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);

		setTheme(THEME);

		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().setCustomView(R.layout.abs_layout);

		// tvTitle = (TextView) getSupportActionBar().getCustomView()
		// .findViewById(R.id.Tv_Title);
	}

	public String getStr(int strId) {
		String string = getResources().getString(strId);
		return string;
	}

	public void setTitle(String title) {
		tvTitle.setText(title);
	}
}
