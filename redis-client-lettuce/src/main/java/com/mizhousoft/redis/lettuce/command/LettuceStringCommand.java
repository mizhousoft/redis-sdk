package com.mizhousoft.redis.lettuce.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.mizhousoft.redis.command.StringCommand;
import com.mizhousoft.redis.lettuce.client.LettuceRedisClient;
import com.mizhousoft.redis.util.RedisUtils;

import io.lettuce.core.KeyValue;
import io.lettuce.core.SetArgs;
import io.lettuce.core.api.sync.RedisCommands;

/**
 * Value Command
 *
 * @version
 */
public class LettuceStringCommand extends AbstractRedisCommand implements StringCommand
{
	/**
	 * 构造函数
	 *
	 * @param redisClient
	 */
	public LettuceStringCommand(LettuceRedisClient redisClient)
	{
		super(redisClient);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean set(String key, String value)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		String result = redisCommands.set(key, value);

		return RedisUtils.replyToBool(result);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setex(String key, String value, long expireTime)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		SetArgs setArgs = SetArgs.Builder.ex(expireTime);
		String result = redisCommands.set(key, value, setArgs);

		return RedisUtils.replyToBool(result);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setex(String key, String value, long expireTime, TimeUnit timeUnit)
	{
		long seconds = timeUnit.toSeconds(expireTime);

		return setex(key, value, seconds);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean mset(Map<String, String> values)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		String result = redisCommands.mset(values);

		return RedisUtils.replyToBool(result);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long incr(String key, int delta)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.incrby(key, delta);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long decrby(String key, int delta)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.decrby(key, delta);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String get(String key)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.get(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, String> mget(String... keys)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		List<KeyValue<String, String>> list = redisCommands.mget(keys);

		Map<String, String> map = new HashMap<>(list.size());
		for (KeyValue<String, String> item : list)
		{
			map.put(item.getKey(), item.getValue());
		}

		return map;
	}

}
