class EnsureCapac{  
public static void main(String args[]){  
StringBuffer sb=new StringBuffer();  
System.out.println(sb.capacity());//default 16  
sb.append("Hello");  
System.out.println(sb.capacity());//now 16  
sb.append("java is my favourite language");  
System.out.println(sb.capacity());//now (16*2)+2=34 i.e (oldcapacity*2)+2  
sb.ensureCapacity(10);//now no change  
System.out.println(sb.capacity());//now 34  
sb.ensureCapacity(80);//now (34*2)+2 = 70 or 80
System.out.println(sb.capacity());//now 80
}  
}  