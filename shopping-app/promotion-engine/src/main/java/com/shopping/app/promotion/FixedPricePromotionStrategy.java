/**
 * 
 */
package com.shopping.app.promotion;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.shopping.app.product.catalogue.Product;

/**
 * @author AK
 *
 */

@Service
public class FixedPricePromotionStrategy implements Promotion {

	public static final Double OFFER_PRICE_FOR_PRODUCT_C_AND_D = 30D;

	@Override
	public Integer apply(Map<Product, Integer> productsMap) {
		int sum = 0;
		Entry<Product, Integer> productC = null;
		Entry<Product, Integer> productD = null;

		for (Entry<Product, Integer> entry : productsMap.entrySet()) {

			if (entry.getKey().getSkuId() == 3) {
				productC = entry;
			}

			else if (entry.getKey().getSkuId() == 4) {
				productD = entry;
			}
		}

		if (productC != null && productD != null) {
			sum=calculatePromotionForCandD(productC, productD);

		} else if (productC != null) {
			sum = (int) (productC.getKey().getPrice() * productC.getValue());

		} else if (productD != null) {
			sum = (int) (productD.getKey().getPrice() * productD.getValue());

		}

		return sum;
	}

	private Integer calculatePromotionForCandD(Entry<Product, Integer> productC, Entry<Product, Integer> productD) {

		int sum = 0;
		if (productC.getValue().equals(productD.getValue())) {
			sum += productC.getValue() * OFFER_PRICE_FOR_PRODUCT_C_AND_D;
			return sum;

		} else if (productC.getValue() > productD.getValue()) {
			int temp = productC.getValue() - productD.getValue();
			double c = temp * productC.getKey().getPrice();
			double cd = productD.getValue() * OFFER_PRICE_FOR_PRODUCT_C_AND_D;
			sum += c + cd;
			return sum;

		} else if (productC.getValue() < productD.getValue()) {
			int temp = productD.getValue() - productC.getValue();
			double d = temp * productD.getKey().getPrice();
			double cd = productC.getValue() * OFFER_PRICE_FOR_PRODUCT_C_AND_D;
			sum += d + cd;
			return sum;
		}

		return null;

	}

}
