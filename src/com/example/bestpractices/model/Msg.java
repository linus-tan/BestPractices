package com.example.bestpractices.model;

import java.io.Serializable;

/**
 * 聊天消息实体 这个实体用于展示Serializable传递方式
 * 
 * @author linus
 * 
 */
public class Msg implements Serializable {

	public static final int TYPE_RECEIVED = 0;

	public static final int TYPE_SENT = 1;

	private String content;

	private int type;

	public Msg(String content, int type) {
		this.content = content;
		this.type = type;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

}
