//The java compiler adds public and abstract keywords before the interface method and
//public, static and final keywords before data members.
//All methods in interface are public abstract by default
//All data members are public static final by default.
//Interface cannot have instance variable.
//So if a class is implementing two interfaces that have a data member with same name,
// then the class should not refer that variable directly (without referring interface), or else compiler will throw error as below.
/*
testinterface1.java:20: error: reference to i is ambiguous, both variable i in P
rintable and variable i in Showable match
public void print(){System.out.println(i);}
*/
interface Printable{  
int i=0;//by default public static final
void print();  // by default public abstract
}  
  
interface Showable{  
int i=0;
void print(); 
void modify(int j); 
}  

class testinterface1 implements Printable,Showable{  
  
public void print(){
;
//System.out.println(Showable.i++);
}  //if System.out.println(i) ; compiler error. cannot assign a value to final variable i
public void modify(int j){j=0;}
  
public static void main(String args[]){  
int k=10;
testinterface1 obj = new testinterface1();  
obj.print();  
obj.modify(k);
System.out.println(k);
System.out.println("parent child and interface....");
Printable c = new child();
c.print();

 }  
}  

class parent implements Printable {
public void print(){System.out.println(i);} 
}
class child extends parent{// a child by default implements the interface if implemented by parent. 
//there is no need to write implements Printable here but even if u write , no error or side effect.
public void print(){System.out.println(100);} // child can override interface methods.
}