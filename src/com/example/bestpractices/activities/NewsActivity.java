package com.example.bestpractices.activities;

import com.example.bestpractices.R;
import android.os.Bundle;
import android.view.Window;

/**
 * ���������棬ֻ��setһ�����־Ϳ����ˣ����е��߼�����fragment����
 * @author linus
 *
 */
public class NewsActivity extends BaseActivity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
	}
}
