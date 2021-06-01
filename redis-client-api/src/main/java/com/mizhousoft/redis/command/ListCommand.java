package com.mizhousoft.redis.command;

import java.util.List;

/**
 * ListCommand
 *
 * @version
 */
public interface ListCommand
{
	/**
	 * 获取指定key的范围内的value值的 list列表。 （0 -1）返回所有值列表
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 * @see <a href="https://redis.io/commands/lrange">Redis Documentation: LRANGE</a>
	 */
	List<String> lrange(String key, long start, long end);

	/**
	 * 保留key指定范围内的列表值。其它的都删除
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @see <a href="https://redis.io/commands/ltrim">Redis Documentation: LTRIM</a>
	 */
	boolean ltrim(final String key, Long start, Long end);

	/**
	 * 获取key 列表的长度
	 * 
	 * @param key
	 * @return
	 * @see <a href="https://redis.io/commands/llen">Redis Documentation: LLEN</a>
	 */
	Long llen(final String key);

	/**
	 * 写入缓存，是左面进入 先进后出
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @see <a href="https://redis.io/commands/lpush">Redis Documentation: LPUSH</a>
	 */
	Long lpush(final String key, String value);

	/**
	 * 多个值写入缓存，是左面进入 先进后出
	 * 
	 * @param key
	 * @param values
	 * @return
	 * @see <a href="https://redis.io/commands/lpush">Redis Documentation: LPUSH</a>
	 */
	Long lpush(final String key, String... values);

	/**
	 * 如果列表存在，则在列表左边插入值value
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @see <a href="https://redis.io/commands/lpushx">Redis Documentation: LPUSHX</a>
	 */
	Long lpushx(final String key, String value);

	/**
	 * 写入缓存，是右边面进入 先进先出
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @see <a href="https://redis.io/commands/rpush">Redis Documentation: RPUSH</a>
	 */
	Long rpush(final String key, String value);

	/**
	 * 多个值写入缓存，是右边面进入 先进先出
	 * 
	 * @param key
	 * @param values
	 * @return
	 * @see <a href="https://redis.io/commands/rpush">Redis Documentation: RPUSH</a>
	 */
	Long rpush(final String key, String... values);

	/**
	 * 如果列表存在，则在列表右边插入值value
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @see <a href="https://redis.io/commands/rpushx">Redis Documentation: RPUSHX</a>
	 */
	Long rpushx(final String key, String value);

	/**
	 * 设置key列表中指定位置的值为value index不能大于列表长度。大于抛出异常,为负数则从右边开始计算
	 * 
	 * @param key
	 * @param index
	 * @param value
	 * @see <a href="https://redis.io/commands/lset">Redis Documentation: LSET</a>
	 */
	boolean lset(final String key, Long index, String value);

	/**
	 * 删除列表中第一个遇到的value值。count指定删除多少个,count为0则全部删除
	 * 
	 * @param key
	 * @param count
	 * @param value
	 * @return
	 * @see <a href="https://redis.io/commands/lrem">Redis Documentation: LREM</a>
	 */
	Long lrem(final String key, Long count, String value);

	/**
	 * 通过索引获取列表中的元素 (大于0从左边开始，小于0从右边开始)
	 * 
	 * @param key
	 * @param index
	 * @return
	 * @see <a href="https://redis.io/commands/lindex">Redis Documentation: LINDEX</a>
	 */
	String lindex(final String key, Long index);

	/**
	 * 移除列表中的第一个值，并返回该值
	 * 
	 * @param key
	 * @return
	 * @see <a href="https://redis.io/commands/lpop">Redis Documentation: LPOP</a>
	 */
	String lpop(final String key);

	/**
	 * 移除列表中的最后一个值，并返回该值
	 * 
	 * @param key
	 * @return
	 * @see <a href="https://redis.io/commands/rpop">Redis Documentation: RPOP</a>
	 */
	String rpop(final String key);

	/**
	 * 在key的列表中插入一个新的value.如果 指定的value不存在则不插入任何值
	 * 
	 * @param key
	 * @param pivot
	 * @param value
	 * @return
	 * @see <a href="https://redis.io/commands/linsert">Redis Documentation: LINSERT</a>
	 */
	Long linsert(final String key, boolean before, String pivot, String value);

}
