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
 * 聊天窗口adapter
 * 
 * @author linus
 * 
 */
public class MsgAdapter extends ArrayAdapter<Msg> {

	/**
	 * 聊天条目布局id
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

		// ArrayAdapter类 已经包含了 实体集合的处理的逻辑
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

			// 保存到view
			view.setTag(viewHolder);
		} else {
			// 将可复用的view 赋值出来
			view = convertView;
			// 取出保存在view中tag
			viewHolder = (ViewHolder) view.getTag();
		}

		// 注意：这里的控件都是对viewHolder的操作
		if (msg.getType() == Msg.TYPE_RECEIVED) {
			// 如果是收到的消息，则显示左边的消息布局，将右边的消息布局隐藏
			viewHolder.leftLayout.setVisibility(View.VISIBLE);
			viewHolder.rightLayout.setVisibility(View.GONE);
			viewHolder.leftMsg.setText(msg.getContent());
		} else if (msg.getType() == Msg.TYPE_SENT) {
			// 如果是发出的消息，则显示右边的消息布局，将左边的消息布局隐藏
			viewHolder.leftLayout.setVisibility(View.GONE);
			viewHolder.rightLayout.setVisibility(View.VISIBLE);
			viewHolder.rightMsg.setText(msg.getContent());
		}

		return view;
	}

}
