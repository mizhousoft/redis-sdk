package com.mizhousoft.redis.command;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * ObjectCommand
 *
 * @version
 */
public interface ObjectCommand
{
	/**
	 * 写缓存（永久有效）
	 * 
	 * @param key
	 * @param value
	 */
	<T> boolean set(final String key, T value);

	/**
	 * 写缓存（有时间限制，单位默认秒）
	 * 
	 * @param key
	 * @param value
	 * @param expireTime
	 */
	<T> boolean setex(final String key, T value, long expireTime);

	/**
	 * 写缓存（有时间限制，可指定时间单位）
	 * 
	 * @param key
	 * @param value
	 * @param expireTime
	 * @param timeUnit
	 */
	<T> boolean setex(final String key, T value, long expireTime, TimeUnit timeUnit);

	/**
	 * 设置多个值
	 * 
	 * @param values
	 */
	<T> boolean mset(Map<String, T> values);

	/**
	 * 读缓存
	 * 
	 * @param <T>
	 * @param key
	 * @param clazz
	 * @return
	 */
	<T> T get(final String key, Class<T> clazz);

	/**
	 * 读取多个
	 * 
	 * @param <T>
	 * @param clazz
	 * @param keys
	 * @return
	 */
	<T> Map<String, T> mget(Class<T> clazz, String... keys);
}
