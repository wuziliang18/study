package org.wuzl.study.guava.collect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.wuzl.study.guava.base.Person;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

/**
 * 使用ComparisonChain排序
 * ComparisonChain是顺序的前边通过后边不在比较 复杂情况使用Ordering
 * Ordering是从后向前比较的
 * 
 * @author wuzl
 *
 */
public class TestComparisonChain {
	public static void main(String[] args) {
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
		person = new Person();
		person.setSex((short) 1);
		person.setId(4);
		person.setName(null);
		person.setBirthDay(19870222);
		rows.add(person);
		System.out.println(">>>");
		for (Person person1 : rows) {
			System.out.println(person1);
		}
		System.out.println(">>>>>");
		// 排序
		Collections.sort(rows, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return ComparisonChain
						.start()
						.compare(o1.getBirthDay(), o2.getBirthDay())
						.compare(o1.getSex(), o2.getSex())
						// 对null的排序 如果有复杂排序使用Ordering
						.compare(o1.getName(), o2.getName(),
								Ordering.natural().nullsLast()).result();
			}
		});
		System.out.println(">>>");
		for (Person person1 : rows) {
			System.out.println(person1);
		}
		System.out.println(">>>>>");
	}
}
