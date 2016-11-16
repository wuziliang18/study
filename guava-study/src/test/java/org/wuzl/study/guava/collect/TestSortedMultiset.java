package org.wuzl.study.guava.collect;

import java.util.List;

import org.wuzl.study.guava.base.Person;
import org.wuzl.study.guava.base.PersonHelper;

import com.google.common.collect.BoundType;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.TreeMultiset;

/**
 * SortedMultiset 增强的Multiset支持高效地获取指定范围的子集 查找1987年出生的
 * 注意如果 compareTo方法返回0 表明是一条记录
 * @author wuzl
 *
 */
public class TestSortedMultiset {
	public static void main(String[] args) {
		List<Person> persons = PersonHelper.getPersonList();
		SortedMultiset<Person> multiset = TreeMultiset.create();
		multiset.addAll(persons);
		// 查找1987年出生的 
		Person start = new Person();
		start.setBirthDay(19870101);
		Person end = new Person();
		end.setBirthDay(19871231);
		SortedMultiset<Person> result = multiset.subMultiset(start,
				BoundType.CLOSED, end, BoundType.CLOSED);
		System.out.println(">>>");
		for (Person person1 : result) {
			System.out.println(person1);
		}
		System.out.println(">>>>>");
	}

}
