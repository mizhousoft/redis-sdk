package com.mizhousoft.redis.lettuce;

import com.mizhousoft.redis.RedisConfiguration;
import com.mizhousoft.redis.lettuce.client.LettuceRedisClient;

/**
 * RedisClientInitializer
 *
 * @version
 */
public abstract class RedisClientInitializer
{
	public static LettuceRedisClient build()
	{
		RedisConfiguration configuration = new RedisConfiguration();
		configuration.setHostName("localhost");
		configuration.setPort(6379);
	//	configuration.setPassword("redis123");

		LettuceRedisClient redisClient = new LettuceRedisClient(configuration);
		redisClient.initialize();

		return redisClient;
	}
}
