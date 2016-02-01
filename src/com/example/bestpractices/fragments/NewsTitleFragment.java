package com.example.bestpractices.fragments;

import java.util.ArrayList;
import java.util.List;

import com.example.bestpractices.R;
import com.example.bestpractices.activities.NewsContentActivity;
import com.example.bestpractices.adapter.NewsAdapter;
import com.example.bestpractices.model.News;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * Fragment中通过getActivity()判断是单页显示还是双页显示
 * 
 * @author linus
 * 
 */
public class NewsTitleFragment extends Fragment {

	private ListView newsTitleListView;

	private List<News> newsList;

	private NewsAdapter adapter;

	/**
	 * 是否双页显示
	 */
	private boolean isTwoPane;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		// 初始化新闻数据
		newsList = getNews();
		adapter = new NewsAdapter(activity, R.layout.item_news, newsList);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_news_title, container);

		ListView lv = (ListView) view.findViewById(R.id.news_title_list_view);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				News news = newsList.get(position);
				if (isTwoPane) {
					//在另一个fragment里可以直接查找另一个fragment
					NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager()
							.findFragmentById(R.id.news_content_fragment);
					newsContentFragment.refresh(news.getTitle(),
							news.getContent());
				} else {
					NewsContentActivity.actionStart(getActivity(),
							news.getTitle(), news.getContent());
				}
			}
		});

		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		// 找到新闻内容容器即为两个窗格，否则为一个窗格
		if (getActivity().findViewById(R.id.news_content_layout) != null) {
			isTwoPane = true;
		} else {
			isTwoPane = false;
		}
	}

	private List<News> getNews() {

		List<News> newsList = new ArrayList<News>();
		News news1 = new News();
		news1.setTitle("日本成立“第9航空团” 日媒：应对中国在东海的活动");
		news1.setContent("据日本共同社报道，为了强化西南诸岛的防卫能力，日本航空自卫队1月31日在位于冲绳县那霸市的那霸基地成立“第9航空团”。日防卫副大臣若宫健嗣当天在纪念仪式上向队员们训话称：“西南地区的防空态势得到了进一步强化。(这里是)国防的最前线。希望大家带着紧迫感执行任务。”共同社评论说，此举旨在应对中国在东海的活动。");
		newsList.add(news1);

		News news2 = new News();
		news2.setTitle("浙江高院再审陈满故意杀人、放火案 宣告陈满无罪 ");
		news2.setContent("　中新网2月1日电 据浙江省高级人民法院官方微博消息，2016年2月1日，浙江省高级人民法院依法对陈满故意杀人、放火再审案公开宣判，撤销原审裁判，宣告陈满无罪。1992年12月25日，海南省海口市公安局振东分局接报，当日晚8时许在海口市振东区上坡下村109号房发生火灾，群众及消防队员在救火时，发现屋内有一具尸体，尸体大面积烧伤，颈部和身上有刀杀痕迹，屋内有大量血迹。经公安机关侦查，死者为被害人钟作宽，认定本案是四川省富县籍陈满所为。");
		newsList.add(news2);

		return newsList;

	}
}
