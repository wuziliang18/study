package org.wuzl.study.guava.collect;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimaps;

public class TestMultimaps {
	/**
	 * Maps.uniqueIndex的相似方法 支持一个key下的集合
	 */
	@Test
	public void shouldGetMultimapsFromList() {
		ImmutableSet<String> set = ImmutableSet.of("zero", "one", "two",
				"three", "four", "five", "six", "seven", "eight", "nine");
		ImmutableListMultimap<Integer, String> multiMap = Multimaps.index(set,
				new Function<String, Integer>() {

					@Override
					public Integer apply(String input) {
						return input.length();
					}
				});
		System.out.println(multiMap);
	}
}
