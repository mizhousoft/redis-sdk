package com.mizhousoft.redis.command;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * String Command
 *
 * @version
 */
public interface StringCommand
{
	/**
	 * 写缓存（永久有效）
	 * 
	 * @param key
	 * @param value
	 * @see <a href="https://redis.io/commands/set">Redis Documentation: SET</a>
	 */
	boolean set(final String key, String value);

	/**
	 * 写缓存（有时间限制，单位默认秒）
	 * 
	 * @param key
	 * @param value
	 * @param expireTime
	 * @see <a href="https://redis.io/commands/setex">Redis Documentation: SETEX</a>
	 */
	boolean setex(final String key, String value, long expireTime);

	/**
	 * 写缓存（有时间限制，可指定时间单位）
	 * 
	 * @param key
	 * @param value
	 * @param expireTime
	 * @param timeUnit
	 * @see <a href="https://redis.io/commands/setex">Redis Documentation: SETEX</a>
	 */
	boolean setex(final String key, String value, long expireTime, TimeUnit timeUnit);

	/**
	 * 设置多个值
	 * 
	 * @param values
	 * @see <a href="https://redis.io/commands/mset">Redis Documentation: MSET</a>
	 */
	boolean mset(Map<String, String> values);

	/**
	 * 递增
	 * 
	 * @param key
	 * @param delta
	 * @return
	 * @see <a href="https://redis.io/commands/incr">Redis Documentation: INCR</a>
	 */
	long incr(String key, int delta);

	/**
	 * 递减
	 * 
	 * @param key
	 * @param delta
	 * @return
	 * @see <a href="https://redis.io/commands/decrby">Redis Documentation: DECRBY</a>
	 */
	long decrby(String key, int delta);

	/**
	 * 读缓存
	 * 
	 * @param key
	 * @return
	 * @see <a href="https://redis.io/commands/get">Redis Documentation: GET</a>
	 */
	String get(final String key);

	/**
	 * 读取多个
	 * 
	 * @param keys
	 * @return
	 * @see <a href="https://redis.io/commands/mget">Redis Documentation: MGET</a>
	 */
	Map<String, String> mget(String... keys);
}
