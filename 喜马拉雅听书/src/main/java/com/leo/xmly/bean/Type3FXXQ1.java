package com.leo.xmly.bean;

import java.util.List;

import com.leo.xmly.interf.ListTypeInterf;

/**
 * 发现新奇类型
 * 
 * @author Leo
 *
 */
public class Type3FXXQ1 implements ListTypeInterf {
	private String title;
	private List<Type3FXXQ2> list;

	public List<Type3FXXQ2> getList() {
		return list;
	}

	public void setList(List<Type3FXXQ2> list) {
		this.list = list;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int getType() {
		return 2;
	}

}
