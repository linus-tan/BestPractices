package com.example.bestpractices.activities;

import java.util.ArrayList;
import java.util.List;

import com.example.bestpractices.R;
import com.example.bestpractices.adapter.MsgAdapter;
import com.example.bestpractices.model.Msg;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ChatActivity extends BaseActivity {

	private ListView msgListView;

	private EditText inputText;

	private Button send;

	private MsgAdapter adapter;

	private List<Msg> msgList = new ArrayList<Msg>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_chat_main);

		// ��ʼ����Ϣ
		initMsgs();
		adapter = new MsgAdapter(this, msgList);

		inputText = (EditText) findViewById(R.id.input_text);
		send = (Button) findViewById(R.id.send);
		msgListView = (ListView) findViewById(R.id.msg_list_view);
		msgListView.setAdapter(adapter);

		// ������Ϣ
		send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String content = inputText.getText().toString();
				if (!TextUtils.isEmpty(content)) {
					Msg msg = new Msg(content, Msg.TYPE_SENT);
					msgList.add(msg);
					// ����ListView
					adapter.notifyDataSetChanged();
					// ��ListView��λ�����һ��
					msgListView.setSelection(msgList.size());

					// ����ı���
					inputText.setText("");
				}
			}
		});

	}

	private void initMsgs() {
		// TODO Auto-generated method stub
		Msg msg1 = new Msg("Hello guy.", Msg.TYPE_RECEIVED);
		msgList.add(msg1);
		Msg msg2 = new Msg("Hello, who is that?", Msg.TYPE_SENT);
		msgList.add(msg2);
		Msg msg3 = new Msg("This is Tom. Nice talking to you.",
				Msg.TYPE_RECEIVED);
	}

}
