package com.example.bestpractices.broadcastreceiver;

import com.example.bestpractices.activities.Test1Activity;
import com.example.bestpractices.utility.ActivityCollector;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

/**
 * 强制下线广播接收者
 * @author linus
 *
 */
public class ForceOfflineReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(final Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		//弹出对话框的基本设置
		AlertDialog.Builder dialogBuilder = new Builder(context);
		dialogBuilder.setTitle("Warning");
		dialogBuilder.setMessage("You are forced to be offline. Please try to login again.");
		//不允许取消
		dialogBuilder.setCancelable(false);
		
		dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				//销毁所有活动
				ActivityCollector.finishAll();
				
				//打开应用的第一屏activity
				Intent intent = new Intent(context, Test1Activity.class);
				//使用一个新的任务栈启动
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(intent);
			}
		});
		
		//创建对话框
		AlertDialog alertDialog = dialogBuilder.create();
		
		
		//需要设置alertDialog为系统类型，保证在广播接收器中可以正常弹出
		//一个系统弹窗需要在清单文件中设置权限
		alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		
		alertDialog.show();
	}

}
