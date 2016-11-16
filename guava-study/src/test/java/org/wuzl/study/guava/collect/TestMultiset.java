package org.wuzl.study.guava.collect;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * Multiset允许重复 对重复计数 
 * HashMultiset 判断元素相等的时候用equals
 * TreeMultiset在判断元素是否相等时，与TreeSet一样用compare，而不是Object.equals
 * LinkedHashMultiset
 * ConcurrentHashMultiset
 * ImmutableMultiset
 * @author wuzl
 *
 */
public class TestMultiset {
	public static void main(String[] args) {
		Multiset<String> set = HashMultiset.create();
		set.add("a");
		set.add("a");
		set.add("a");
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("b");
		System.out.println(set.count("a"));
		System.out.println(set.count("b"));
		System.out.println(set.count("c"));
		System.out.println(set.count("d"));
	}
}
