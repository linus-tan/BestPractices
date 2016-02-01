package com.example.bestpractices.activities;

import com.example.bestpractices.model.Msg;
import com.example.bestpractices.model.Person;
import com.example.bestpractices.utility.ActivityCollector;
import com.example.bestpractices.utility.HttpCallbackListener;
import com.example.bestpractices.utility.HttpUtil;
import com.example.bestpractices.utility.LogUtil;
import com.example.bestpractices.utility.MyApplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Test1Activity extends BaseActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ��ӡ����ջid
		LogUtil.d("Test1Activity", "Task Id is" + getTaskId());
		// װ�ز���
		// setContentView(layoutResID);

		// �ر�����activity
		Button button1 = new Button(this);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// �ر�����activity
				ActivityCollector.finishAll();
				// �������������л�Ĵ�����ټ���ɱ����ǰ���̵Ĵ��룬�Ա�֤������ȫ�˳�
			}
		});

		// ����Test2Activity
		Button button2 = new Button(this);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// ����Test2Activity��ͨ�����õĴ������
				// ��չʾ���ַ�ʽ���ݶ�������Parcelable��ʵ�ָ��ӵ����Ӹ�Ч
				Msg msg = new Msg("1", Msg.TYPE_SENT);
				Person person = new Person();
				person.setAge(26);
				person.setName("linus");
				Test2Activity.actionStart(Test1Activity.this, "��", "��", msg,
						person);

			}
		});

		// ����ǿ�����ߵİ�ť��ʵ����һ���㲥�������ڳ������һλ�ö�����ǿ��������
		Button forceOffline = new Button(this);
		forceOffline.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// ����action
				Intent intent = new Intent(
						"com.example.broadcastbestpractice.FORCE_OFFLINE");
				sendBroadcast(intent);
			}
		});

		// ����һ��Http get�����ʾ��
		Button sendRequestButton = new Button(this);
		sendRequestButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				HttpUtil.sendHttpRequest("http://www.linus.org",
						new HttpCallbackListener() {

							// ע�⣺��Щ�������������߳��ڵģ���������ֱ�Ӹ���UI
							@Override
							public void onFinish(String response) {
								// TODO Auto-generated method stub
								// ��������ݷ�������ִ�о�����߼�
							}

							@Override
							public void onError(Exception e) {
								// TODO Auto-generated method stub
								// ��������쳣������д���
							}
						});
			}
		});

		// �ڳ�������λ�û�ȡӦ�ó��򼶵������Ķ���
		Button getAppContext = new Button(this);
		getAppContext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MyApplication.getContext();
			}
		});
	}

}
