package org.wuzl.study.guava.collect;

import java.util.List;

import org.wuzl.study.guava.base.Person;
import org.wuzl.study.guava.base.PersonHelper;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;

/**
 * Ordering的一些现有排序
 * 
 * @author wuzl
 *
 */
public class TestOrdering {

	public static void main(String[] args) {
		List<Person> rows = PersonHelper.getPersonList();
//		// 获取最大年纪的 需要person 实现排序接口
//		Ordering<Person> ordering=Ordering.natural().onResultOf(new Function<String, Comparable>() {
//
//			@Override
//			public Comparable apply(String input) {
//				return null;
//			}
//		});
//		Person maxAge=ordering.greatestOf(rows.iterator(), 1);
	}
}
