package com.sansheng.db;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.sansheng.dao.interfaze.ScheduleDao;
import com.sansheng.model.Schedule;

public class OrmDateBaseHelper extends SQLiteOpenHelper {

	private static ScheduleDao scheduleDao;

	public OrmDateBaseHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		initScheme();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.e("debug", "onCreate");

	}

	public void initScheme() {

		ConnectionSource connectionSource = new AndroidConnectionSource(this);
		try {
			TableUtils.createTable(connectionSource, Schedule.class);
			scheduleDao = DaoManager
					.createDao(connectionSource, Schedule.class);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.e("debug", "onCreate");
	}

	public static ScheduleDao getScheduleDao() {
		return scheduleDao;
	}

	public static void setScheduleDao(ScheduleDao scheduleDao) {
		OrmDateBaseHelper.scheduleDao = scheduleDao;
	}

}
