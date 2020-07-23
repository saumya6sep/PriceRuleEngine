package main.java.com.ruleengine.calculation;

import main.java.com.ruleengine.product.ProductLineItem;


public class ItemValueOffRuleExecutor {
	
	public static final String DELIM = ";";
	public static final String PER = "PER";
	public static final String FIXED = "FIXED";

	public ItemValueOffRuleExecutor(String ruleData, ProductLineItem productLineItem) {
		String [] ruleParams = ruleData.split(DELIM);
		if(ruleParams == null || ruleParams.length < 2)
		{
			productLineItem.setDiscountedPrice(productLineItem.getBasePrice() * productLineItem.getQuantity());
		}
		else
		{
			if(PER.equalsIgnoreCase(ruleParams[0]))
			{
				double basePrice = productLineItem.getBasePrice();
				double discPrice = basePrice - basePrice * (Integer.valueOf(ruleParams[1])/100);
				productLineItem.setDiscountedPrice(discPrice * productLineItem.getQuantity());
			}
			else if(FIXED.equalsIgnoreCase(ruleParams[0]))
			{
				double basePrice = productLineItem.getBasePrice();
				double discPrice = basePrice - Integer.valueOf(ruleParams[1]);
				productLineItem.setDiscountedPrice(discPrice * productLineItem.getQuantity());
			}
		}
	}

}
