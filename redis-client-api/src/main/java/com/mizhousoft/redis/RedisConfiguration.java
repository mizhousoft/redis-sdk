package com.mizhousoft.redis;

/**
 * Redis配置
 *
 * @version
 */
public class RedisConfiguration
{
	private static final String DEFAULT_HOST = "localhost";

	private static final int DEFAULT_PORT = 6379;

	// 主机
	private String hostName = DEFAULT_HOST;

	// 端口
	private int port = DEFAULT_PORT;

	// 数据库
	private int database;

	// 密码
	private String password;

	// 超时时间，单位是秒
	private int timeout;

	/**
	 * 获取hostName
	 * 
	 * @return
	 */
	public String getHostName()
	{
		return hostName;
	}

	/**
	 * 设置hostName
	 * 
	 * @param hostName
	 */
	public void setHostName(String hostName)
	{
		this.hostName = hostName;
	}

	/**
	 * 获取port
	 * 
	 * @return
	 */
	public int getPort()
	{
		return port;
	}

	/**
	 * 设置port
	 * 
	 * @param port
	 */
	public void setPort(int port)
	{
		this.port = port;
	}

	/**
	 * 获取database
	 * 
	 * @return
	 */
	public int getDatabase()
	{
		return database;
	}

	/**
	 * 设置database
	 * 
	 * @param database
	 */
	public void setDatabase(int database)
	{
		this.database = database;
	}

	/**
	 * 获取password
	 * 
	 * @return
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * 设置password
	 * 
	 * @param password
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * 获取timeout
	 * 
	 * @return
	 */
	public int getTimeout()
	{
		return timeout;
	}

	/**
	 * 设置timeout
	 * 
	 * @param timeout
	 */
	public void setTimeout(int timeout)
	{
		this.timeout = timeout;
	}
}
