package com.yf;

import com.yf.model.TbProduct;
import com.yf.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductServiceApplication.class)
@Slf4j
public class ProductServerApplicationTests {

	@Autowired
	private ProductService productService;

	@Test
	public void contextLoads() {

		List<TbProduct> products = productService.findAll();
		log.info("products {}",products);


	}

}
