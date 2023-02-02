package com.mizhousoft.redis.lettuce.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mizhousoft.redis.codec.IntegerCodec;
import com.mizhousoft.redis.command.SetCommand;
import com.mizhousoft.redis.lettuce.RedisClientInitializer;
import com.mizhousoft.redis.lettuce.client.LettuceRedisClient;

/**
 * LettuceSetCommand Test
 *
 * @version
 */
public class TestLettuceSetCommand
{
	LettuceRedisClient redisClient;

	@BeforeEach
	public void before()
	{
		this.redisClient = RedisClientInitializer.build();
	}

	@Test
	public void test()
	{
		SetCommand setComand = redisClient.getSetCommand();

		String key = "testset";
		IntegerCodec codec = new IntegerCodec();

		Integer[] values = { 4, 6, 2 };
		setComand.sadd(key, values, codec);
	}
}
