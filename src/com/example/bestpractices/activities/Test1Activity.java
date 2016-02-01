package com.example.bestpractices.activities;

import com.example.bestpractices.model.Msg;
import com.example.bestpractices.model.Person;
import com.example.bestpractices.utility.ActivityCollector;
import com.example.bestpractices.utility.HttpCallbackListener;
import com.example.bestpractices.utility.HttpUtil;
import com.example.bestpractices.utility.LogUtil;
import com.example.bestpractices.utility.MyApplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Test1Activity extends BaseActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 打印任务栈id
		LogUtil.d("Test1Activity", "Task Id is" + getTaskId());
		// 装载布局
		// setContentView(layoutResID);

		// 关闭所有activity
		Button button1 = new Button(this);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// 关闭所有activity
				ActivityCollector.finishAll();
				// 可以在销毁所有活动的代码后再加上杀掉当前进程的代码，以保证程序完全退出
			}
		});

		// 启动Test2Activity
		Button button2 = new Button(this);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// 启动Test2Activity，通过后置的代码调用
				// 并展示两种方式传递对象，其中Parcelable虽实现复杂但更加高效
				Msg msg = new Msg("1", Msg.TYPE_SENT);
				Person person = new Person();
				person.setAge(26);
				person.setName("linus");
				Test2Activity.actionStart(Test1Activity.this, "你", "好", msg,
						person);

			}
		});

		// 触发强制下线的按钮，实则发送一个广播，这样在程序的任一位置都可以强制下线了
		Button forceOffline = new Button(this);
		forceOffline.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// 设置action
				Intent intent = new Intent(
						"com.example.broadcastbestpractice.FORCE_OFFLINE");
				sendBroadcast(intent);
			}
		});

		// 发送一个Http get请求的示例
		Button sendRequestButton = new Button(this);
		sendRequestButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				HttpUtil.sendHttpRequest("http://www.linus.org",
						new HttpCallbackListener() {

							// 注意：这些方法仍是在子线程内的，不能用来直接更新UI
							@Override
							public void onFinish(String response) {
								// TODO Auto-generated method stub
								// 在这里根据返回内容执行具体的逻辑
							}

							@Override
							public void onError(Exception e) {
								// TODO Auto-generated method stub
								// 在这里对异常情况进行处理
							}
						});
			}
		});

		// 在程序任意位置获取应用程序级的上下文对象
		Button getAppContext = new Button(this);
		getAppContext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MyApplication.getContext();
			}
		});
	}

}
