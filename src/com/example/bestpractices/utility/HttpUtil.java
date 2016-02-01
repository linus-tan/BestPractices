package com.example.bestpractices.utility;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {

	public static void sendHttpRequest(final String address,
			final HttpCallbackListener listener) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				HttpURLConnection connection = null;
				try {
					URL url = new URL(address);
					connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setReadTimeout(8000);
					connection.setDoInput(true);
					connection.setDoOutput(true);

					// ��ȡ��Ӧ��
					InputStream in = connection.getInputStream();
					// �����Ķ�
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(in));
					StringBuilder response = new StringBuilder();

					// ���ж�ȡ
					String line;
					while ((line = reader.readLine()) != null) {
						response.append(line);
					}

					if (listener != null) {
						// ��Ӧ�ַ���������ɣ��ص�
						listener.onFinish(response.toString());
					}

				} catch (Exception e) {
					if (listener != null) {
						// ��Ӧ�ַ���������ɣ��ص�
						listener.onError(e);
					}
				} finally {
					if (connection != null) {
						connection.disconnect();
					}
				}
			}
		}).start();
	}
}
