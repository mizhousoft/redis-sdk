package com.mizhousoft.redis;

import com.mizhousoft.redis.command.HashCommand;
import com.mizhousoft.redis.command.KeyCommand;
import com.mizhousoft.redis.command.ListCommand;
import com.mizhousoft.redis.command.ObjectCommand;
import com.mizhousoft.redis.command.SetCommand;
import com.mizhousoft.redis.command.StringCommand;
import com.mizhousoft.redis.command.ZSetCommand;

/**
 * Redis Client
 *
 * @version
 */
public interface RedisClient extends KeyCommand
{
	/**
	 * 获取StringCommand
	 * 
	 * @return
	 */
	StringCommand getStringCommand();

	/**
	 * 获取SetCommand
	 * 
	 * @return
	 */
	SetCommand getSetCommand();

	/**
	 * 获取ZSetCommand
	 * 
	 * @return
	 */
	ZSetCommand getZSetCommand();

	/**
	 * 获取HashCommand
	 * 
	 * @return
	 */
	HashCommand getHashCommand();

	/**
	 * 获取ListCommand
	 * 
	 * @return
	 */
	ListCommand getListCommand();

	/**
	 * 获取ObjectCommand
	 * 
	 * @return
	 */
	ObjectCommand getObjectCommand();

	/**
	 * 关闭
	 */
	void shundown();
}
