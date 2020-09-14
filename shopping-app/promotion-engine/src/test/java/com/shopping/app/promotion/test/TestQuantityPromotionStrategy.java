/**
 * 
 */
package com.shopping.app.promotion.test;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopping.app.product.catalogue.Product;
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
	public void test_promotionforA_WhenNonOfferQuantity() {
		
		Map<Product, Integer> productsMap=new HashMap<>();
		Product a=new Product(1, "A", 50.0D);
		productsMap.put(a,1);
		assertTrue((a.getPrice()*1) == qps.apply(productsMap));
	}
	
	@Test
	public void test_promotionforA_WhenOfferQuantity() {
		
		Map<Product, Integer> productsMap=new HashMap<>();
		Product a=new Product(1, "A", 50.0D);
		productsMap.put(a,3);
		assertTrue((130) == qps.apply(productsMap));
	}
	
	@Test
	public void test_promotionforA_WhenOfferAndNonofferQuantity() {
		
		Map<Product, Integer> productsMap=new HashMap<>();
		Product a=new Product(1, "A", 50.0D);
		productsMap.put(a,5);
		assertTrue(((130)+(2*50)) == qps.apply(productsMap));
	}
	
	
	@Test
	public void test_promotionforB_WhenNonOfferQuantity() {
		
		Map<Product, Integer> productsMap=new HashMap<>();
		Product b=new Product(2, "B", 30.0D);
		productsMap.put(b,1);
		assertTrue((b.getPrice()*1) == qps.apply(productsMap));
	}
	
	@Test
	public void test_promotionforB_WhenOfferQuantity() {
		
		Map<Product, Integer> productsMap=new HashMap<>();
		Product b=new Product(2, "B", 30.0D);
		productsMap.put(b,2);
		assertTrue((45) == qps.apply(productsMap));
	}
	
	@Test
	public void test_promotionforB_WhenOfferAndNonofferQuantity() {
		
		Map<Product, Integer> productsMap=new HashMap<>();
		Product b=new Product(2, "B", 30.0D);
		productsMap.put(b,3);
		assertTrue(((45)+(1*30)) == qps.apply(productsMap));
	}
	
	
	
	@Test
	public void test_promotionforB() {
		qps.apply(null);
	}

}
