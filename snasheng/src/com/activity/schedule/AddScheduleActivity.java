package com.activity.schedule;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;

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
	private DatePickerDialog dlg;

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
		Calendar d = Calendar.getInstance(Locale.CHINA);
		Date myDate = new Date();
		// 创建一个Date实例
		d.setTime(myDate);
		int year = d.get(Calendar.YEAR);
		int month = d.get(Calendar.MONTH);
		int day = d.get(Calendar.DAY_OF_MONTH);
		// 获得日历中的 year month day
		dlg = new DatePickerDialog(this, 0, new OnDateSetListener() {

			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				Log.e("debyg", "day:" + dayOfMonth + "  month:" + monthOfYear
						+ 1 + "  year:" + year);
			}
		}, year, month, day);
		dlg.show();
		dlg.setButton(DatePickerDialog.BUTTON_NEGATIVE, "取消",
				new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dlg.dismiss();
					}
				});
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
