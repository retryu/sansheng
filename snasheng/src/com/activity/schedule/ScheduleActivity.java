package com.activity.schedule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.activity.CommonActivity;
import com.example.sansheng.R;
import com.sansheng.dao.interfaze.ScheduleDao;
import com.sansheng.model.Schedule;

public class ScheduleActivity extends CommonActivity {
	private ViewPager viewPager;
	private TabsAdapter tabsAdapter;
	private ActionBar actionBar;
	private ScheduleDao scheduleDao;
	private Schedule schedule;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_schedule);
		initWidget();
		ckeckIntent(getIntent());
	}

	public void ckeckIntent(Intent intent) {
		if (intent == null || intent.getExtras() == null) {
			return;
		}
		int tabIndex = intent.getExtras().getInt("tabIndex");
		viewPager.setCurrentItem(tabIndex);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		// return super.onCreateOptionsMenu(menu);
		MenuItem add = menu.add(0, 1, 0, "添加");
		add.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		Log.e("debug", item.getItemId() + "");
		Intent intent = new Intent(this, AddScheduleActivity.class);
		startActivity(intent);
		finish();
		return super.onOptionsItemSelected(item);
	}
	
	
	

	public void initWidget() {
		actionBar = getSupportActionBar();
		actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayShowHomeEnabled(true);
		actionBar.setTitle(R.string.schedule_alert);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		viewPager = (ViewPager) findViewById(R.id.ViewPaper_Content);
		tabsAdapter = new TabsAdapter(this, viewPager);
		tabsAdapter.addTab(actionBar.newTab().setText("拜访提醒"),
				FragmentVisit.class, null);
		tabsAdapter.addTab(actionBar.newTab().setText("生日提醒"),
				FragmentBirthDay.class, null);
		tabsAdapter.addTab(actionBar.newTab().setText("其他提醒"),
				FragmentOther.class, null);

	}
}
