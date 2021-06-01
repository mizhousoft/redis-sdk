package com.mizhousoft.redis.command;

/**
 * KeyCommand
 *
 * @version
 */
public interface KeyCommand
{
	// Key不存在
	int KEY_NOT_EXIST = -2;

	// Key不过期
	int KEY_NO_EXPIRE = -1;

	/**
	 * 判断缓存中是否有对应的value
	 * 
	 * @param key
	 * @return
	 * @see <a href="https://redis.io/commands/exists">Redis Documentation: EXISTS</a>
	 */
	boolean exists(final String key);

	/**
	 * 指定缓存失效时间
	 * 
	 * @param key
	 * @param seconds
	 * @return
	 * @see <a href="https://redis.io/commands/expire">Redis Documentation: EXPIRE</a>
	 */
	boolean expire(String key, int seconds);

	/**
	 * 指定缓存失效时间
	 * 
	 * @param key
	 * @param milliseconds
	 * @return
	 * @see <a href="https://redis.io/commands/pexpire">Redis Documentation: PEXPIRE</a>
	 */
	boolean pexpire(String key, long milliseconds);

	/**
	 * 指定缓存失效时间（单位秒）
	 * 缓存到了时间戳失效
	 * 
	 * @param key
	 * @param timestamp
	 * @return
	 * @see <a href="https://redis.io/commands/expireat">Redis Documentation: EXPIREAT</a>
	 */
	boolean expireat(String key, long timestamp);

	/**
	 * 指定缓存失效时间（单位毫秒）
	 * 缓存到了时间戳失效
	 * 
	 * @param key
	 * @param timestamp
	 * @return
	 * @see <a href="https://redis.io/commands/pexpireat">Redis Documentation: PEXPIREAT</a>
	 */
	boolean pexpireat(String key, long timestamp);

	/**
	 * 根据key获取过期时间（单位秒）,返回0代表为永久有效
	 * 
	 * @param key
	 * @return
	 * @see <a href="https://redis.io/commands/ttl">Redis Documentation: TTL</a>
	 */
	long ttl(String key);

	/**
	 * 根据key删除对应的value
	 * 
	 * @param key
	 * @return
	 * @see <a href="https://redis.io/commands/del">Redis Documentation: DEL</a>
	 */
	boolean del(final String key);

	/**
	 * 根据key批量删除对应的value
	 * 
	 * @param keys
	 * @return
	 * @see <a href="https://redis.io/commands/del">Redis Documentation: DEL</a>
	 */
	long del(final String... keys);
}
