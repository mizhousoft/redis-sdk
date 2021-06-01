package com.mizhousoft.redis.lettuce.command;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.HashedMap;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.redis.RedisException;
import com.mizhousoft.redis.command.ObjectCommand;
import com.mizhousoft.redis.lettuce.client.LettuceRedisClient;

/**
 * ObjectCommand
 *
 * @version
 */
public class LettuceObjectCommand extends AbstractRedisCommand implements ObjectCommand
{
	/**
	 * 构造函数
	 *
	 * @param redisClient
	 */
	public LettuceObjectCommand(LettuceRedisClient redisClient)
	{
		super(redisClient);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> boolean set(String key, T value)
	{
		if (null == value)
		{
			return true;
		}

		try
		{
			String string = JSONUtils.toJSONString(value);

			return redisClient.getStringCommand().set(key, string);
		}
		catch (JSONException e)
		{
			throw new RedisException("Object serialize to a string failed.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> boolean setex(String key, T value, long expireTime)
	{
		if (null == value)
		{
			return true;
		}
		
		try
		{
			String string = JSONUtils.toJSONString(value);

			return redisClient.getStringCommand().setex(key, string, expireTime);
		}
		catch (JSONException e)
		{
			throw new RedisException("Object serialize to a string failed.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> boolean setex(String key, T value, long expireTime, TimeUnit timeUnit)
	{
		if (null == value)
		{
			return true;
		}
		
		try
		{
			String string = JSONUtils.toJSONString(value);

			return redisClient.getStringCommand().setex(key, string, expireTime, timeUnit);
		}
		catch (JSONException e)
		{
			throw new RedisException("Object serialize to a string failed.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> boolean mset(Map<String, T> values)
	{
		if (null == values)
		{
			return true;
		}

		Map<String, String> map = new HashMap<>(values.size());

		Iterator<String> iter = values.keySet().iterator();
		while (iter.hasNext())
		{
			String key = iter.next();
			T object = values.get(key);
			if (null == object)
			{
				continue;
			}

			try
			{
				String string = JSONUtils.toJSONString(object);
				map.put(key, string);
			}
			catch (JSONException e)
			{
				throw new RedisException("Object serialize to a string failed.", e);
			}
		}

		return redisClient.getStringCommand().mset(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T get(String key, Class<T> clazz)
	{
		String value = redisClient.getStringCommand().get(key);
		if (null == value)
		{
			return null;
		}

		try
		{
			return JSONUtils.parse(value, clazz);
		}
		catch (JSONException e)
		{
			throw new RedisException("String deserialize to Object failed.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> Map<String, T> mget(Class<T> clazz, String... keys)
	{
		Map<String, String> values = redisClient.getStringCommand().mget(keys);

		Map<String, T> resultMap = new HashedMap<>(values.size());

		Iterator<Entry<String, String>> iter = values.entrySet().iterator();
		while (iter.hasNext())
		{
			Entry<String, String> entry = iter.next();
			if (null == entry.getValue())
			{
				continue;
			}

			try
			{
				T object = JSONUtils.parse(entry.getValue(), clazz);
				resultMap.put(entry.getKey(), object);
			}
			catch (JSONException e)
			{
				throw new RedisException("String deserialize to Object failed.", e);
			}
		}

		return resultMap;
	}

}
