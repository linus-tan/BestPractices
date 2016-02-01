package com.example.bestpractices.broadcastreceiver;

import com.example.bestpractices.service.LongRuningService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 用于到达时间间隔 重新启动服务
 * @author linus
 *
 */
public class AlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Intent i = new Intent(context, LongRuningService.class);
		context.startService(i);
	}

}
