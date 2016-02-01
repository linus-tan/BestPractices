package com.example.bestpractices.activities;

import com.example.bestpractices.utility.ActivityCollector;
import com.example.bestpractices.utility.LogUtil;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 当子类Activity创建的时候，会调用这条log显示类名
		// 当接手一个陌生的项目，不知道需要修改的界面属于哪个activity时，可以使用此方法快速获得类名
		LogUtil.d("BaseActivity", getClass().getSimpleName());
		
		//将当前实例加入activity列表
		ActivityCollector.addActivity(this);
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		//activity销毁的时候，在activity列表中移除当前实例
		ActivityCollector.removeActivity(this);
	}

}
