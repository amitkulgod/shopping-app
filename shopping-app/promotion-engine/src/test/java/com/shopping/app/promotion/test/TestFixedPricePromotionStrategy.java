/**
 * 
 */
package com.shopping.app.promotion.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.shopping.app.promotion.FixedPricePromotionStrategy;

/**
 * @author AK
 *
 */
public class TestFixedPricePromotionStrategy {
	
	
	@Autowired
	FixedPricePromotionStrategy qps;
	
	
	@TestConfiguration
	static class FixedPricePromotionStrategyTestContextConfiguration {

		@Bean
		public FixedPricePromotionStrategy fixedPromotionStrategy() {
			return new FixedPricePromotionStrategy();
		}
		
	}
	
	@Before
	public void setup() {
		System.out.println("Before");
	}
	
	@Test
	public void test() {
		boolean a=true;
		assertTrue(a);
	}
	
	
	@Test
	public void test_promotionforC() {
		qps.apply(null);
	}
	
	@Test
	public void test_promotionforD() {
		qps.apply(null);
	}
	
	@Test
	public void test_promotionforC_D() {
		qps.apply(null);
	}
	

}
