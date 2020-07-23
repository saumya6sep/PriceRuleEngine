package main.java.com.ruleengine.product;

import main.java.com.ruleengine.common.RuleEnum;

public class Product {

	private String sku;
	private String productName;
	private Double productPrice;
	private RuleEnum pricingRule;

	/**
	 * Constructs a product with a specific code, description, price and quantity.
	 * 
	 * @param sku          - product lookup code
	 * @param productName  - display name of the product
	 * @param productPrice - price product
	 * 
	 */
	public Product(String sku, String productName, Double productPrice, String pricingRule) {
		this.sku = sku;
		this.productName = productName;
		this.productPrice = productPrice;
		if(pricingRule != null)
			this.pricingRule = RuleEnum.valueOf(pricingRule);
	}

	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @return the productPrice
	 */
	public Double getProductPrice() {
		return productPrice;
	}

	/**
	 * @return the pricingRule
	 */
	public RuleEnum getPricingRule() {
		return pricingRule;
	}

}
