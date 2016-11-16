package org.wuzl.study.guava.collect;

import org.junit.Test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import static org.junit.Assert.*;

/**
 * BiMap是特俗的map实现键值对的双向映射 注意values会是set value也不允许重复
 * 
 * @author wuzl
 *
 */
public class TestBiMap {

	@Test
	public void shoulePutAndGet() {
		BiMap<Integer, String> userMap = HashBiMap.create();
		userMap.put(1, "用户1");
		userMap.put(2, "用户2");
		userMap.put(3, "用户3");
		try {
			userMap.put(4, "用户3");
			assertTrue(false);
		} catch (Exception e) {
			System.out.println("会报错");
			assertTrue(true);
		}
		// 如果value一致 强制
		userMap.forcePut(5, "用户3");
		assertEquals(userMap.get(1), "用户1");
		assertTrue(userMap.inverse().get("用户1") == 1);
		assertTrue(userMap.inverse().get("用户3") == 5);
	}
}
