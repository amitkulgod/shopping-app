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
import com.shopping.app.promotion.FixedPricePromotionStrategy;

/**
 * @author AK
 *
 */
@RunWith(SpringRunner.class)
public class TestFixedPricePromotionStrategy {
	
	
	@Autowired
	FixedPricePromotionStrategy fps;
	
	
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
	public void test_promotionforC_WhenNonOfferQuantity() {
		
		Map<Product, Integer> productsMap=new HashMap<>();
		Product c=new Product(3, "C", 20.0D);
		productsMap.put(c,1);
		assertTrue((c.getPrice()*1) == fps.apply(productsMap));
	}
	
	
	
	@Test
	public void test_promotionforD_WhenNonOfferQuantity() {
		
		Map<Product, Integer> productsMap=new HashMap<>();
		Product d=new Product(4, "D", 15.0D);
		productsMap.put(d,1);
		assertTrue((d.getPrice()*1) == fps.apply(productsMap));
	}
	
	
	@Test
	public void test_promotionforCandD_WhenOfferQuantity() {
		
		Map<Product, Integer> productsMap=new HashMap<>();
		Product c=new Product(3, "C", 20.0D);
		Product d=new Product(4, "D", 15.0D);
		productsMap.put(c,1);
		productsMap.put(d,1);
		assertTrue((30) == fps.apply(productsMap));
	}
	
	
	@Test
	public void test_promotionforCandD_WhenCHasOfferQuantityAndDHasNonOfferQunatity() {
		
		Map<Product, Integer> productsMap=new HashMap<>();
		Product c=new Product(3, "C", 20.0D);
		Product d=new Product(4, "D", 15.0D);
		productsMap.put(c,1);
		productsMap.put(d,2);
		assertTrue((30)+15 == fps.apply(productsMap));
	}
	
	
	@Test
	public void test_promotionforCandD_WhenDHasOfferQuantityAndCHasNonOfferQunatity() {
		
		Map<Product, Integer> productsMap=new HashMap<>();
		Product c=new Product(3, "C", 20.0D);
		Product d=new Product(4, "D", 15.0D);
		productsMap.put(c,2);
		productsMap.put(d,1);
		assertTrue((30)+20 == fps.apply(productsMap));
	}
	
	
	
	
	

}
