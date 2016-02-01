package com.example.bestpractices.utility;

import android.app.Application;
import android.content.Context;

/**
 * �Զ����Application
 * 
 * @author linus
 * 
 */
public class MyApplication extends Application {

	private static Context context;

	@Override
	public void onCreate() {
		// ��ȡӦ�ó��򼶵������Ķ���
		context = getApplicationContext();
		// �����Զ�����־���ߵ�ȫ����ʾ
		LogUtil.LEVEL = LogUtil.NOTHING; // ����ȫ��
	}

	/**
	 * �ڳ�����κεط� ��ȡӦ�ü��������Ķ���
	 * 
	 * @return
	 */
	public static Context getContext() {
		return context;
	}
}
