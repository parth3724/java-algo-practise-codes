
// CloneNotSupportedException is thrown when Object's clone is called and the object that is being cloned (or its Super classes except Object) is not implementing Cloneable.
// To clone an object of a class using Object's clone function, the class or any  of its ancestor must have implemented Cloneable interface.
// else this exception is thrown at runtime.
/////////////////////////////////////////////if class does not implement Cloneable but has overridden clone method then No Exception.
//also Object's clone is protected. So it can be called only from inside a method of a class. ::like super.clone()
//So even to call Object’s cloneable you cannot call directly using object reference.
// If a object is being cloned and neither that class nor any of its ancestor has overridden clone method,
// object's clone will be called implicitly. But since that is also protected, so need to check if accessible or not.
/*for visualization
class Object {
	protected Object clone(){//protected method accessible to members in the same package as object. Also available to members outside the package,
	                         // but only through inheritance. 
	}
}
*/
class Super implements Cloneable{
///* if below function is not implemented, call to clone for an instance of this class will be redirected to Object's clone.
// but Object's clone is protected and is accessible to Super only if Super is calling it. But Super is not calling it. Also if Sub calls it on instance
//of Super, still it will give compiler error. As sub has inherited the method, but for itself.
// Sub has no right to call protected method of object for an instance of Super, because Object and Sub are not in same package.
//
protected Super clone() throws CloneNotSupportedException{
	return (Super)super.clone();//this is possible only because the class implements cloneable
//	return myclone();
}

Super myclone() throws CloneNotSupportedException{
	return (Super)super.clone();//this is possible only because the class implements cloneable
}
//*/

}
class Sub extends Super{

Object cloneParent(Super s)  throws CloneNotSupportedException{
	return s.clone();/// how can Sub call a protect method of its s's parent class !! Sub cannot use clone directly when Super has not implemented.
	// ofcourse this method is inherited by Sub , but it can call for itself, i.e. its own instance, inside it.
	// So above line will give compiler error if package level access is not available. but here since both the classes are in same package,
	//method is accessible.
//super.clone()// perfectly legal. Only requirement : ancestor except Object should implement cloneable interface. 	            

}


}

class A implements Cloneable{ //Cloneable must for using Object class's clone method.
public static void main(String args[]) throws Exception{
Super s= new Super();
Object w = s.clone();//only possible because Super and A have same package name.
Sub sub = new Sub();
w = sub.clone();//only possible because Sub and A have same package name.
A a = new A();
w = a.clone();//no need to implement clone method when called by self. only implements Cloneable is enough.
w = sub.cloneParent(s);
//Object p =((Super) s).myclone();
//Object x = new Sub();
//Object q = ((Sub)x).clone();
}
}
