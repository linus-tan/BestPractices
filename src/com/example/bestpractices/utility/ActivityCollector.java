package com.example.bestpractices.utility;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

/**
 * 这个类用来存放所有的activity实例，在BaseActivity中调用，方便快速关闭所有activity等
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
	 * 结束所有activity
	 */
	public static void finishAll() {
		for (Activity activity : activities) {
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
	}

}
