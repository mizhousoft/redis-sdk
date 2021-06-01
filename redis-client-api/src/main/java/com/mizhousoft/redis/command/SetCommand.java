package com.mizhousoft.redis.command;

import java.util.Set;

import com.mizhousoft.redis.codec.Codec;

/**
 * Set Command
 *
 * @version
 */
public interface SetCommand
{
	/**
	 * 获取集合
	 * 
	 * @param key
	 * @param codec
	 * @return
	 * @see <a href="https://redis.io/commands/smembers">Redis Documentation: SMEMBERS</a>
	 */
	<T> Set<T> smembers(String key, Codec<T> codec);

	/**
	 * 获取集合大小
	 * 
	 * @param key
	 * @param codec
	 * @return
	 * @see <a href="https://redis.io/commands/scard">Redis Documentation: SCARD</a>
	 */
	long scard(String key);

	/**
	 * 是否集合中的成员
	 * 
	 * @param key
	 * @param o
	 * @param codec
	 * @return
	 * @see <a href="https://redis.io/commands/sismember">Redis Documentation: SISMEMBER</a>
	 */
	<T> boolean sismember(String key, T o, Codec<T> codec);

	/**
	 * 增加集合
	 * 
	 * @param key
	 * @param values
	 * @param codec
	 * @return
	 * @see <a href="https://redis.io/commands/sadd">Redis Documentation: SADD</a>
	 */
	<T> long sadd(String key, T[] values, Codec<T> codec);

	/**
	 * 删除集合中的成员
	 * 
	 * @param key
	 * @param values
	 * @param codec
	 * @return
	 * @see <a href="https://redis.io/commands/srem">Redis Documentation: SREM</a>
	 */
	<T> long srem(String key, T[] values, Codec<T> codec);
}
