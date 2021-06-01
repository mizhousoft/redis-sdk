package com.mizhousoft.redis.codec;

import com.mizhousoft.redis.RedisException;

/**
 * 字符串编码器
 *
 * @version
 */
public class StringCodec implements Codec<String>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String encode(String t) throws RedisException
	{
		return t;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String decode(String input) throws RedisException
	{
		return input;
	}
}
