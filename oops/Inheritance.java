class MySuper{private void fun(){System.out.println("super fun");}}

public class Inheritance extends MySuper{
	  void fun(){System.out.println("Inheritance fun");}
	public static void main(String args[]){
	 MySuper obj1 = new Inheritance();
//	 obj1.fun();//checked at compile time. here fun should be a member function of type of obj1 i.e. mysuper and accessible in current scope.
				// since MySuper.fun is not accessible inside Inheritance , compier error
	Object obj2 = new unrelated();
//	MySuper obj3 = (MySuper) obj2; //class cast exception at runtime since unrelated
	//MySuper obj3 =(MySuper) new unrelated();//error at compile time inconvertible types.
	Inheritance obj6 = new Sub();
	obj6.fun();
	}
}

class Sub extends Inheritance{
	protected void fun(){System.out.println("Sub fun");} //while overrriding method, can only assign weaker access privilages. strongest private - default- protectd - public - weakest
}
class unrelated{}