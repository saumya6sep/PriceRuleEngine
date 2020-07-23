package main.java.com.ruleengine.calculation;

import main.java.com.ruleengine.catalog.Catalog;
import main.java.com.ruleengine.product.ProductLineItem;
import main.java.com.ruleengine.shoppingcart.ShoppingCart;

public class FreeGiftRuleExecutor {

	public static final String DELIM = ";";
	
	public FreeGiftRuleExecutor(String ruleData, ProductLineItem productLineItem, ShoppingCart cart) {
		
		productLineItem.setDiscountedPrice(productLineItem.getBasePrice() * productLineItem.getQuantity());
		
		String [] ruleParams = ruleData.split(DELIM);
		if(ruleParams != null && ruleParams.length == 2 && Integer.valueOf(ruleParams[1]) > 0)
		{
			String sku = ruleParams[0];
			ProductLineItem pli = cart.getPli(sku);
			if(pli == null)
			{
				pli = cart.scan(Catalog.getCatalog().find(sku));
				pli.setFreeGift(true);
				pli.setDiscountedPrice(0.0);
			}
			else
			{
				pli.setDiscountedPrice(pli.getBasePrice() * (pli.getQuantity() - 1));
			}
			
		}
		
	}
}
