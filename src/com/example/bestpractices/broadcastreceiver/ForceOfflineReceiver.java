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
 * ǿ�����߹㲥������
 * @author linus
 *
 */
public class ForceOfflineReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(final Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		//�����Ի���Ļ�������
		AlertDialog.Builder dialogBuilder = new Builder(context);
		dialogBuilder.setTitle("Warning");
		dialogBuilder.setMessage("You are forced to be offline. Please try to login again.");
		//������ȡ��
		dialogBuilder.setCancelable(false);
		
		dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				//�������л
				ActivityCollector.finishAll();
				
				//��Ӧ�õĵ�һ��activity
				Intent intent = new Intent(context, Test1Activity.class);
				//ʹ��һ���µ�����ջ����
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(intent);
			}
		});
		
		//�����Ի���
		AlertDialog alertDialog = dialogBuilder.create();
		
		
		//��Ҫ����alertDialogΪϵͳ���ͣ���֤�ڹ㲥�������п�����������
		//һ��ϵͳ������Ҫ���嵥�ļ�������Ȩ��
		alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		
		alertDialog.show();
	}

}
