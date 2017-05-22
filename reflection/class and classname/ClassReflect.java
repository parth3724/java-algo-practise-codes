import java.lang.reflect.Modifier;
import java.lang.Package;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.annotation.*;


class ClassReflect{
public static void main(String args[]){
	Inner i1 = new Inner();
	Class c1 = Inner.class; //to create class object from class
	Class c2= i1.getClass(); // create class object from its instance
	try{
	Class c3 = Class.forName("ClassReflect$Inner");// create class object even if you don't know the name at compile time, \
	//but have the class name as a string at runtime,
		System.out.println(c3.getName());
	}
	catch(ClassNotFoundException e ){
		System.out.println("classnotfound");
	}
	System.out.println(c1.getName()); //fully qualified class name "ClassReflect$Inner"
	System.out.println(c1.getSimpleName());//simple name without packagename "Inner"
	int modifiers = c1.getModifiers(); // get  modifiers of a class
	System.out.println(modifiers+" " + Modifier.isStatic(modifiers));
	/*
.isAbstract .isFinal .isInterface .isNative .isPrivate .isProtected .isPublic
.isStatic .isStrict .isSynchronized .isTransient .isVolatile
	*/
	Package packae = c1.getPackage();//obtain package info
	Class superclass = c1.getSuperclass();//obtain super class
	System.out.println(superclass.getName()); 	
Class[] interfaces = c1.getInterfaces();//get all interfaces implemented by this class. Includes only those that are mentioned by c1 in its definition. 
Constructor[] constructors = c1.getConstructors();
Method[] method = c1.getMethods();
Field[] fields = c1.getFields();
Annotation[] annotations = c1.getAnnotations();
}

public void learnConstructors(Class aClass){

}
static class Inner{

}
}