package com.mizhousoft.redis.lettuce.command;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mizhousoft.redis.command.KeyCommand;
import com.mizhousoft.redis.lettuce.RedisClientInitializer;
import com.mizhousoft.redis.lettuce.client.LettuceRedisClient;

/**
 * LettuceKeyCommand Test
 *
 * @version
 */
public class TestLettuceKeyCommand
{
	LettuceRedisClient redisClient;

	@Before
	public void before()
	{
		this.redisClient = RedisClientInitializer.build();
	}

	@Test
	public void testExists()
	{
		String key = "testExists";
		String value = "value";

		redisClient.getStringCommand().set(key, value);

		boolean result = redisClient.exists(key);
		Assert.assertTrue(result);

		redisClient.del(key);

		result = redisClient.exists(key);
		Assert.assertFalse(result);
	}

	@Test
	public void testExpire() throws InterruptedException
	{
		String key = "testExpire";
		String value = "value";

		redisClient.getStringCommand().set(key, value);

		boolean result = redisClient.exists(key);
		Assert.assertTrue(result);

		redisClient.expire(key, 3);

		TimeUnit.SECONDS.sleep(4);

		result = redisClient.exists(key);
		Assert.assertFalse(result);
	}

	@Test
	public void testExpireat() throws InterruptedException
	{
		String key = "testExpireat";
		String value = "value";

		redisClient.getStringCommand().set(key, value);

		boolean result = redisClient.exists(key);
		Assert.assertTrue(result);

		redisClient.expireat(key, System.currentTimeMillis() / 1000 + 10);

		TimeUnit.SECONDS.sleep(10);

		result = redisClient.exists(key);
		Assert.assertFalse(result);
	}

	@Test
	public void testGetExpire()
	{
		String key = "testGetExpire";
		String value = "value";

		redisClient.getStringCommand().set(key, value);

		long time = redisClient.ttl(key);
		Assert.assertEquals(time, KeyCommand.KEY_NO_EXPIRE);

		redisClient.del(key);
	}
}
