/**
 * 
 */
package com.shopping.app.promotion;

import java.util.Map;

import com.shopping.app.product.catalogue.Product;

/**
 * @author AK
 *
 */
public interface Promotion {
	
	public Integer apply(Map<Product, Integer> product);


}
