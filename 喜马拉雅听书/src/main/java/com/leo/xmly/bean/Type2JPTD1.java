package com.leo.xmly.bean;

import java.util.List;

import com.leo.xmly.interf.ListTypeInterf;

/**
 * 精品听单类型之后装到list中去
 * 
 * @author Leo
 *
 */
public class Type2JPTD1 implements ListTypeInterf {
	private String title;
	private List<Type2JPTD2> list;

	public List<Type2JPTD2> getList() {
		return list;
	}

	public void setList(List<Type2JPTD2> list) {
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
		return 1;
	}

}
