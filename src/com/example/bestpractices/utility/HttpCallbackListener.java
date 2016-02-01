package com.example.bestpractices.utility;

public interface HttpCallbackListener {

	/**
	 * 响应完成
	 * 
	 * @param response
	 */
	void onFinish(String response);

	/**
	 * 响应失败
	 * 
	 * @param e
	 */
	void onError(Exception e);

}
