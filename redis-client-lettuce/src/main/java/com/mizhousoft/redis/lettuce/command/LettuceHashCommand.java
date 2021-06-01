package com.mizhousoft.redis.lettuce.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mizhousoft.redis.command.HashCommand;
import com.mizhousoft.redis.lettuce.client.LettuceRedisClient;

import io.lettuce.core.KeyValue;
import io.lettuce.core.api.sync.RedisCommands;

/**
 * HashCommand
 *
 * @version
 */
public class LettuceHashCommand extends AbstractRedisCommand implements HashCommand
{
	/**
	 * 构造函数
	 *
	 * @param redisClient
	 */
	public LettuceHashCommand(LettuceRedisClient redisClient)
	{
		super(redisClient);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long hdel(String key, String... fields)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.hdel(key, fields);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hexits(String key, String field)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.hexists(key, field);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, String> hgetall(String key)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.hgetall(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String hget(String key, String field)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.hget(key, field);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, String> hmget(String key, String... fields)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		List<KeyValue<String, String>> list = redisCommands.hmget(key, fields);

		Map<String, String> resultMap = new HashMap<>(list.size());
		for (KeyValue<String, String> item : list)
		{
			resultMap.put(item.getKey(), item.getValue());
		}

		return resultMap;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> hkeys(String key)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.hkeys(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void hmset(String key, Map<String, String> map)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		redisCommands.hmset(key, map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void hset(String key, String field, String value)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		redisCommands.hset(key, field, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long hincrby(String key, String field, long delta)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.hincrby(key, field, delta);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long hgetLong(String key, String field)
	{
		String value = hget(key, field);
		if (null == value)
		{
			return null;
		}

		return Long.valueOf(value);
	}
}
