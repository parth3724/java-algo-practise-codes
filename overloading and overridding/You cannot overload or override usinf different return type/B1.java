class A{  
int mymy=0;
int get(){return mymy;}  
void onlyA(){System.out.println("onlyA");}  
}  
  
class B1 extends A{  
int mymy=1;
final int get(){return super.mymy;}  ///if this function was returning float, compiler error. saying cannot oveeride by changing return type.
void message(){System.out.println("welcome to covariant return type B1");}

class C1 extends B1 {
int mymy = 2;	
int get(){return mymy;}  
}
  
public static void main(String args[]){  
A a = new B1();
//A b = a.clone();
System.out.println(a.get());
}  
}  