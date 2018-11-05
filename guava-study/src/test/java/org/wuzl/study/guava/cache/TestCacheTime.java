package org.wuzl.study.guava.cache;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

public class TestCacheTime {
	private static class MyRemovalListener implements RemovalListener<String, String> {
		@Override
		public void onRemoval(RemovalNotification<String, String> notification) {
			// 超时不会被触发 因为超时后数据不会马上删除
			String tips = String.format("key=%s,value=%s,reason=%s", notification.getKey(), notification.getValue(),
					notification.getCause());
			System.out.println(tips);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Cache<String, String> cache = CacheBuilder.newBuilder().expireAfterAccess(5, TimeUnit.SECONDS)
				.removalListener(new MyRemovalListener()).build();
		cache.put("useradmin", "系统用户");
		System.out.println(cache.getIfPresent("useradmin"));
		Thread.sleep(10000l);
		System.out.println(cache.getIfPresent("useradmin"));
	}
}
