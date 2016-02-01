package com.example.bestpractices.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * SQLite���ݿ���ʹ����࣬�����չʾ���������ݿ�����ʵ��
 * 
 * @author linus
 * 
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

	// ��һ�棺ֻ������Book��
	public static final String CREATE_BOOK = "create table Book ("
			+ "id integer primary key autoincrement," + "author text,"
			+ "price real," + "pages integer," + "name text"
			// ������������һ���ֶ�
			+ "category_id integer)";

	// �ڶ��棺���Ӵ�����Category��
	public static final String CREATE_CATEGORY = "create table Category ("
			+ "id integer primary key autoincrement," + "category_name text,"
			+ "category_code integer";

	public MyDatabaseHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		// ��һ�棺
		db.execSQL(CREATE_BOOK);
		// �ڶ����������
		db.execSQL(CREATE_CATEGORY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

		// �����ı�����Ҫ������switch���ƿ�Ĺᴩ
		switch (oldVersion) {
		// ��һ��-�ڶ���
		// ֮ǰһ����1
		case 1:
			db.execSQL(CREATE_CATEGORY);
			// �ڶ���-������
			// ֮ǰһ����2
		case 2:
			db.execSQL("alter table Book add column category_id integer");
		default:
		}
	}

}
