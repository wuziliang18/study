package org.wuzl.study.guava.base;

import java.util.ArrayList;
import java.util.List;

public class PersonHelper {
	public static List<Person> getPersonList() {
		List<Person> rows = new ArrayList<Person>();
		Person person = new Person();
		person.setSex((short) 1);
		person.setId(1);
		person.setName("wuzl");
		person.setBirthDay(19871222);
		rows.add(person);
		person = new Person();
		person.setSex((short) 1);
		person.setId(3);
		person.setName("zhangmoumou");
		person.setBirthDay(19871223);
		rows.add(person);
		person = new Person();
		person.setSex((short) 2);
		person.setId(2);
		person.setName("zhaomoumou");
		person.setBirthDay(19871222);
		rows.add(person);
		person = new Person();
		person.setSex((short) 1);
		person.setId(4);
		person.setName("chengmoumou");
		person.setBirthDay(19870222);
		rows.add(person);
		return rows;
	}

}
