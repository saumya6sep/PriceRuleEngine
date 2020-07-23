package main.java.com.ruleengine.product;

import main.java.com.ruleengine.common.RuleEnum;

public class ProductLineItem {

	Product product;
	private String sku;
	private double discountedPrice;
	private int quantity;
	private boolean isFreeGift;
	
	public ProductLineItem(Product p, int quantity) {
		this.product = p;
		this.quantity = quantity;
	}
	
	public RuleEnum getDiscountRule() {
		return product.getPricingRule();
	}
	
	public double getBasePrice() {
		return product.getProductPrice();
	}
	
	/**
	 * @return the discountedPrice
	 */
	public double getDiscountedPrice() {
		return discountedPrice;
	}
	/**
	 * @param discountedPrice the discountedPrice to set
	 */
	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	/**
	 * @return the isFreeGift
	 */
	public boolean isFreeGift() {
		return isFreeGift;
	}
	/**
	 * @param isFreeGift the isFreeGift to set
	 */
	public void setFreeGift(boolean isFreeGift) {
		this.isFreeGift = isFreeGift;
	}
	
	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}
	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void increaseQuantity() {
		quantity++;
		
	}
	
	
}
