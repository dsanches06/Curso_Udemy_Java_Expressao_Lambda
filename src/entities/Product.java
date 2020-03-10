package entities;

public class Product {

	private String name;
	private Double price;

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	// consumer com metodo estatico
	public static void staticPriceUpdate(Product p) {
		p.setPrice(p.getPrice() * 1.1);
	}

	// consumer com metodo estatico
	public void noStaticPriceUpdate() {
		price *= 1.1;
	}

	// predicate com metodos estaticos
	public static boolean staticProductPredicate(Product p) {
		return p.getPrice() >= 100.0;
	}

	// predicate com metodos não estaticos
	public boolean nonStaticProductPredicate() {
		return price >= 100.0;
	}
	
	//uso de function com metodo estatico
	public static String staticUpperCaseName(Product p) {
		return p.getName().toUpperCase();
	}
	
	
	//uso de function com metodo não estatico
	public  String nonStaticUpperCaseName() {
		return name.toUpperCase();
	}
	
	@Override
	public String toString() {
		return name + ", " + String.format("%.2f", price);
	}
}
