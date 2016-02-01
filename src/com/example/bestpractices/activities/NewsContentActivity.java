package com.example.bestpractices.activities;

import com.example.bestpractices.R;
import com.example.bestpractices.fragments.NewsContentFragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class NewsContentActivity extends BaseActivity {

	public static void actionStart(Context context, String newsTitle,
			String newsContent) {
		Intent intent = new Intent(context, NewsContentActivity.class);
		intent.putExtra("news_title", newsTitle);
		intent.putExtra("news_content", newsContent);
		context.startActivity(intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_news_content);

		Intent intent = getIntent();
		// 获取传入的新闻标题
		String newsTitle = intent.getStringExtra("news_title");
		// 获取传入的新闻内容
		String newsContent = intent.getStringExtra("news_content");

		NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager()
				.findFragmentById(R.id.news_content_fragment);

		// 刷新新闻内容页面
		newsContentFragment.refresh(newsTitle, newsContent);
	}
}
