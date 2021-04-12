package com.anisha.spring.mongo.api;

import com.anisha.spring.mongo.api.repository.ShopRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMongodbApplicationTests {

	@Autowired
	ShopRepository shopRepository;

	@Test
	public void contextLoads() {
	}

}
