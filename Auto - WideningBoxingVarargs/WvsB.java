/////These rules are for Auto...
//http://www.javatpoint.com/autoboxing-and-unboxing

class WvsB{  
  static void m(int i){System.out.println("int");}  //This is printed. Widening beat Boxing
  static void m(Short i){System.out.println("Short");}  
  
  public static void main(String args[]){  
   short s=30;  
   m(s);  
 }   
}  