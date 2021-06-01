package com.mizhousoft.redis.codec;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.redis.RedisException;

/**
 * JSON编码器
 *
 * @version
 */
public class JsonJacksonCodec<T> implements Codec<T>
{
	private Class<T> valueClass;

	/**
	 * 构造函数
	 *
	 * @param valueClass
	 */
	public JsonJacksonCodec(Class<T> valueClass)
	{
		super();
		this.valueClass = valueClass;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String encode(T t) throws RedisException
	{
		if (null == t)
		{
			return null;
		}

		try
		{
			return JSONUtils.toJSONString(t);
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
	public T decode(String input) throws RedisException
	{
		if (null == input)
		{
			return null;
		}

		try
		{
			return JSONUtils.parse(input, valueClass);
		}
		catch (JSONException e)
		{
			throw new RedisException("String deserialize to Object failed.", e);
		}
	}
}
