package com.mizhousoft.redis.lettuce.command;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mizhousoft.redis.ScoreValue;
import com.mizhousoft.redis.codec.JsonJacksonCodec;
import com.mizhousoft.redis.command.ZSetCommand;
import com.mizhousoft.redis.lettuce.RedisClientInitializer;
import com.mizhousoft.redis.lettuce.client.LettuceRedisClient;

/**
 * LettuceZSetCommand Test
 *
 * @version
 */
public class TestLettuceZSetCommand
{
	LettuceRedisClient redisClient;

	@BeforeEach
	public void before()
	{
		this.redisClient = RedisClientInitializer.build();
	}

	@Test
	public void test() throws InterruptedException
	{
		ZSetCommand zsetComand = redisClient.getZSetCommand();

		JsonJacksonCodec<TestUser> codec = new JsonJacksonCodec<TestUser>(TestUser.class);

		String key = "testzset";

		TestUser user = new TestUser();
		user.setName("aaaaaaa");
		zsetComand.zadd(key, 32, user, codec);

		user = new TestUser();
		user.setName("bbbbbbb");
		zsetComand.zadd(key, 1, user, codec);

		user = new TestUser();
		user.setName("bbbbbbb");
		zsetComand.zaddincr(key, 100, user, codec);

		user = new TestUser();
		user.setName("ccccccc");
		zsetComand.zadd(key, 14, user, codec);

		user = new TestUser();
		user.setName("ddddddd");
		zsetComand.zadd(key, 124, user, codec);

		user = new TestUser();
		user.setName("eeeeeee");
		zsetComand.zadd(key, 224, user, codec);

		user = new TestUser();
		user.setName("fffffff");
		zsetComand.zadd(key, 224, user, codec);

		user = new TestUser();
		user.setName("ggggggg");
		zsetComand.zadd(key, 2, user, codec);

		user = new TestUser();
		user.setName("hhhhhhh");
		zsetComand.zadd(key, 21, user, codec);

		user = new TestUser();
		user.setName("iiiiiii");
		zsetComand.zadd(key, 344, user, codec);

		user = new TestUser();
		user.setName("jjjjjj");
		zsetComand.zadd(key, 67, user, codec);

		user = new TestUser();
		user.setName("kkkkkk");
		zsetComand.zadd(key, 167, user, codec);

		user = new TestUser();
		user.setName("llllll");
		zsetComand.zadd(key, 62, user, codec);

		long count = zsetComand.zcard(key);
		Assertions.assertEquals(12, count);

		List<TestUser> list = zsetComand.zrange(key, 0, 10, codec);
		System.out.println(list.size());

		list = zsetComand.zrevrange(key, 0, 10, codec);
		System.out.println(list.size());

		List<ScoreValue<TestUser>> scoreList = zsetComand.zrangeWithScores(key, 0, 10, codec);
		System.out.println(scoreList.size());

		List<TestUser> listx = zsetComand.zpopmin(key, 2, codec);
		Assertions.assertEquals(2, listx.size());

		count = zsetComand.zcard(key);
		Assertions.assertEquals(4, count);

		list = zsetComand.zrange(key, 0, 10, codec);
		System.out.println(list.size());

		redisClient.del(key);
	}
}
