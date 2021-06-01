package com.mizhousoft.redis.lettuce.command;

import com.mizhousoft.redis.command.KeyCommand;
import com.mizhousoft.redis.lettuce.client.LettuceRedisClient;

import io.lettuce.core.api.sync.RedisCommands;

/**
 * KeyCommand
 *
 * @version
 */
public class LettuceKeyCommand extends AbstractRedisCommand implements KeyCommand
{
	/**
	 * 构造函数
	 *
	 * @param redisClient
	 */
	public LettuceKeyCommand(LettuceRedisClient redisClient)
	{
		super(redisClient);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(String key)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		long replyNum = redisCommands.exists(key);
		if (1 == replyNum)
		{
			return true;
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean expire(String key, int seconds)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.expire(key, seconds);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean pexpire(String key, long milliseconds)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.pexpire(key, milliseconds);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean expireat(String key, long timestamp)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.expireat(key, timestamp);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean pexpireat(String key, long timestamp)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.pexpireat(key, timestamp);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long ttl(String key)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.ttl(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean del(String key)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		long replyNum = redisCommands.del(key);
		if (1 == replyNum)
		{
			return true;
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long del(String... keys)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.del(keys);
	}
}
