/**
 * 
 */
package com.shopping.app.cart.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.shopping.app.product.catalogue.Product;
import com.shopping.app.promotion.Promotion;

/**
 * @author AK
 *
 */
public class Cart {

	Map<Product, Integer> cartItems = new HashMap<>();

	public void addProductToCartBySKUID(int pid, int quantity) {
		Product product = getProductBySKUID(pid);
		addToCart(product, quantity);
	}

	private Product getProductBySKUID(int skuId) {
		Product product = null;
		List<Product> products = new Products().getProducts();
		for (Product prod : products) {
			if (prod.getSkuId() == skuId) {
				product = prod;
				break;
			}
		}
		return product;
	}

	private void addToCart(Product product, Integer quantity) {
		cartItems.put(product, quantity);
	}

	public void removeProductBySKUID(int skuId) {

		if (!cartItems.isEmpty()) {
			Product prod = getProductBySKUID(skuId);
			cartItems.remove(prod);

		} else {
			System.out.println("\n Cart is empty !");
		}
	}

	
	
	
	
	public void printCartItems() {
	
		if (!cartItems.isEmpty()) {
			System.out.println("\n** CART ITEMS ** " );
			for (Entry<Product, Integer> entry : cartItems.entrySet()) {
				System.out.println("Product Information : "+ entry.getKey() + " Quantity :" + entry.getValue());
			}
			System.out.println("\n TOTAL AMOUNT  = " + calculateTotal());
		} else {
			System.out.println("\n Cart is empty !");
		}

	}

	public int calculateTotal() {
		int sum = 0;
		for (Entry<Product, Integer> entry : cartItems.entrySet()) {
			sum += entry.getKey().getPrice() * entry.getValue();

		}
		return sum;
	}
	
	
	public Integer applyPromotion(Promotion promotion) {
			return promotion.apply(cartItems);

		}
	
	
	

}
