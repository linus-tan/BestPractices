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
 * չʾһ���ں�̨��ʱ�����еķ�����Ҫ��һ��λ�������÷�����ܿ�ʼ��פ����
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

		// ���߳�����Ҫִ�е�����
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Log.d("LongRuningService",
						"executed at " + new Date().toString());
			}
		}).start();

		// ���´�������ÿ��ָ��ʱ����������һ���㲥
		// ���ӷ���
		AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
		// һ��Сʱ�ĺ�����
		int anHour = 60 * 60 * 1000;
		// ������ȥ�ĺ�����+1Сʱ
		long triggerAtTime = SystemClock.elapsedRealtime() + anHour;

		// ����һ����ʽ��ͼ����ʱ����һ���㲥
		Intent i = new Intent(this, AlarmReceiver.class);
		PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
		// �˷���ʹAlarm�����ò��Ǻ�׼ȷ���п��ܻ��ӳ�һ��ʱ��Ż�ִ��
		// �����Ҫ׼ȷִ����ʹ��setExact()����set()
		manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);

		return super.onStartCommand(intent, flags, startId);
	}

}
