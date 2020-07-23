package main.java.com.ruleengine.calculation;

import main.java.com.ruleengine.product.ProductLineItem;

public class BulkDiscountRuleExecutor {
	
	public static final String DELIM = ";";
	public static final String PER = "PER";
	public static final String FIXED = "FIXED";

	public BulkDiscountRuleExecutor(String ruleData, ProductLineItem productLineItem) {
		String [] ruleParams = ruleData.split(DELIM);
		if(ruleParams == null || ruleParams.length < 3 || productLineItem.getQuantity() <= Integer.valueOf(ruleParams[0]))
		{
			productLineItem.setDiscountedPrice(productLineItem.getBasePrice() * productLineItem.getQuantity());
		}
		else
		{
				
			if(PER.equalsIgnoreCase(ruleParams[1]))
			{
				double basePrice = productLineItem.getBasePrice();
				double discPrice = basePrice - basePrice * (Integer.valueOf(ruleParams[2])/100);
				productLineItem.setDiscountedPrice(discPrice * productLineItem.getQuantity());
			}
			else if(FIXED.equalsIgnoreCase(ruleParams[1]))
			{
				double basePrice = productLineItem.getBasePrice();
				double discPrice = basePrice - Integer.valueOf(ruleParams[2]);
				productLineItem.setDiscountedPrice(discPrice * productLineItem.getQuantity());
			}
		}
	}
}
