package com.example.bestpractices.adapter;

import java.util.List;

import com.example.bestpractices.R;
import com.example.bestpractices.model.Msg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * ���촰��adapter
 * 
 * @author linus
 * 
 */
public class MsgAdapter extends ArrayAdapter<Msg> {

	/**
	 * ������Ŀ����id
	 */
	private final static int itemResourceId = R.layout.item_msg;

	public MsgAdapter(Context context, List<Msg> objects) {
		super(context, itemResourceId, objects);
	}

	class ViewHolder {
		LinearLayout leftLayout;
		LinearLayout rightLayout;
		TextView leftMsg;
		TextView rightMsg;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// ArrayAdapter�� �Ѿ������� ʵ�弯�ϵĴ�����߼�
		Msg msg = getItem(position);

		View view;
		ViewHolder viewHolder;

		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(itemResourceId,
					null);

			viewHolder = new ViewHolder();
			viewHolder.leftLayout = (LinearLayout) view
					.findViewById(R.id.left_layout);
			viewHolder.rightLayout = (LinearLayout) view
					.findViewById(R.id.right_layout);
			viewHolder.leftMsg = (TextView) view.findViewById(R.id.left_msg);
			viewHolder.rightMsg = (TextView) view.findViewById(R.id.right_msg);

			// ���浽view
			view.setTag(viewHolder);
		} else {
			// ���ɸ��õ�view ��ֵ����
			view = convertView;
			// ȡ��������view��tag
			viewHolder = (ViewHolder) view.getTag();
		}

		// ע�⣺����Ŀؼ����Ƕ�viewHolder�Ĳ���
		if (msg.getType() == Msg.TYPE_RECEIVED) {
			// ������յ�����Ϣ������ʾ��ߵ���Ϣ���֣����ұߵ���Ϣ��������
			viewHolder.leftLayout.setVisibility(View.VISIBLE);
			viewHolder.rightLayout.setVisibility(View.GONE);
			viewHolder.leftMsg.setText(msg.getContent());
		} else if (msg.getType() == Msg.TYPE_SENT) {
			// ����Ƿ�������Ϣ������ʾ�ұߵ���Ϣ���֣�����ߵ���Ϣ��������
			viewHolder.leftLayout.setVisibility(View.GONE);
			viewHolder.rightLayout.setVisibility(View.VISIBLE);
			viewHolder.rightMsg.setText(msg.getContent());
		}

		return view;
	}

}
