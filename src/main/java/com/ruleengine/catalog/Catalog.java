package main.java.com.ruleengine.catalog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import main.java.com.ruleengine.product.Product;

public enum Catalog {

	INSTANCE;
	private Map<String, Product> products;

	public static Catalog getCatalog() { // static getter
		
	      return INSTANCE;
	   }
	   
	  


	   /**
	   * Load the products from the given file.
	   * @param in - Scanner from which to read product information
	   */
	   public void readProducts() throws FileNotFoundException
	   {
		   if(products == null || products.isEmpty())
		   {
		       products = new HashMap<>();
		       //Scanner input = new Scanner(new File(.getFile()));
		       InputStream inputStream = getClass().getClassLoader().getResourceAsStream("products.txt");
		       try(Scanner input = new Scanner(inputStream);)
		       {
			       input.useDelimiter(";|\n");
			       while(input.hasNext()) {
			           String sku = input.next();
			           String productName = input.next();
			           double price = Double.valueOf(input.next());
			           String pricingRule = "NONE";
			           if(input.hasNext())
			           {
			        	   pricingRule = input.next();
			        	   pricingRule=pricingRule.replaceAll("\\r\\n|\\r|\\n", "");
			           }
			           Product newProduct = new Product(sku, productName, price, pricingRule);
			           products.put(sku, newProduct);
			       }
		       }
		       
		   }
		   
	   }

	   

	  

	   /**
	   * Finds a product with a given sku.
	   * @param code the product code to find
	   * @return the product with the given code, or null if there
	   * is no such product
	   */
	   public Product find(String sku)
	   {
	       if(products.containsKey(sku))
	       {
	    	   return products.get(sku);
	       }
	       // No match in the entire array list
	       return null;
	   }

	   

}
