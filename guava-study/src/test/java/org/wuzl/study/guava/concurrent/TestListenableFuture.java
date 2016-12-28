package org.wuzl.study.guava.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class TestListenableFuture {
	private ListeningExecutorService executorService;

	@Before
	public void init() {
		executorService = MoreExecutors.listeningDecorator(Executors
				.newFixedThreadPool(10));
	}

	@Test
	public void shouldCallBack() {
		ListenableFuture<String> future = executorService
				.submit(new Callable<String>() {

					@Override
					public String call() throws Exception {
//						throw new RuntimeException("fff");
						return "123";
					}

				});
		Futures.addCallback(future, new FutureCallback<String>() {

			@Override
			public void onSuccess(String result) {
				assertEquals(result, "123");;
			}

			@Override
			public void onFailure(Throwable t) {
				assertTrue("出现异常"+t.getMessage(),false);
				t.printStackTrace();
			}

		});
	}
}
