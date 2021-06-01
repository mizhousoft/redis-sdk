package com.mizhousoft.redis.command;

/**
 * Hash Long Command
 *
 * @version
 */
public interface HashLongCommand
{
	/**
	 * 获取获取Hash中的value
	 * 
	 * @param key
	 * @param field
	 * @return
	 */
	Long hgetLong(String key, String field);
}
