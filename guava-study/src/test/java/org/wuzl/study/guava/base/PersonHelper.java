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
		person.setBirthDay(19871223);
		rows.add(person);
		person = new Person();
		person.setSex((short) 1);
		person.setId(4);
		person.setName("chengmoumou");
		person.setBirthDay(19870222);
		rows.add(person);
		person = new Person();
		person.setSex((short) 1);
		person.setId(5);
		person.setName("zhangmoumou");
		person.setBirthDay(19860222);
		rows.add(person);
		person = new Person();
		person.setSex((short) 1);
		person.setId(6);
		person.setName("limoumou");
		person.setBirthDay(19880222);
		rows.add(person);

		person = new Person();
		person.setSex((short) 1);
		person.setId(7);
		person.setName("shimoumou");
		person.setBirthDay(19810222);
		rows.add(person);
		person = new Person();
		person.setSex((short) 2);
		person.setId(8);
		person.setName("wangmoumou");
		person.setBirthDay(19890222);
		rows.add(person);
		person = new Person();
		person.setSex((short) 2);
		person.setId(9);
		person.setName("manmoumou");
		person.setBirthDay(19870116);
		rows.add(person);
		person = new Person();
		person.setSex((short) 2);
		person.setId(10);
		person.setName("liumoumou");
		person.setBirthDay(19870101);
		rows.add(person);
		return rows;
	}

}
