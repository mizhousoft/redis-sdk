package com.mizhousoft.redis.lettuce.client;

import java.time.Duration;

import org.apache.commons.lang3.StringUtils;

import com.mizhousoft.redis.RedisClient;
import com.mizhousoft.redis.RedisConfiguration;
import com.mizhousoft.redis.command.HashCommand;
import com.mizhousoft.redis.command.ListCommand;
import com.mizhousoft.redis.command.ObjectCommand;
import com.mizhousoft.redis.command.SetCommand;
import com.mizhousoft.redis.command.StringCommand;
import com.mizhousoft.redis.command.ZSetCommand;
import com.mizhousoft.redis.lettuce.command.LettuceHashCommand;
import com.mizhousoft.redis.lettuce.command.LettuceKeyCommand;
import com.mizhousoft.redis.lettuce.command.LettuceListCommand;
import com.mizhousoft.redis.lettuce.command.LettuceObjectCommand;
import com.mizhousoft.redis.lettuce.command.LettuceSetCommand;
import com.mizhousoft.redis.lettuce.command.LettuceStringCommand;
import com.mizhousoft.redis.lettuce.command.LettuceZSetCommand;

import io.lettuce.core.RedisURI;
import io.lettuce.core.RedisURI.Builder;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

/**
 * Redis Client
 *
 * @version
 */
public class LettuceRedisClient implements RedisClient
{
	// 配置
	private RedisConfiguration configuration;

	// LettuceKeyCommand
	private LettuceKeyCommand keyCommand = new LettuceKeyCommand(this);

	// LettuceStringCommand
	private LettuceStringCommand stringCommand = new LettuceStringCommand(this);

	// LettuceSetCommand
	private LettuceSetCommand setCommand = new LettuceSetCommand(this);

	// LettuceZSetCommand
	private LettuceZSetCommand zsetCommand = new LettuceZSetCommand(this);

	// LettuceHashCommand
	private LettuceHashCommand hashCommand = new LettuceHashCommand(this);

	// LettuceListCommand
	private LettuceListCommand listCommand = new LettuceListCommand(this);

	// LettuceObjectCommand
	private LettuceObjectCommand objectCommand = new LettuceObjectCommand(this);

	// Lettuce RedisClient
	private io.lettuce.core.RedisClient redisClient;

	// StatefulRedisConnection
	private StatefulRedisConnection<String, String> connection;

	// RedisCommands
	private RedisCommands<String, String> redisCommands;

	public LettuceRedisClient(RedisConfiguration configuration)
	{
		super();
		this.configuration = configuration;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(String key)
	{
		return keyCommand.exists(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean expire(String key, int seconds)
	{
		return keyCommand.expire(key, seconds);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean pexpire(String key, long milliseconds)
	{
		return keyCommand.pexpire(key, milliseconds);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean expireat(String key, long timestamp)
	{
		return keyCommand.expireat(key, timestamp);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean pexpireat(String key, long timestamp)
	{
		return keyCommand.pexpireat(key, timestamp);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long ttl(String key)
	{
		return keyCommand.ttl(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean del(String key)
	{
		return keyCommand.del(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long del(String... keys)
	{
		return keyCommand.del(keys);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StringCommand getStringCommand()
	{
		return stringCommand;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SetCommand getSetCommand()
	{
		return setCommand;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ZSetCommand getZSetCommand()
	{
		return zsetCommand;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HashCommand getHashCommand()
	{
		return hashCommand;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ListCommand getListCommand()
	{
		return listCommand;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ObjectCommand getObjectCommand()
	{
		return objectCommand;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void shundown()
	{
		if (connection != null)
		{
			connection.close();
		}

		if (redisClient != null)
		{
			redisClient.shutdown();
		}
	}

	public void initialize()
	{
		String host = configuration.getHostName();
		int port = configuration.getPort();
		int database = configuration.getDatabase();
		String password = configuration.getPassword();
		int timeout = configuration.getTimeout();

		Builder builder = RedisURI.builder().withDatabase(database).withHost(host).withPort(port);
		if (!StringUtils.isBlank(password))
		{
			builder.withPassword(password);
		}

		if (timeout > 0)
		{
			builder.withTimeout(Duration.ofSeconds(timeout));
		}

		RedisURI redisUri = builder.build();

		io.lettuce.core.RedisClient redisClient = io.lettuce.core.RedisClient.create(redisUri);

		this.redisClient = redisClient;
	}

	public synchronized StatefulRedisConnection<String, String> getConnection()
	{
		if (null == this.connection)
		{
			this.connection = redisClient.connect();
		}

		return this.connection;
	}

	/**
	 * 获取redisCommands
	 * 
	 * @return
	 */
	public synchronized RedisCommands<String, String> getRedisCommands()
	{
		StatefulRedisConnection<String, String> connection = getConnection();

		if (null == this.redisCommands)
		{
			this.redisCommands = connection.sync();
		}

		return this.redisCommands;
	}

}
