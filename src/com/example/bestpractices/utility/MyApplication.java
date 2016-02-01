package com.example.bestpractices.utility;

import android.app.Application;
import android.content.Context;

/**
 * 自定义的Application
 * 
 * @author linus
 * 
 */
public class MyApplication extends Application {

	private static Context context;

	@Override
	public void onCreate() {
		// 获取应用程序级的上下文对象
		context = getApplicationContext();
		// 设置自定义日志工具的全局显示
		LogUtil.LEVEL = LogUtil.NOTHING; // 隐藏全部
	}

	/**
	 * 在程序的任何地方 获取应用级的上下文对象
	 * 
	 * @return
	 */
	public static Context getContext() {
		return context;
	}
}
