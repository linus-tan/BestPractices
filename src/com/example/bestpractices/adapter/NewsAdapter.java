package com.example.bestpractices.adapter;

import java.util.List;

import com.example.bestpractices.R;
import com.example.bestpractices.model.News;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NewsAdapter extends ArrayAdapter<News> {

	private int itemResourceId;

	public NewsAdapter(Context context, int textViewResourceId,
			List<News> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		itemResourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		News news = getItem(position);
		View view;

		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(itemResourceId,
					null);
		} else {
			view = convertView;
		}

		TextView tv = (TextView) view.findViewById(R.id.news_title);
		tv.setText(news.getTitle());
		return view;
	}

}
