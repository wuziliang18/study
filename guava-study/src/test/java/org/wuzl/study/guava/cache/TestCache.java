package org.wuzl.study.guava.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class TestCache {
	@Test
	public void testBase() {
		LoadingCache<String, String> cache = CacheBuilder.newBuilder()
				.maximumSize(100).expireAfterWrite(10, TimeUnit.MINUTES)
				.build(new CacheLoader<String, String>() {

					@Override
					public String load(String key) throws Exception {
						return key + "_cache";
					}

				});
		try {
			assertEquals(cache.get(("user1")), "user1_cache");
		} catch (ExecutionException e) {
			e.printStackTrace();
		}// 要处理检查异常
		cache.put("user1", "第一个用户");
		assertEquals(cache.getUnchecked(("user1")), "第一个用户");// 不用检查异常
	}

	/**
	 * 不使用CacheLoader
	 */
	@Test
	public void shouldGetByCallable() {
		// 没有使用自动缓存加载的
		Cache<String, String> cache = CacheBuilder.newBuilder()
				.maximumSize(100).expireAfterWrite(10, TimeUnit.MINUTES)
				.build();
		assertNull(cache.getIfPresent("user1_cache"));
		try {
			assertEquals(cache.get("user1_cache", new Callable<String>() {

				@Override
				public String call() throws Exception {
					return "第一个用户";
				}
			}), "第一个用户");
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		assertEquals(cache.getIfPresent("user1_cache"), "第一个用户");
	}

	/**
	 * 定时回收 expireAfterAccess(long, TimeUnit)：缓存项在给定时间内没有被读/写访问，则回收
	 * expireAfterWrite(long, TimeUnit)：缓存项在给定时间内没有被写访问（创建或覆盖），则回收
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void shouldTimedEvictionCache() throws InterruptedException {
		Cache<String, String> cache = CacheBuilder.newBuilder()
				.expireAfterAccess(10, TimeUnit.SECONDS).build();// 10秒钟没有读写超时
		assertNull(cache.getIfPresent("useradmin"));
		cache.put("useradmin", "系统用户");
		assertEquals(cache.getIfPresent("useradmin"), "系统用户");
		assertNull(cache.getIfPresent("user1"));
		cache.put("user1", "第一个用户");
		assertEquals(cache.getIfPresent("user1"), "第一个用户");
		assertEquals(cache.getIfPresent("useradmin"), "系统用户");// 刷新缓存
		Thread.sleep(5 * 1000l);
		// assertEquals(cache.getIfPresent("user1"), "第一个用户");// 依然有效
		// 因为使用了expireAfterAccess 这里会刷新
		cache.put("user2", "第二个用户");// 放入第二个缓存
		assertEquals(cache.getIfPresent("useradmin"), "系统用户");// 刷新缓存
		Thread.sleep(5 * 1000l);
		assertEquals(cache.getIfPresent("useradmin"), "系统用户");// 刷新缓存
		// assertEquals(cache.getIfPresent("user2"), "第二个用户");
		// //因为使用了expireAfterAccess 这里会刷新
		assertNull(cache.getIfPresent("user1"));// 第一个失效
		// assertEquals(cache.getIfPresent("user2"), "第二个用户");// 第二个有效
		// 因为使用了expireAfterAccess 这里会刷新
		Thread.sleep(5 * 1000l);
		assertNull(cache.getIfPresent("user2"));// 第二个失效
		assertEquals(cache.getIfPresent("useradmin"), "系统用户");// 刷新缓存
		Thread.sleep(10 * 1000l);
		assertNull(cache.getIfPresent("useradmin"));
	}
}
