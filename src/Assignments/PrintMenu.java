package Assignments;

//sub class which extends super class Menu
public class PrintMenu extends Menu{	
	
	//constructor, sets prices, name and then prints the menu
	PrintMenu(String name, double burgerPrice1, double burgerPrice2, double burgerPrice3){
		super.franchiseName = name;
		this.price(burgerPrice1, burgerPrice2, burgerPrice3);
		super.printMenu();
	}
	
	//overrides the prices for the super class
	@Override
	public void price(double burgerPrice1, double burgerPrice2, double burgerPrice3) {
	super.burgerPrice1 = burgerPrice1;
	super.burgerPrice2 = burgerPrice2;
	super.burgerPrice3 = burgerPrice3;
   
	}
}