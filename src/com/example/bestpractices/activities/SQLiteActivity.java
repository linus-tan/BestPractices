package com.example.bestpractices.activities;

import com.example.bestpractices.db.MyDatabaseHelper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 用于演示SQLite数据库事务的使用方法
 * 
 * @author linus
 * 
 */
public class SQLiteActivity extends BaseActivity {

	private MyDatabaseHelper dbHelper;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(layoutResID);
		dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 3);

		Button replaceData = new Button(this);
		replaceData.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SQLiteDatabase db = dbHelper.getWritableDatabase();

				// 开始事物
				db.beginTransaction();
				try {
					db.delete("Book", null, null);
					if (true) {
						// 抛出一个异常，事务即失败
						throw new NullPointerException();
					}
					ContentValues values = new ContentValues();
					values.put("name", "Game of Thrones");
					values.put("author", "George Martin");
					values.put("pages", "720");
					values.put("price", 20.85);
					db.insert("Book", null, values);

					// 事务已经执行成功
					db.setTransactionSuccessful();

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					db.endTransaction();
				}
			}
		});
	}
}
