class Person{
  void eat(){
  ;
  }
}

public class TestAnnonymousInner{
	static int a = 0;
 public static void main(String args[]){
  final int b = 9;
  Person p=new Person(){
  void eat(){System.out.println("nice fruits"+b+a);}//b has to be final and a has to be static
  };

  p.eat();
  s.eat();
 }
 static Person s = new Person() {
	 void eat(){System.out.println("anonymous non-local"+a);}
 };
}
