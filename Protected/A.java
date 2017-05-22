class A {
public static void main(String args[]) throws Exception{
MObject s= new MObject();
MSuper sup = new MSuper();
MSub sub = new MSub();
sub.method2(sup);
sub.method();
sup.method();
}
}

class MObject {
protected void method(){
	System.out.println("MObject.method");
}
}

class MSuper extends MObject {
	
}

class MSub extends MSuper {
	protected void method2(MSuper sup){
	sup.method();//Only possible because MSub is in same package as MObject
	System.out.println("MSub.method2");
}
}