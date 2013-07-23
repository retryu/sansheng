package com.activity.schedule;

import java.util.Calendar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TimePicker;

import com.actionbarsherlock.app.ActionBar;
import com.activity.CommonActivity;
import com.example.sansheng.R;
import com.sansheng.model.Contact;
import com.sansheng.model.Schedule;

public class AddScheduleActivity extends CommonActivity implements
		android.view.View.OnClickListener {

	private ActionBar actionBar;
	private Button btnCustome;
	private Button btnDate;
	private Button btnFinish;
	private EditText etContent;
	private RadioGroup rgType;
	private Schedule schedule;

	@Override
	public void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_add_schedule);
		initWidget();
	}

	public void initWidget() {
		schedule = new Schedule();
		actionBar = getSupportActionBar();
		actionBar.setTitle(getResources().getString(
				R.string.title_schedule_edit));
		etContent = (EditText) findViewById(R.id.Et_Content);
		btnCustome = (Button) findViewById(R.id.Btn_Custome);
		btnDate = (Button) findViewById(R.id.Btn_Date);
		btnFinish = (Button) findViewById(R.id.Btn_Finish);
		btnCustome.setOnClickListener(this);
		btnDate.setOnClickListener(this);
		btnFinish.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
		case R.id.Btn_Custome:
			Intent intent = new Intent(this, SelectCustomeActivity.class);
			startActivityForResult(intent, 0);
			break;

		case R.id.Btn_Date:
			showDatePicker();
			break;
		case R.id.Btn_Finish:
			break;
		}

	}

	public void showDatePicker() {

	}

	public String getContent() {
		String content = etContent.getText().toString();
		return content;
	}

	public void toSelectActivity() {

	}

	@Override
	protected void onActivityResult(int arg0, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(arg0, resultCode, data);
		if (resultCode == 0) {
			if (data != null) {
				Bundle bundle = data.getExtras();
				Contact contact = (Contact) bundle.get("contact");
				Log.e("debug", "" + contact);
				schedule.setCustome_id(contact.getId());
				schedule.setCustome_name(contact.getName());
				btnCustome.setText(contact.getName());
			}
		}

	}

}
