package com.yingxs.jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis的测试
 * @author admin
 *
 */
public class JedisDemo1 {

	
	@Test
	/**
	 * 单实例的测试
	 */
	public void demo1() {
		//1.设置IP地址和端口
		Jedis jedis = new Jedis("192.168.2.198",6379);
		//2.保存数据
		jedis.set("name", "yingxs");
		//3.获取数据
		String value = jedis.get("name");
		System.out.println(value);
		//4.释放资源
		jedis.close();
	}
	
	@Test
	/**
	 * 连接池方式连接
	 */
	public void demo2() {
		JedisPoolConfig config = new JedisPoolConfig();
		
		//设置最大连接数
		config.setMaxTotal(30);
		//设置最大空闲连接数
		config.setMaxIdle(10);
		
		//获得连接池
		JedisPool jedisPool = new JedisPool(config,"192.168.2.198",6379);
		
		//获得核心对象
		Jedis jedis = null;
		try {
			//通过连接池获得对象
			jedis = jedisPool.getResource();
			System.out.println(jedis.get("name"));
			//设置数据
			jedis.set("name", "张三");
			//获取数据
			System.out.println(jedis.get("name"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//释放资源
			if(jedis!=null) {
				jedis.close();
			}
			if(jedisPool!=null) {
				jedisPool.close();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
