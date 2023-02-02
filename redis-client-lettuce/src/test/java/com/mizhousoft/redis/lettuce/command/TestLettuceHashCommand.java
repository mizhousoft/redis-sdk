package com.mizhousoft.redis.lettuce.command;

import java.time.LocalDate;
import java.time.ZoneId;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mizhousoft.redis.lettuce.RedisClientInitializer;
import com.mizhousoft.redis.lettuce.client.LettuceRedisClient;

/**
 * TestLettuceHashCommand
 *
 * @version
 */
public class TestLettuceHashCommand
{
	LettuceRedisClient redisClient;

	@BeforeEach
	public void before()
	{
		this.redisClient = RedisClientInitializer.build();
	}

	@Test
	public void testHincrby()
	{
		String key = "counter:user:1";
		String field = "issue";

		redisClient.getHashCommand().hincrby(key, field, 1);

		if (-1 == redisClient.ttl(key))
		{
			LocalDate lastDay = LocalDate.now().plusDays(1);
			long ts = lastDay.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();

			redisClient.pexpireat(key, ts);
		}

		field = "comment";

		redisClient.getHashCommand().hincrby(key, field, 1);

		if (-1 == redisClient.ttl(key))
		{
			LocalDate lastDay = LocalDate.now().plusDays(1);
			long ts = lastDay.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();

			redisClient.pexpireat(key, ts);
		}
	}
}
