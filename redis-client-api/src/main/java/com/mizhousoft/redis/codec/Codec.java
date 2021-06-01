package com.mizhousoft.redis.codec;

import com.mizhousoft.redis.RedisException;

/**
 * 编码器
 *
 * @version
 */
public interface Codec<T>
{
	/**
	 * 编码
	 * 
	 * @param t
	 * @return
	 * @throws RedisException
	 */
	String encode(T t) throws RedisException;

	/**
	 * 解码
	 * 
	 * @param input
	 * @return
	 * @throws RedisException
	 */
	T decode(String input) throws RedisException;
}
