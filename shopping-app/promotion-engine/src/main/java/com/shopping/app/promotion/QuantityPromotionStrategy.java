/**
 * 
 */
package com.shopping.app.promotion;

import java.util.Map;
import java.util.Map.Entry;

import com.shopping.app.product.catalogue.Product;

/**
 * @author AK
 *
 */




public class QuantityPromotionStrategy implements Promotion {
	
	
	public static final Double OFFER_PRICE_FOR_THREE_PRODUCT_A = 130D;
	public static final Double OFFER_PRICE_FOR_TWO_PRODUCT_B = 45D;

	@Override
	public Integer apply(Map<Product, Integer> productsMap) {
		int sum=0;
		for (Entry<Product, Integer> entry : productsMap.entrySet()) {
			
			if (entry.getKey().getSkuId().equals(1)) {
				sum += calculatePromotionForA(entry.getKey(), entry.getValue());
			}

			else if (entry.getKey().getSkuId().equals(2)) {
				sum += calculatePromotionForB(entry.getKey(), entry.getValue());
			}
		}
		
		return sum;
	}
	
	
	/** Promotion calculation for Product A 
	 * 
	 * @param product
	 * @param qty
	 * @return
	 */
	private Double calculatePromotionForA(Product product, Integer qty) {
		int nonOfferItemsQty = qty % 3;
		double standardPriceTotal = nonOfferItemsQty * product.getPrice();
		double offerPriceTotal = ((qty - nonOfferItemsQty) / 3) * OFFER_PRICE_FOR_THREE_PRODUCT_A;
		return standardPriceTotal + offerPriceTotal;

	}
	
	
	/**Promotion calculation for Product B
	 * 
	 * @param product
	 * @param qty
	 * @return
	 */
	private Double calculatePromotionForB(Product product, Integer qty) {
		int nonOfferItemsQty = qty % 2;
		double standardPriceTotal = nonOfferItemsQty * product.getPrice();
		double offerPriceTotal = ((qty - nonOfferItemsQty) / 2) * OFFER_PRICE_FOR_TWO_PRODUCT_B;
		return standardPriceTotal + offerPriceTotal;

	}

}
