/**
 * 
 */
package com.shopping.app.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shopping.app.cart.controller.CartController;


/**
 * @author AK
 *
 */

@SpringBootApplication
public class CartApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartApplication.class, args);
		new CartController();
	}

}
