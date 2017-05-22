import java.util.*;
//unmodifiableCollection cannot be altered.
// add and remove not supported. like that class cating of entire list is also not supported.
//but individual element can be modified
class temp{
int i=0;
temp(int t){
i=t;
}
}
class collectionss {  
//http://docs.oracle.com/javase/6/docs/api/java/util/Collections.html#unmodifiableCollection%28java.util.Collection%29	
//similar functions unmodifiableSortedSet, unmodifiableSortedMap, unmodifiableSet, unmodifiableMap, unmodifiableList, unmodifiableCollection 
public static void learnunmodifiableInterface(){
	System.out.println("learnunmodifiableInterface");
	ArrayList <temp> list=new ArrayList<temp>();
	list.add(new temp(5));
	list.add(new temp(10));
	Collection<temp> unm=Collections.unmodifiableCollection(list);// cannot even cast to ArrayList<temp> unm=(ArrayList<temp>)Collections.unmodifiableCollection(list);
	//throwns class cast exception
	//unm.add(new temp(15));//java.lang.UnsupportedOperationException at runtime
	list.add(new temp(15));
	temp t = list.get(0);
	t.i=99;
	//t = ((ArrayList <temp> )unm).get(0);//Exception in thread "main" java.lang.ClassCastException: java.util.Collections$U
	//nmodifiableCollection cannot be cast to java.util.ArrayList
	//        at collectionss.main(collectionss.java:23) at runtime
	
	t=(temp)unm.iterator().next();
	System.out.println(t.i);
	t.i=109;
	System.out.println(t.i);
}

//http://docs.oracle.com/javase/6/docs/api/java/util/Collections.html#synchronizedCollection%28java.util.Collection%29
//just like unmodifiable , synchronized has same set of functions.
static public void learnsynchronizedInterface(){
	System.out.println("learnsynchronizedInterface");
	ArrayList <temp> list=new ArrayList<temp>();
	list.add(new temp(5));
	list.add(new temp(10));
	Collection<temp> unm=Collections.synchronizedCollection(list);// cannot even cast to ArrayList<temp> unm=(ArrayList<temp>)Collections.unmodifiableCollection(list);
	//throwns class cast exception
	//unm.add(new temp(15));//java.lang.UnsupportedOperationException at runtime
//	Iterator itunm = list.iterator(); If we define iterator, then after that we cannot modify collection.i.e. cannot add or remove
	list.add(new temp(15));
	temp t = list.get(0);
	t.i=99;
	Iterator itunm = unm.iterator();///getting iterator of list will also do. but may not be synchronized
	//t = ((ArrayList <temp> )unm).get(0);//Exception in thread "main" java.lang.ClassCastException: java.util.Collections$U
	//nmodifiableCollection cannot be cast to java.util.ArrayList
	//        at collectionss.main(collectionss.java:23) at runtime
	while(itunm.hasNext()){
		t=(temp)itunm.next();
		System.out.println(t.i);
		t.i=109;
		System.out.println(t.i);
	}
	
}

  
public static void main(String args[]){ 
/************************************************Collections.unmodifiableInterface**************************************/
learnunmodifiableInterface();
/************************************************Collections.synchronizedInterface**************************************/
learnsynchronizedInterface();
 }  
}  

