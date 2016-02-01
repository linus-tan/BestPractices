package com.example.bestpractices.activities;

import com.example.bestpractices.R;
import android.os.Bundle;
import android.view.Window;

/**
 * 新闻主界面，只需set一个布局就可以了，所有的逻辑都在fragment里了
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
