package com.example.bestpractices.service;

import java.util.Date;

import com.example.bestpractices.broadcastreceiver.AlarmReceiver;

import android.R.integer;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

/**
 * 展示一个在后台长时间运行的服务，需要在一个位置启动该服务才能开始常驻运行
 * 
 * @author linus
 * 
 */
public class LongRuningService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		// 新线程里是要执行的任务
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Log.d("LongRuningService",
						"executed at " + new Date().toString());
			}
		}).start();

		// 以下代码用于每隔指定时间启动发送一个广播
		// 闹钟服务
		AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
		// 一个小时的毫秒数
		int anHour = 60 * 60 * 1000;
		// 开机逝去的毫秒数+1小时
		long triggerAtTime = SystemClock.elapsedRealtime() + anHour;

		// 设置一个隐式意图，到时发送一个广播
		Intent i = new Intent(this, AlarmReceiver.class);
		PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
		// 此方法使Alarm任务变得不是很准确，有可能会延迟一点时间才会执行
		// 如果需要准确执行则使用setExact()代替set()
		manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);

		return super.onStartCommand(intent, flags, startId);
	}

}
