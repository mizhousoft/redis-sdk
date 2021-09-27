package com.mizhousoft.redis;

/**
 * 分数数据
 *
 * @version
 */
public class ScoreValue<V>
{
	private final V value;

	private final double score;

	/**
	 * 构造函数
	 *
	 * @param score
	 * @param value
	 */
	public ScoreValue(V value, double score)
	{
		super();
		this.value = value;
		this.score = score;
	}

	/**
	 * 获取score
	 * 
	 * @return
	 */
	public double getScore()
	{
		return score;
	}

	/**
	 * 获取value
	 * 
	 * @return
	 */
	public V getValue()
	{
		return value;
	}
}
