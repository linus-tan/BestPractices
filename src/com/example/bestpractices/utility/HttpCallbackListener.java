package com.example.bestpractices.utility;

public interface HttpCallbackListener {

	/**
	 * ��Ӧ���
	 * 
	 * @param response
	 */
	void onFinish(String response);

	/**
	 * ��Ӧʧ��
	 * 
	 * @param e
	 */
	void onError(Exception e);

}
