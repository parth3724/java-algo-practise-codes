package package2;

import package1.Super;

public class Sub extends Super{
protected void method(Super s){
//	s.method();//exception
	super.method();
}
public void method2(Super s){
	method(s);
}
public Sub clone(){
	try {
		Super s = (Super)super.clone();//if Super has not implemented clone, the it uses Object's clone.
		//above lne will throw clonenotsupported exception if Super has neither implemented 
		//clone interface nor overridden clone method.
	} catch (CloneNotSupportedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return new Sub();
}
}
