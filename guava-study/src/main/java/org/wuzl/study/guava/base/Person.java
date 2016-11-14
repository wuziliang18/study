package org.wuzl.study.guava.base;

import com.google.common.base.MoreObjects;

public class Person {
	private long id;
	private short sex;
	private String name;
	private long birthDay;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public short getSex() {
		return sex;
	}

	public void setSex(short sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(long birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", id).add("name", name)
				.add("sex", sex).addValue(birthDay).toString();
	}

}
