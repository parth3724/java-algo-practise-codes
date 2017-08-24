class ImoprtanceOfCloneable{
	/*
	A class implements the Cloneable interface to indicate to the Object.clone() method that it is legal 
	for that method to make a field-for-field copy of instances of that class. 
If we don't implement Cloneable interface, calling Object.clone() method generates CloneNotSupportedException.
	*/
	static class A{}
	static class B implements Cloneable{}
	static class C{ public Object clone(){return new C();} }
	static class D{ public Object clone() throws CloneNotSupportedException {return super.clone();} }
	static class E implements Cloneable{ public Object clone() throws CloneNotSupportedException {return super.clone();} }		
	static class F extends A implements Cloneable{ public Object clone() throws CloneNotSupportedException {return super.clone();} }		
	static class G extends B { public Object clone() throws CloneNotSupportedException {return super.clone();} }		
	
	public static void main(String args[]) throws CloneNotSupportedException {
	//	A a = new A();A a1 = (A)a.clone();//Compile error: clone() has protected access in Object
//		B b = new B(); B b1 = (B) b.clone();//Compile error: clone() has protected access in Object
		C c = new C(); C c1 = (C) c.clone();//works fine
	//	D d = new D(); D d1 = (D) d.clone();//Runtime Exception : CloneNotSupportedException/////////////////////////////////////
		E e = new E(); E e1 = (E) e.clone();//Works fine
		F f = new F(); F f1 = (F) f.clone();//Works fine
		G g = new G(); G g1 = (G) g.clone();//Works fine
	}
}