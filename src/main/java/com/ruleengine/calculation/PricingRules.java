package main.java.com.ruleengine.calculation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import main.java.com.ruleengine.common.RuleEnum;
import main.java.com.ruleengine.product.ProductLineItem;
import main.java.com.ruleengine.shoppingcart.ShoppingCart;

public class PricingRules {

	Properties prop;
	
	public PricingRules() {
		
		
		InputStream input = null;
		try {
			prop = new Properties();
		    input = getClass().getClassLoader().getResourceAsStream("rules.properties");
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void execute(ShoppingCart cart, Map<String, ProductLineItem> pliMap) {
		for (Entry<String, ProductLineItem> entry : pliMap.entrySet()) {
			RuleEnum rule = entry.getValue().getDiscountRule();
			if(rule == null) continue;
			ProductLineItem productLineItem = entry.getValue();
			switch (rule)
			{
				case ITEMVALUEOFF: new ItemValueOffRuleExecutor((String) prop.get(RuleEnum.ITEMVALUEOFF.toString()), productLineItem);break;
				case BULKDISC: new BulkDiscountRuleExecutor((String) prop.get(RuleEnum.BULKDISC.toString()), productLineItem);break;
				case BUYXATY: new BuyXAtYRuleExecutor((String) prop.get(RuleEnum.BUYXATY.toString()), productLineItem);break;
				case FREEGIFT: new FreeGiftRuleExecutor((String) prop.get(RuleEnum.FREEGIFT.toString()), productLineItem, cart);break;
				default: productLineItem.setDiscountedPrice(productLineItem.getBasePrice() * productLineItem.getQuantity());
			}
			
				
		}
	}
}
