package com.mizhousoft.redis.lettuce.command;

import java.util.List;

import com.mizhousoft.redis.command.ListCommand;
import com.mizhousoft.redis.lettuce.client.LettuceRedisClient;
import com.mizhousoft.redis.util.RedisUtils;

import io.lettuce.core.api.sync.RedisCommands;

/**
 * ListCommand
 *
 * @version
 */
public class LettuceListCommand extends AbstractRedisCommand implements ListCommand
{
	/**
	 * 构造函数
	 *
	 * @param redisClient
	 */
	public LettuceListCommand(LettuceRedisClient redisClient)
	{
		super(redisClient);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> lrange(String key, long start, long end)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.lrange(key, start, end);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean ltrim(String key, Long start, Long end)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		String reply = redisCommands.ltrim(key, start, end);

		return RedisUtils.replyToBool(reply);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long llen(String key)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.llen(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long lpush(String key, String value)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.lpush(key, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long lpush(String key, String... values)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.lpush(key, values);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long lpushx(String key, String value)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.lpushx(key, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long rpush(String key, String value)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.rpush(key, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long rpush(String key, String... values)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.rpush(key, values);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long rpushx(String key, String value)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.rpushx(key, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean lset(String key, Long index, String value)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		String reply = redisCommands.lset(key, index, value);

		return RedisUtils.replyToBool(reply);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long lrem(String key, Long count, String value)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.lrem(key, count, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String lindex(String key, Long index)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.lindex(key, index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String lpop(String key)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.lpop(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String rpop(String key)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.rpop(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long linsert(String key, boolean before, String pivot, String value)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.linsert(key, before, pivot, value);
	}
}
