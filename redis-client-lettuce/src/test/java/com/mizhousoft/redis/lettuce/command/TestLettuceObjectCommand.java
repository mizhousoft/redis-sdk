package com.mizhousoft.redis.lettuce.command;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mizhousoft.redis.lettuce.RedisClientInitializer;
import com.mizhousoft.redis.lettuce.RedisUser;
import com.mizhousoft.redis.lettuce.client.LettuceRedisClient;

/**
 * TestLettuceObjectCommand
 *
 * @version
 */
public class TestLettuceObjectCommand
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

		RedisUser user = new RedisUser();
		user.setName("刘德华");
		user.setPhoneNumber("13902839211");

		redisClient.getObjectCommand().set(key, user);

		RedisUser result = redisClient.getObjectCommand().get(key, RedisUser.class);
		Assert.assertEquals(user.getPhoneNumber(), result.getPhoneNumber());

		redisClient.del(key);
	}

	@Test
	public void testMultiSet() throws InterruptedException
	{
		Map<String, RedisUser> userMap = new HashMap<>(10);

		RedisUser user = new RedisUser();
		user.setName("刘德华");
		user.setPhoneNumber("13902839211");

		String key1 = "testMultiSet";
		userMap.put(key1, user);

		user = new RedisUser();
		user.setName("liudehua");
		user.setPhoneNumber("13502819281");

		String key2 = "liudehua";
		userMap.put(key2, user);

		redisClient.getObjectCommand().mset(userMap);

		String[] keys = { key1, key2 };

		Map<String, RedisUser> resultMap = redisClient.getObjectCommand().mget(RedisUser.class, keys);
		Assert.assertNotNull(resultMap.get(key1));

		redisClient.del(keys);
	}
}
