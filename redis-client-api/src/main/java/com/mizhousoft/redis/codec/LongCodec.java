package com.mizhousoft.redis.codec;

import com.mizhousoft.redis.RedisException;

/**
 * 长整形编码器
 *
 * @version
 */
public class LongCodec implements Codec<Long>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String encode(Long t) throws RedisException
	{
		if (null == t)
		{
			return null;
		}

		return String.valueOf(t);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long decode(String input) throws RedisException
	{
		if (null == input)
		{
			return null;
		}

		try
		{
			return Long.valueOf(input);
		}
		catch (NumberFormatException e)
		{
			throw new RedisException(input + " is illegal.", e);
		}
	}
}
