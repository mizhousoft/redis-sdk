package com.mizhousoft.redis.lettuce.command;

import com.mizhousoft.redis.lettuce.client.LettuceRedisClient;

/**
 * AbstractRedisCommand
 *
 * @version
 */
public abstract class AbstractRedisCommand
{
	protected LettuceRedisClient redisClient;

	/**
	 * 构造函数
	 *
	 * @param redisClient
	 */
	public AbstractRedisCommand(LettuceRedisClient redisClient)
	{
		super();
		this.redisClient = redisClient;
	}
}
