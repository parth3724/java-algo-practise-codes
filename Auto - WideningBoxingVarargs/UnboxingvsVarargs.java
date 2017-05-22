class U{

	static void m(long i){System.out.println("long");} //Unboxing and widening wins over varargs. Because 1)U wins over V && W wins over V.
// static void m(int i){System.out.println("int");}  //Unboxing wins over varargs
//    static void m(Long i){System.out.println("Long");}  //Not possible at all. These are unrelated classes.
//  static void m(Integer... i){System.out.println("Integer...");}  
//  static void m(Integer i){System.out.println("Integer");}  
  
  public static void main(String args[]){  
   Integer a = new Integer(5);
   m(a);  //unboxing and widening is possible. 
   m(a);
 }   
}
