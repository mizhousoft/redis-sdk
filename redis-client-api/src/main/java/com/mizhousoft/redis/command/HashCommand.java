package com.mizhousoft.redis.command;

import java.util.List;
import java.util.Map;

/**
 * Hash Command
 *
 * @version
 */
public interface HashCommand extends HashLongCommand
{
	/**
	 * 删除Hash中的key
	 * 
	 * @param key
	 * @param fields
	 * @return
	 * @see <a href="https://redis.io/commands/hdel">Redis Documentation: HDEL</a>
	 */
	long hdel(String key, String... fields);

	/**
	 * Hash中的key是否存在
	 * 
	 * @param key
	 * @param field
	 * @return
	 * @see <a href="https://redis.io/commands/hexits">Redis Documentation: HEXISTS</a>
	 */
	boolean hexits(String key, String field);

	/**
	 * 根据Hash中的key获取集合
	 * 
	 * @param key
	 * @return
	 * @see <a href="https://redis.io/commands/hgetall">Redis Documentation: HGETALL</a>
	 */
	Map<String, String> hgetall(String key);

	/**
	 * 获取Hash中的value
	 * 
	 * @param key
	 * @param field
	 * @return
	 * @see <a href="https://redis.io/commands/hget">Redis Documentation: HGET</a>
	 */
	String hget(String key, String field);

	/**
	 * 获取Hash中的多个数据
	 * 
	 * @param key
	 * @param fields
	 * @return
	 * @see <a href="https://redis.io/commands/hmget">Redis Documentation: HMGET</a>
	 */
	Map<String, String> hmget(String key, String... fields);

	/**
	 * 获取Hash中的key
	 * 
	 * @param key
	 * @return
	 * @see <a href="https://redis.io/commands/hkeys">Redis Documentation: HKEYS</a>?
	 */
	List<String> hkeys(String key);

	/**
	 * 增加数据
	 * 
	 * @param key
	 * @param map
	 * @see <a href="https://redis.io/commands/hmset">Redis Documentation: HMSET</a>
	 */
	void hmset(String key, Map<String, String> map);

	/**
	 * 增加数据
	 * 
	 * @param key
	 * @param field
	 * @param value
	 * @see <a href="https://redis.io/commands/hset">Redis Documentation: HSET</a>
	 */
	void hset(String key, String field, String value);

	/**
	 * 递增
	 * 
	 * @param key
	 * @param field
	 * @param delta
	 * @return
	 * @see <a href="https://redis.io/commands/hincrby">Redis Documentation: HINCRBY</a>
	 */
	long hincrby(String key, String field, long delta);
}
