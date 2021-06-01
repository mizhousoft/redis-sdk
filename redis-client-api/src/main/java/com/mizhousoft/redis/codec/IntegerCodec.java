package com.mizhousoft.redis.codec;

import com.mizhousoft.redis.RedisException;

/**
 * 整形编码器
 *
 * @version
 */
public class IntegerCodec implements Codec<Integer>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String encode(Integer t) throws RedisException
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
	public Integer decode(String input) throws RedisException
	{
		if (null == input)
		{
			return null;
		}

		try
		{
			return Integer.valueOf(input);
		}
		catch (NumberFormatException e)
		{
			throw new RedisException(input + " is illegal.", e);
		}
	}
}
