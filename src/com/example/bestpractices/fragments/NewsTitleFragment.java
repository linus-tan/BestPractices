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
 * Fragment��ͨ��getActivity()�ж��ǵ�ҳ��ʾ����˫ҳ��ʾ
 * 
 * @author linus
 * 
 */
public class NewsTitleFragment extends Fragment {

	private ListView newsTitleListView;

	private List<News> newsList;

	private NewsAdapter adapter;

	/**
	 * �Ƿ�˫ҳ��ʾ
	 */
	private boolean isTwoPane;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		// ��ʼ����������
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
					//����һ��fragment�����ֱ�Ӳ�����һ��fragment
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

		// �ҵ���������������Ϊ�������񣬷���Ϊһ������
		if (getActivity().findViewById(R.id.news_content_layout) != null) {
			isTwoPane = true;
		} else {
			isTwoPane = false;
		}
	}

	private List<News> getNews() {

		List<News> newsList = new ArrayList<News>();
		News news1 = new News();
		news1.setTitle("�ձ���������9�����š� ��ý��Ӧ���й��ڶ����Ļ");
		news1.setContent("���ձ���ͬ�籨����Ϊ��ǿ��������ķ����������ձ�����������1��31����λ�ڳ������ǰ��е��ǰԻ��س�������9�����š����շ��������������õ����ڼ�����ʽ�����Ա��ѵ���ƣ������ϵ����ķ���̬�Ƶõ��˽�һ��ǿ����(������)��������ǰ�ߡ�ϣ����Ҵ��Ž��ȸ�ִ�����񡣡���ͬ������˵���˾�ּ��Ӧ���й��ڶ����Ļ��");
		newsList.add(news1);

		News news2 = new News();
		news2.setTitle("�㽭��Ժ�����������ɱ�ˡ��Ż� ����������� ");
		news2.setContent("��������2��1�յ� ���㽭ʡ�߼�����Ժ�ٷ�΢����Ϣ��2016��2��1�գ��㽭ʡ�߼�����Ժ�����Գ�������ɱ�ˡ��Ż����󰸹������У�����ԭ����У�����������1992��12��25�գ�����ʡ�����й������񶫷־ֽӱ���������8ʱ���ں��������������´�109�ŷ��������֣�Ⱥ�ڼ�������Ա�ھȻ�ʱ������������һ��ʬ�壬ʬ���������ˣ������������е�ɱ�ۼ��������д���Ѫ����������������飬����Ϊ�������������϶��������Ĵ�ʡ���ؼ�������Ϊ��");
		newsList.add(news2);

		return newsList;

	}
}
