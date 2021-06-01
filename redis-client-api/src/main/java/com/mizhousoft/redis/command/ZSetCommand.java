package com.mizhousoft.redis.command;

import java.util.List;

import com.mizhousoft.redis.codec.Codec;

/**
 * Sorted Set Command
 *
 * @version
 */
public interface ZSetCommand
{
	/**
	 * 增加元素
	 * 
	 * @param key
	 * @param score
	 * @param member
	 * @return
	 */
	<T> Long zadd(String key, double score, T member, Codec<T> codec);

	/**
	 * 增加元素如果存在就更新分数
	 * 
	 * @param <T>
	 * @param key
	 * @param score
	 * @param member
	 * @param codec
	 * @return
	 */
	<T> Double zaddincr(String key, double score, T member, Codec<T> codec);

	/**
	 * 统计
	 * 
	 * @param key
	 * @return
	 */
	Long zcard(String key);

	/**
	 * 获取数据
	 * 
	 * @param key
	 * @param start
	 * @param stop
	 * @return
	 */
	<T> List<T> zrange(String key, long start, long stop, Codec<T> codec);

	/**
	 * 获取数据
	 * 
	 * @param <T>
	 * @param key
	 * @param start
	 * @param stop
	 * @param codec
	 * @return
	 */
	<T> List<T> zrangeWithScores(String key, long start, long stop, Codec<T> codec);

	/**
	 * 获取数据
	 * 
	 * @param <T>
	 * @param key
	 * @param start
	 * @param stop
	 * @param codec
	 * @return
	 */
	<T> List<T> zrevrange(String key, long start, long stop, Codec<T> codec);

	/**
	 * 获取数据
	 * 
	 * @param <T>
	 * @param key
	 * @param start
	 * @param stop
	 * @param codec
	 * @return
	 */
	<T> List<T> zrevrangeWithScores(String key, long start, long stop, Codec<T> codec);

	/**
	 * 删除最小的一个
	 * 
	 * @param <T>
	 * @param key
	 * @param codec
	 * @return
	 */
	<T> T zpopmin(String key, Codec<T> codec);

	/**
	 * 删除最小的多个
	 * 
	 * @param <T>
	 * @param key
	 * @param count
	 * @param codec
	 * @return
	 */
	<T> List<T> zpopmin(String key, long count, Codec<T> codec);

	/**
	 * 删除
	 * 
	 * @param <T>
	 * @param key
	 * @param members
	 * @param codec
	 * @return
	 */
	<T> Long zrem(String key, T[] members, Codec<T> codec);
}
