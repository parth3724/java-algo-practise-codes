class A{
static void fun1(int a) throws java.io.IOException{//If a function declares a checked exception it is not required to throw that exception.

if(a<5)
;//	throw new java.io.IOException("sorry"); // If a function is throwing a checked exception, it must declare it (by throws) in its definition.

}
static void fun2(){
try{
	fun1(2);//If you are calling a method that declares a checked exception, you must either caught or declare the exception.
	}
	
	catch(Exception e){
	}
	}

public static void main(String args[])throws java.io.IOException{
fun2();
}
}