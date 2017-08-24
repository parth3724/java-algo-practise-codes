

import java.util.*;
import java.lang.*;
import java.io.*;

class B{
	int b=1;	
}
class A extends B implements Serializable{
	int a = 2;	
}
class C extends B implements Serializable{
	int c=4;
	private void writeObject(ObjectOutputStream oos) throws IOException{
		oos.defaultWriteObject();
		oos.writeInt(b);
	}
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException{
		ois.defaultReadObject();
		b=ois.readInt();
	}
}
/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		ObjectOutputStream out=new ObjectOutputStream(b); 
		
		
		A ss = new A();
		C s2 = new C(); s2.c=5;s2.b=5;
		ss.b=5;
		ss.a=5;
		out.writeObject(ss);
		out.writeObject(s2);
		ByteArrayInputStream bin = new ByteArrayInputStream(b.toByteArray());
		ObjectInputStream in = new ObjectInputStream(bin);
		A nn = (A)in.readObject();
		C nc = (C)in.readObject();
		System.out.println(nn.a+" "+nn.b);//5 1
		System.out.println(nc.b+" "+nc.c);//5 5
		
		// your code goes here
	}
}