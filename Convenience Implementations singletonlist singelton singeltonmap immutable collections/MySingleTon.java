import java.util.*;

public class MySingleTon{  
public MySingleTon(){
value=0;
}
public MySingleTon(int v){
value=v;
}
/*
	Arrays.asList - Allows an array to be viewed as a list. Returns a fixed-size list backed by 
	the specified array. The returned list is serializable and implements RandomAccess. 
*/
public static void learnAsList(){
	System.out.println("*********************learn Arrays.asList()************************");
	MySingleTon array[] = new MySingleTon[2];
	array[0] = new MySingleTon(10);
    array[1] = new MySingleTon(110);
	List<MySingleTon> list = Arrays.asList(array);
//	list.add(new MySingleTon(90));//java.lang.UnsupportedOperationException at runtime
MySingleTon tem = list.get(0);
tem.value = 1010;
System.out.println(array[0].value);
System.out.println(list.get(0).value);
}
int value ;
public static void main(String args[]){  
MySingleTon original = new MySingleTon(40);
Set <MySingleTon> immutableSingletonSet = Collections.singleton(original);
Iterator i1 = immutableSingletonSet.iterator();
MySingleTon tem = (MySingleTon)i1.next();
System.out.println(tem.value);
tem.value = 50;
System.out.println(tem.value);
System.out.println(original.value);
//immutableSingletonSet.add(new MySingleTon(40));//java.lang.UnsupportedOperationException
//i1.remove();////java.lang.UnsupportedOperationException
Map <Integer,MySingleTon> imSingletonMap = Collections.singletonMap(50,original);
tem = (MySingleTon)imSingletonMap.get(50);
System.out.println(tem.value);
tem.value = 60;
System.out.println(original.value);

//imSingletonMap.put(50,new MySingleTon(80));//java.lang.UnsupportedOperationException
/*********************************************learn Arrays.asList()********************************************/
learnAsList();
}}