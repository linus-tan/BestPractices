package com.example.bestpractices.utility;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

/**
 * ���������������е�activityʵ������BaseActivity�е��ã�������ٹر�����activity��
 * 
 * @author linus
 * 
 */
public class ActivityCollector {

	public static List<Activity> activities = new ArrayList<Activity>();

	public static void addActivity(Activity activity) {
		if (!activities.contains(activity)) {
			activities.add(activity);
		}
	}

	public static void removeActivity(Activity activity) {
		activities.remove(activity);
	}

	/**
	 * ��������activity
	 */
	public static void finishAll() {
		for (Activity activity : activities) {
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
	}

}
