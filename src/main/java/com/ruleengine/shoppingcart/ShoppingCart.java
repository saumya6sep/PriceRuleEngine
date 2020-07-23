package main.java.com.ruleengine.shoppingcart;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import main.java.com.ruleengine.calculation.PricingRules;
import main.java.com.ruleengine.product.Product;
import main.java.com.ruleengine.product.ProductLineItem;

public class ShoppingCart {
	private Map<String, ProductLineItem> pliMap;
	private PricingRules pricingRules;
	
	public ShoppingCart(PricingRules pricingRules)
	{
		this.pricingRules = pricingRules;
	}

	/**
	 * Adds a product to cart.
	 * 
	 * @param p the product to add
	 */
	public ProductLineItem scan(Product p) {
		ProductLineItem pli = null;
		String sku = p.getSku();
		if(pliMap==null)
		{
			pliMap = new HashMap<>();
		}
		
		if(pliMap.containsKey(sku)) {
			pli = pliMap.get(sku);
			pli.increaseQuantity();
		}
		else
		{
			pli = new ProductLineItem(p,1);
			pliMap.put(sku, pli);
		}
		return pli;
	}

	/**
	 * Gets the sum of the values of all products.
	 * 
	 * @return the sum of the values
	 */
	public double total() {
		double total = 0;
		for (Entry<String, ProductLineItem> entry : pliMap.entrySet()) {
			total = total + entry.getValue().getDiscountedPrice();
		}
		return total;
	}
	
	public void calculate()
	{
		
		if (pliMap!=null && !pliMap.isEmpty()) pricingRules.execute(this, pliMap);
	}

	public void emptyCart() {
		if (pliMap!=null && !pliMap.isEmpty()) pliMap.clear();
		
	}

	public ProductLineItem getPli(String sku) {
		if(pliMap == null) return null;
		return pliMap.get(sku);
	}

}
