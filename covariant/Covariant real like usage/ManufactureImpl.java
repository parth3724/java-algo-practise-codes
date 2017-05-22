/*
http://javatechig.com/java/core-java/covariant-return-type-example-in-java

The Clone method will return the object where we need to downcast the Object to the subclass type. 
After Java5, we can override the clone method to return the object of subclass type.

Consider the scenario, where we have two types of manufacturer Mobile Phone and Washing Machine. 
Based on the customer requirement if the user wants to purchase Mobile Phone the overridden method 
will return the Mobile Phone object. Here the method getProduct will return the Mobile Phone object
instead of Product object (Mobile Phone implements the Product interface). I.e. returns the object of subclass
instead of superclass. Similarly the clone method in the Mobile Phone class will return the object of Mobile
Phone instead of object of the class Object. The same rule applies to the Washing Machine class too.
*/
interface Product {
	public void makeProduct(String productName, String ProductOwner, int IMEINo);
}

class MobilePhone implements Product, Cloneable {

	String _productName;
	String _ownerName;
	int _IMEINo;
	MobilePhone _clonedProduct;

	@Override
	public void makeProduct(String productName, String ownerName, int IMEINo) {
		// TODO Auto-generated method stub
		_productName = productName;
		_ownerName = ownerName;
		_IMEINo = IMEINo;
	}

	protected MobilePhone clone() throws CloneNotSupportedException {
		_clonedProduct = (MobilePhone) super.clone();
		return _clonedProduct;
		// return super.clone();
	}
}

class WasingMachine implements Product {

	String _productName;
	String _ownerName;
	int _modelNo;

	@Override
	public void makeProduct(String productName, String ownerName, int modelNo) {
		// TODO Auto-generated method stub
		_productName = productName;
		_ownerName = ownerName;
		_modelNo = modelNo;
	}

}

interface Manufacture {

	public Product getProduct();

}

class Apple implements Manufacture {

	@Override
	public MobilePhone getProduct() {
		// TODO Auto-generated method stub
		return new MobilePhone();
	}

}

class Samsung implements Manufacture {

	@Override
	public WasingMachine getProduct() {
		// TODO Auto-generated method stub
		return new WasingMachine();
	}

}

public class ManufactureImpl {

	/**
	 * @param args
	 * @throws CloneNotSupportedException
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub

		Apple s1 = new Apple();
		MobilePhone b1 = s1.getProduct();
		b1.makeProduct("Iphone5S", "XXXX", 1234);
		MobilePhone b2 = b1.clone();
		b2._IMEINo = 6789;
		System.out.println("IMEI Number Of Phone1->" + b1._IMEINo);
		System.out.println("IMEI Number Of Phone2->" + b2._IMEINo);
		Samsung f1=new Samsung();
		WasingMachine c1=f1.getProduct();
		c1.makeProduct("samsungWashingMachine","XYZ", 2014);
		System.out.println("Owner Name Of WasingMachine->" + c1._ownerName);
	}

}