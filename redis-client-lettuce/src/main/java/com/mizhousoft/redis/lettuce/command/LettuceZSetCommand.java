package com.mizhousoft.redis.lettuce.command;

import java.util.ArrayList;
import java.util.List;

import com.mizhousoft.redis.ScoreValue;
import com.mizhousoft.redis.codec.Codec;
import com.mizhousoft.redis.command.ZSetCommand;
import com.mizhousoft.redis.lettuce.client.LettuceRedisClient;

import io.lettuce.core.ScoredValue;
import io.lettuce.core.api.sync.RedisCommands;

/**
 * Sorted Set Command
 *
 * @version
 * @param <V>
 */
public class LettuceZSetCommand extends AbstractRedisCommand implements ZSetCommand
{
	/**
	 * 构造函数
	 *
	 * @param redisClient
	 */
	public LettuceZSetCommand(LettuceRedisClient redisClient)
	{
		super(redisClient);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> Long zadd(String key, double score, T member, Codec<T> codec)
	{
		String value = codec.encode(member);

		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.zadd(key, score, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> Double zaddincr(String key, double score, T member, Codec<T> codec)
	{
		String value = codec.encode(member);

		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.zaddincr(key, score, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long zcard(String key)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		return redisCommands.zcard(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> List<T> zrange(String key, long start, long stop, Codec<T> codec)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		List<String> values = redisCommands.zrange(key, start, stop);

		List<T> results = new ArrayList<>(values.size());
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
	public <T> List<ScoreValue<T>> zrangeWithScores(String key, long start, long stop, Codec<T> codec)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		List<ScoredValue<String>> values = redisCommands.zrangeWithScores(key, start, stop);

		List<ScoreValue<T>> results = new ArrayList<>(values.size());
		for (ScoredValue<String> value : values)
		{
			T t = codec.decode(value.getValue());

			ScoreValue<T> v = new ScoreValue<T>(t, value.getScore());
			results.add(v);
		}

		return results;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> List<T> zrevrange(String key, long start, long stop, Codec<T> codec)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		List<String> values = redisCommands.zrevrange(key, start, stop);

		List<T> results = new ArrayList<>(values.size());
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
	public <T> List<ScoreValue<T>> zrevrangeWithScores(String key, long start, long stop, Codec<T> codec)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		List<ScoredValue<String>> values = redisCommands.zrevrangeWithScores(key, start, stop);

		List<ScoreValue<T>> results = new ArrayList<>(values.size());
		for (ScoredValue<String> value : values)
		{
			T t = codec.decode(value.getValue());

			ScoreValue<T> v = new ScoreValue<T>(t, value.getScore());
			results.add(v);
		}

		return results;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T zpopmin(String key, Codec<T> codec)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		ScoredValue<String> value = redisCommands.zpopmin(key);

		return codec.decode(value.getValue());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> List<T> zpopmin(String key, long count, Codec<T> codec)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		List<ScoredValue<String>> list = redisCommands.zpopmin(key, count);

		List<T> results = new ArrayList<>(list.size());
		for (ScoredValue<String> value : list)
		{
			T t = codec.decode(value.getValue());
			results.add(t);
		}

		return results;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> Long zrem(String key, T[] members, Codec<T> codec)
	{
		RedisCommands<String, String> redisCommands = redisClient.getRedisCommands();

		List<String> values = new ArrayList<>(members.length);
		for (int i = 0; i < members.length; ++i)
		{
			String value = codec.encode(members[i]);
			values.add(value);
		}

		String[] ms = values.toArray(new String[values.size()]);
		return redisCommands.zrem(key, ms);
	}

}
