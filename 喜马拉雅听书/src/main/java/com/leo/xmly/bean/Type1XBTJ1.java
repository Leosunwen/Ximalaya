package com.leo.xmly.bean;

import java.util.List;

import com.leo.xmly.interf.ListTypeInterf;

/**
 * 小编推荐总的JavaBean
 * 
 * @author Leo
 *
 */
public class Type1XBTJ1 implements ListTypeInterf {
	private String title;
	private List<Type1XBTJ2> list;

	public List<Type1XBTJ2> getList() {
		return list;
	}

	public void setList(List<Type1XBTJ2> list) {
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
		return 0;
	}
}
