/**
 * 
 */
package com.shopping.app.cart.entity;

import java.util.ArrayList;
import java.util.List;

import com.shopping.app.product.catalogue.Product;

/**
 * @author AKULGOD
 *
 */
public class Products {
	
	 private final List<Product> products = new ArrayList<Product>();

	    public Products () {
	        this.initStoreItems();
	    }
	    
	    
	    public List<Product> getProducts() {
	        return products;
	    }
	    
	    public void initStoreItems() {
	        String [] productNames = {"A", "B", "C","D"};
	        Double [] productPrice = {50.00d, 30.00d, 20.00d,15.00d};
	        
	        for (int i=0; i < productNames.length; i++) {
	            this.products.add(new Product(i+1, productNames[i], productPrice[i]));
	        }
	    }

}
