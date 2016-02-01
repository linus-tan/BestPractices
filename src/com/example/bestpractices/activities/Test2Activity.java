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
		// Serializable��ʽ���ݶ���
		Msg msg = (Msg) intent.getSerializableExtra("msg_data");
		// Parcelable��ʽ���ݶ���
		Person person = (Person) intent.getParcelableExtra("person_data");
	}

	/**
	 * ������ǰ��activity������ͼ������õ���������activity��������������activity������֪����Ҫ����ʲô
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
		// Serializable��ʽ���ݶ���
		intent.putExtra("msg_data", msg);
		// Parcelable��ʽ���ݶ���
		intent.putExtra("person_data", person);
		context.startActivity(intent);
	}

}
