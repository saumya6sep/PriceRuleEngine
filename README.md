# PriceRuleEngine

BUILD and TEST::

1) Clone the repository.
2) Run gradlew clean build - It will run the test cases and also create the executable jar at path build/libs
3) Run the jar from the path or provide the full path while running the jar command - java -jar PriceRuleEngine.jar
4) On the command prompt enter the skus to be scanned (can be invalid or valid), to stop scanning press (X/x) and it will compute the value and display.

CONFIGURATIONS::

1) There are two configuration files products.txt that has the product data and rules.properties that has few rules configured (src/main/resources).

2) There are 4 rules configured and are evaluated when we call cart.calculate() after adding all the skus that are found in the catalog.

3) The description of rules are as below and can be changed:

ITEMVALUEOFF=PER;10 (Item Value off rule - The first value can be PER/FIXED and second is a number. If first is PER the discount will be equal to percentage of second configured value else the discount will be fixed equal to the second configured value)

BUYXATY=3;2 (Buy X items at price of Y - The first value is X and second is Y so 3:2 = Buy2At2)

BULKDISC=4;FIXED;100 (Bulk buy discount - First parameter is the quantity qualified for bulk discount, second is FiXED/PER and third is the valuse of dicount, again will be based on whether its fixed or percentage discount)

FREEGIFT=vga;1 (Free gift - First parameter is sku of the free gift and second is quantity of free gift)


CODE::

1) The source code is at src/main/java and the main class is Checkout.java, it initializes the catalog from product.txt and the PricingRules from rules.properties and takes the input from user from command line and the skus to ShoppingCart.

2) There are unit test cases written for all the scenarios mentioned in the problem at src/test/java
