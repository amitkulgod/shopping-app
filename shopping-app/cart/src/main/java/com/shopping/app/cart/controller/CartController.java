/**
 * 
 */
package com.shopping.app.cart.controller;

import java.util.List;
import java.util.Scanner;

import com.shopping.app.cart.entity.Cart;
import com.shopping.app.cart.entity.Products;
import com.shopping.app.product.catalogue.Product;
import com.shopping.app.promotion.FixedPricePromotionStrategy;
import com.shopping.app.promotion.QuantityPromotionStrategy;

/**
 * @author AK
 *
 */
public class CartController {

	Cart cart = new Cart();

	private int ch = 0;

	public CartController() {
		menu();
	}

	public void startScreen() {
		System.out.println("\n ** Shopping Application  **");
		System.out.println("\n Please select the options below to proceed further");
		System.out.println("1. Display All Products");
		System.out.println("0. Exit\n");
	}

	public void cartMenu() {
		System.out.println("\n Please select the options below to proceed further");
		System.out.println("1. Add to Cart");
		System.out.println("2. Remove From Cart");
		System.out.println("3. Check out");
	}

	public void menu() {
		startScreen();
		getUserInput();

		switch (ch) {
		case 1:
			displayAllProducts();
			cartMenu();
			getUserInput();
			mainChoice1();
			break;
		case 0:
			System.exit(0);
			break;
		default:

			break;
		}

	}

	private void mainChoice1() {
			switch (ch) {
			case 1:
				addProductToCart();
				showCart();
				cartMenu();
				getUserInput();
				mainChoice1();
			break;
			case 2:
				removeProductFromCart();
				showCart();
				cartMenu();
				getUserInput();
				mainChoice1();
				break;
				
			case 3:
				System.exit(0);
				break;	
			default:

				break;
			}


	}

	private int getUserInput() throws NumberFormatException {
		Scanner in = new Scanner(System.in);
		ch = Integer.parseInt(in.nextLine());
		return ch;
	}

	private void displayAllProducts() {
		List<Product> products = new Products().getProducts();
		System.out.println("SKU ID" + " - " + "PRODUCT NAME" + " -    " + "PRICE");
		for (Product prod : products) {
			System.out.println(prod.getSkuId() + "      -    " + prod.getName() + "         -    " + prod.getPrice());
		}
	}

	private void addProductToCart() {
		System.out.println("Enter Product SKU ID :");
		int skuId = getUserInput();
		System.out.println("Enter Qunatity :");
		int quantity = getUserInput();
		cart.addProductToCartBySKUID(skuId, quantity);
	}

	private void showCart() {
		cart.printCartItems();
		
		System.out.println("\n ** ACTIVE PROMOTIONS ** ");
		System.out.println("Buy 3 Product A for 130");
		System.out.println("Buy 2 Product B for 45");
		System.out.println("Buy Product C & D 30\n");
	
		
		int afterDiscount=cart.applyPromotion(new QuantityPromotionStrategy())+cart.applyPromotion(new FixedPricePromotionStrategy());
		System.out.println("TOTAL AMOUNT PAYABLE = " + afterDiscount );
		

	}

	private void removeProductFromCart() {
		System.out.println(" Enter the Product SKU ID  to be removed :");
		int skuId = getUserInput();
		cart.removeProductBySKUID(skuId);
		

	}

}
