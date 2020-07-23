package test.java.com.ruleengine;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.com.ruleengine.calculation.PricingRules;
import main.java.com.ruleengine.catalog.Catalog;
import main.java.com.ruleengine.product.Product;
import main.java.com.ruleengine.shoppingcart.ShoppingCart;


public class CheckoutTest {

	private static ShoppingCart cart;
	
	@BeforeAll
	public static void loadProducts() throws Exception
	{
			Catalog.INSTANCE.readProducts();
			cart = new ShoppingCart(new PricingRules());
	}
	
	@Test
    public void skuNotFound() throws Exception {
		Product p = Catalog.getCatalog().find("notvalid");
		assertTrue(p == null);
    }
	
	@Test
    public void test1() throws Exception {	
		cart.emptyCart();
		cart.scan(Catalog.getCatalog().find("atv"));
	    cart.scan(Catalog.getCatalog().find("atv"));
	    cart.scan(Catalog.getCatalog().find("atv"));
	    cart.scan(Catalog.getCatalog().find("vga"));
	    cart.calculate();
	    assertTrue(Double.compare(cart.total(),249.00)==0);
    }
	
	@Test
    public void test2() throws Exception {
		cart.emptyCart();
		cart.scan(Catalog.getCatalog().find("atv"));
	    cart.scan(Catalog.getCatalog().find("ipd"));
	    cart.scan(Catalog.getCatalog().find("ipd"));
	    cart.scan(Catalog.getCatalog().find("atv"));
	    cart.scan(Catalog.getCatalog().find("ipd"));
	    cart.scan(Catalog.getCatalog().find("ipd"));
	    cart.scan(Catalog.getCatalog().find("ipd"));
	    cart.calculate();
	    assertTrue(Double.compare(cart.total(),2718.95)==0);
    }
	
	@Test
    public void test3() throws Exception {
		cart.emptyCart();
		cart.scan(Catalog.getCatalog().find("mbp"));
	    cart.scan(Catalog.getCatalog().find("vga"));
	    cart.scan(Catalog.getCatalog().find("ipd"));
	    cart.calculate();
	    assertTrue(Double.compare(cart.total(),1949.98)==0);
    }
	
	@Test
    public void test4() throws Exception {
		cart.emptyCart();
		cart.scan(Catalog.getCatalog().find("mbp"));
	    cart.scan(Catalog.getCatalog().find("vga"));
	    cart.scan(Catalog.getCatalog().find("ipd"));
	    cart.scan(Catalog.getCatalog().find("vga"));
	    cart.calculate();
	    assertTrue(Double.compare(cart.total(),1979.98)==0);
    }
	
	@Test
    public void test5() throws Exception {
		cart.emptyCart();
		cart.scan(Catalog.getCatalog().find("mbp"));
	    cart.scan(Catalog.getCatalog().find("vga"));
	    cart.scan(Catalog.getCatalog().find("ipd"));
	    cart.calculate();
	    assertTrue(Double.compare(cart.total(),1949.98)==0);
    }
	
}
