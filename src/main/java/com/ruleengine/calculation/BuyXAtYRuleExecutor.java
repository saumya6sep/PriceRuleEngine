package main.java.com.ruleengine.calculation;

import main.java.com.ruleengine.product.ProductLineItem;

public class BuyXAtYRuleExecutor {
	
	public static final String DELIM = ";";

	public BuyXAtYRuleExecutor(String ruleData, ProductLineItem productLineItem) {
		
		String [] ruleParams = ruleData.split(DELIM);
		if(ruleParams == null || ruleParams.length < 2 || productLineItem.getQuantity() < Integer.valueOf(ruleParams[0]))
		{
			productLineItem.setDiscountedPrice(productLineItem.getBasePrice() * productLineItem.getQuantity());
		}
		else
		{
			double discPrice = ((productLineItem.getQuantity() / Integer.valueOf(ruleParams[0]))
					* productLineItem.getBasePrice() * Integer.valueOf(ruleParams[1]))
					+ ((productLineItem.getQuantity() % Integer.valueOf(ruleParams[0]))
							* productLineItem.getBasePrice());
			productLineItem.setDiscountedPrice(discPrice);
			
		}
	}
}
