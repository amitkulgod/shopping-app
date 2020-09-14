/**
 * 
 */
package com.shopping.app.promotion.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopping.app.promotion.QuantityPromotionStrategy;

/**
 * @author AK
 *
 */
@RunWith(SpringRunner.class)
public class TestQuantityPromotionStrategy {
	

	@Autowired
	QuantityPromotionStrategy qps;
	
	
	@TestConfiguration
	static class QuantityPromotionStrategyTestContextConfiguration {

		@Bean
		public QuantityPromotionStrategy quantityPromotionStrategy() {
			return new QuantityPromotionStrategy();
		}
		
	}
	
	@Before
	public void setup() {
		System.out.println("Before");
	}
	
	@Test
	public void test_promotionforA() {
		qps.apply(null);
	}
	
	
	@Test
	public void test_promotionforB() {
		qps.apply(null);
	}

}
