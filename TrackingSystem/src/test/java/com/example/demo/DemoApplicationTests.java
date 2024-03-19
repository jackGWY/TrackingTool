package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	void set() {
		ValueOperations ops = redisTemplate.opsForValue();    // 首先redisTemplate.opsForValue的目的就是表明是以key，value形式储存到Redis数据库中数据的
		ops.set("address1","zhengzhou");// 到这里就表明Redis数据库中存储了key为address1，value为zhengzhou的数据了（取的时候通过key取数据）
	}

	@Test
	void get() {
		ValueOperations ops = redisTemplate.opsForValue();  // 表明取的是key，value型的数据
		Object o = ops.get("address1");  // 获取Redis数据库中key为address1对应的value数据
		System.out.println(o);
	}


	/**
	 *  向Redis数据库中储存哈希类型的数据（一个key里面放着一个key和value）
	 *
	 *  哈希类型的储存命令：put
	 */
	@Test
	void hset() {
		HashOperations ops = redisTemplate.opsForHash();// 表明数据是以哈希类型的格式进行储存到Redis数据库的
		ops.put("info","a","aa");
		// 通过put命令，向Redis数据库中储存一个哈希类型的数据（一个为info的key里面放着一个key为a，value为aa的数据）
	}

	/**
	 *  取数据
	 *
	 *  哈希类型的取值命令：get
	 */
	@Test
	void hget() {
		HashOperations ops = redisTemplate.opsForHash();  // 表明取的是哈希类型的数据
		Object o = ops.get("info","a");  // 获取Redis数据库中哈希类型的数据（获取第一个key里面key为a的value数据）
		System.out.println(o);
	}


}
