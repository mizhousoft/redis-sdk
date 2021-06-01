package com.mizhousoft.redis.lettuce.command;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mizhousoft.redis.codec.Codec;
import com.mizhousoft.redis.command.SetCommand;
import com.mizhousoft.redis.lettuce.client.LettuceRedisClient;

import io.lettuce.core.api.sync.RedisCommands;

/**
 * SetCommand
 *
 * @version
 */
public class LettuceSetCommand extends AbstractRedisCommand implements SetCommand
{
	/**
	 * 构造函数
	 *
	 * @param redisClient
	 */
	public LettuceSetCommand(LettuceRedisClient redisClient)
	{
		super(redisClient);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> Set<T> smembers(String key, Codec<T> codec)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		Set<String> values = redisCommands.smembers(key);

		Set<T> results = new HashSet<>(values.size());
		for (String value : values)
		{
			T t = codec.decode(value);
			results.add(t);
		}

		return results;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long scard(String key)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.scard(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> boolean sismember(String key, T o, Codec<T> codec)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.sismember(key, codec.encode(o));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> long sadd(String key, T[] values, Codec<T> codec)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		List<String> list = new ArrayList<>(values.length);
		for (int i = 0; i < values.length; ++i)
		{
			String value = codec.encode(values[i]);
			list.add(value);
		}

		String[] ms = list.toArray(new String[list.size()]);

		return redisCommands.sadd(key, ms);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> long srem(String key, T[] values, Codec<T> codec)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		List<String> list = new ArrayList<>(values.length);
		for (int i = 0; i < values.length; ++i)
		{
			String value = codec.encode(values[i]);
			list.add(value);
		}

		String[] ms = list.toArray(new String[list.size()]);

		return redisCommands.srem(key, ms);
	}
}
