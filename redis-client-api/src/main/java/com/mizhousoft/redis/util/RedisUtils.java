package com.mizhousoft.redis.util;

/**
 * Redis工具类
 *
 * @version
 */
public abstract class RedisUtils
{
	/**
	 * 结果转换成boolean
	 * 
	 * @param result
	 * @return
	 */
	public static boolean replyToBool(String result)
	{
		return "OK".equals(result);
	}
}
