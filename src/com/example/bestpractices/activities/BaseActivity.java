package com.example.bestpractices.activities;

import com.example.bestpractices.utility.ActivityCollector;
import com.example.bestpractices.utility.LogUtil;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// ������Activity������ʱ�򣬻��������log��ʾ����
		// ������һ��İ������Ŀ����֪����Ҫ�޸ĵĽ��������ĸ�activityʱ������ʹ�ô˷������ٻ������
		LogUtil.d("BaseActivity", getClass().getSimpleName());
		
		//����ǰʵ������activity�б�
		ActivityCollector.addActivity(this);
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		//activity���ٵ�ʱ����activity�б����Ƴ���ǰʵ��
		ActivityCollector.removeActivity(this);
	}

}
