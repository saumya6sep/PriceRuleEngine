/**
 * 
 */
package main.java.com.ruleengine.checkout;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.com.ruleengine.calculation.PricingRules;
import main.java.com.ruleengine.catalog.Catalog;
import main.java.com.ruleengine.product.Product;
import main.java.com.ruleengine.shoppingcart.ShoppingCart;

/**
 * @author Administrator
 *
 */
public class Checkout {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {

		Catalog.getCatalog().readProducts();
		
		ShoppingCart cart = new ShoppingCart(new PricingRules());
		System.out.print("Enter a SKUs of products (X/x to quit): ");
		List<String> addedSkuList = new ArrayList<>();
		List<String> invalidSkuList = new ArrayList<>();
	    try (Scanner in = new Scanner(System.in)) {
			String sku;
			while (!((sku = in.next()).equalsIgnoreCase("X"))) {
				Product p = Catalog.getCatalog().find(sku);
				if(p == null)
				{
					invalidSkuList.add(sku);
				}
				else
				{
					cart.scan(p);
					addedSkuList.add(sku);
					
				}
				
			}
		}
	    cart.calculate();
	    if(invalidSkuList.isEmpty() && addedSkuList.isEmpty()) System.out.println("No SKUs entered");
	    if(!invalidSkuList.isEmpty()) System.out.println("SKUs Not Found :: " + invalidSkuList.toString());
	    if(!addedSkuList.isEmpty()) System.out.println("SKUs Scanned:" +  addedSkuList.toString() + " Total : " + cart.total());

	}

	

}
