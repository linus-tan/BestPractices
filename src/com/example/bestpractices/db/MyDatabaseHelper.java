package com.example.bestpractices.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * SQLite数据库访问工具类，这个类展示了升级数据库的最佳实践
 * 
 * @author linus
 * 
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

	// 第一版：只创建了Book表
	public static final String CREATE_BOOK = "create table Book ("
			+ "id integer primary key autoincrement," + "author text,"
			+ "price real," + "pages integer," + "name text"
			// 第三饭增加了一个字段
			+ "category_id integer)";

	// 第二版：增加创建了Category表
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
		// 第一版：
		db.execSQL(CREATE_BOOK);
		// 第二版与第三版
		db.execSQL(CREATE_CATEGORY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

		// 升级的编码主要利用了switch控制块的贯穿
		switch (oldVersion) {
		// 第一版-第二版
		// 之前一版是1
		case 1:
			db.execSQL(CREATE_CATEGORY);
			// 第二版-第三版
			// 之前一版是2
		case 2:
			db.execSQL("alter table Book add column category_id integer");
		default:
		}
	}

}
