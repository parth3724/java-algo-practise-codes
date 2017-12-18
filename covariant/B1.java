//Covariant is allowed in only return type

class D{
int a;
}

class A{  //class cannot be private.
D d = new D();
//D get(){return d;}   gives error that B1 cannot override get();
A get(){return this;}
void message(){System.out.println("welcome to covariant return type A");}
void onlyA(){System.out.println("onlyA");}  
}  
  
/*abstract*/ class B1 extends A{  //main class can be abstract. No problem . There can be only one public class in a file.

A get(){return (A)this;}  
void message(){System.out.println("welcome to covariant return type B1");}
void onlyB1(){System.out.println("onlyB1");}
//comment for learning git. 
  
public static void main(String args[]){  
A a = new A();
B1 b = new B1();
(a.get()).message();
b.get().message();
(a).get().message();
//D d = (D)a;//compile time error. inconvertible types.
//B1 b2 = (B1)a;/////Run time exception.java.lang.ClassCastException: A cannot be cast to B1.So better use instance of before downcasting.
}  
}  