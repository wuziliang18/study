package org.wuzl.study.guava.collect;

import com.google.common.collect.ImmutableSet;

/**
 * Immutable开头的都是不可便集合线程安全 of copyOf builder 三种创建方式
 * 
 * @author wuzl
 *
 */
public class TestImmutableSet {
	public static void main(String[] args) {
		ImmutableSet<Integer> set = ImmutableSet.of(1, 2);
	}
}
