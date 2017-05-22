import java.lang.reflect.Array;

class ArrayReflection{
	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class intArray = Class.forName("[I");
		System.out.println(intArray.getName());//prints [I  . As represnetation for int array
//		Class intClass1 = Class.forName("I");//ClassNotFoundException
//		Class intClass2 = Class.forName("int");//ClassNotFoundException
//////////////////////////////////////////////////////////////////////////////////////////////
		Class c = int.class;
		System.out.println(c.getName());//prints int
		///////////////////////////////////////////////////////////////////////////// To create primitive double array using reflection
	Class c1 = Class.forName("[I");
Object arr = Array.newInstance(c1, 3);//even with 0 inplace of 3
	System.out.println(c1.getName());//[I
	System.out.println(arr.getClass().getName());//[[I
	/////////////////////////////////
	Class<?> c2 = Class.forName("[I");
//Object arr2 = c2.newInstance();///InstantiationException
//////////////////////////////////////////////////
//Class<?> clazz = Class.forName("I");//ClassNotFoundException
//Object arr3 = Array.newInstance(clazz, 5);
////////////////////////////////////////////////////////////////////// To create primitive Array instance using reflection
Class intClass = Integer.TYPE;
Object arrInstance = Array.newInstance(intClass, 2);
System.out.println(arrInstance.getClass().getName());//[I
System.out.println(arrInstance.getClass().getComponentType());//int
System.out.println(intClass.getComponentType());//null
	}

}