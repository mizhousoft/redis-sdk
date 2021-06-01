package com.mizhousoft.redis.lettuce.command;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mizhousoft.redis.lettuce.RedisClientInitializer;
import com.mizhousoft.redis.lettuce.client.LettuceRedisClient;

/**
 * TestLettuceStringCommand Test
 *
 * @version
 */
public class TestLettuceStringCommand
{
	LettuceRedisClient redisClient;

	@Before
	public void before()
	{
		this.redisClient = RedisClientInitializer.build();
	}

	@Test
	public void testSet() throws InterruptedException
	{
		String key = "testSet";
		String value = "value";

		redisClient.getStringCommand().set(key, value);

		String result = redisClient.getStringCommand().get(key);
		Assert.assertEquals(value, result);

		redisClient.del(key);

		redisClient.getStringCommand().setex(key, value, 2);
		result = redisClient.getStringCommand().get(key);
		Assert.assertEquals(value, result);

		TimeUnit.SECONDS.sleep(2);

		result = redisClient.getStringCommand().get(key);
		Assert.assertEquals(null, result);
	}

	@Test
	public void testMultiSet() throws InterruptedException
	{
		String key1 = "testMultiSet1";
		String value1 = "value1";

		Map<String, String> values = new HashMap<>(10);
		values.put(key1, value1);

		String key2 = "testMultiSet2";
		String value2 = "value2";
		values.put(key2, value2);

		redisClient.getStringCommand().mset(values);

		String[] keys = { key1, key2 };
		Map<String, String> resultMap = redisClient.getStringCommand().mget(keys);
		Assert.assertEquals(value1, resultMap.get(key1));
		Assert.assertEquals(value2, resultMap.get(key2));

		redisClient.del(key1, key2);

		String result = redisClient.getStringCommand().get(key2);
		Assert.assertEquals(null, result);
	}

	@Test
	public void testIncrement() throws InterruptedException
	{
		String key = "testIncrement";

		long result = redisClient.getStringCommand().incr(key, 2);
		Assert.assertEquals(2, result);

		result = redisClient.getStringCommand().decrby(key, 3);
		Assert.assertEquals(-1, result);

		redisClient.del(key);
	}
}
