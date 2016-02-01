package com.example.bestpractices.activities;

import com.example.bestpractices.model.Msg;
import com.example.bestpractices.model.Person;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class Test2Activity extends BaseActivity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		String param1 = intent.getStringExtra("param1");
		String param2 = intent.getStringExtra("param2");
		// Serializable方式传递对象
		Msg msg = (Msg) intent.getSerializableExtra("msg_data");
		// Parcelable方式传递对象
		Person person = (Person) intent.getParcelableExtra("person_data");
	}

	/**
	 * 启动当前的activity，将意图代码后置到待启动的activity，这样启动它的activity就无需知道需要传递什么
	 * 
	 * @param context
	 * @param data1
	 * @param data2
	 */
	public static void actionStart(Context context, String data1, String data2,
			Msg msg, Person person) {
		Intent intent = new Intent(context, Test2Activity.class);
		intent.putExtra("param1", data1);
		intent.putExtra("param2", data2);
		// Serializable方式传递对象
		intent.putExtra("msg_data", msg);
		// Parcelable方式传递对象
		intent.putExtra("person_data", person);
		context.startActivity(intent);
	}

}
