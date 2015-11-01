package com.leo.xmly.bean;

import com.leo.xmly.interf.ListTypeInterf;

/**
 * 热门直播
 * 
 * @author Leo
 *
 */
public class Type4RMZB implements ListTypeInterf {

	private String title;
	private String coverPath;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCoverPath() {
		return coverPath;
	}

	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}

	@Override
	public int getType() {
		return 3;
	}

}
