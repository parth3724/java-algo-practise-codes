


import java.net.*;
import java.io.*;



public class MyClassLoader extends ClassLoader{

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    public Class loadClass(String name) throws ClassNotFoundException {
        if(!"MyObject".equals(name))
                return super.loadClass(name);

        try {
            String url = "file:C:\\Users\\lenovo\\Desktop\\RISE\\gate & CS books\\algos all kinds & Programming languages\\java practise\\reflection\\Reflection and classReloading\\MyObject.class";
            URL myUrl = new URL(url);
            URLConnection connection = myUrl.openConnection();
            InputStream input = connection.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int data = input.read();

            while(data != -1){
                buffer.write(data);
                data = input.read();
            }

            input.close();

            byte[] classData = buffer.toByteArray();

            return defineClass("MyObject",
                    classData, 0, classData.length);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
			System.out.println("finally");
		}

        return null;
    }
	public static void main(String[] args) throws
    ClassNotFoundException,
    IllegalAccessException,
    InstantiationException {

    ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
    MyClassLoader classLoader = new MyClassLoader(parentClassLoader);
    Class myObjectClass = classLoader.loadClass("MyObject");

	 MyObjectSuperClass object2 =
            (MyObjectSuperClass) myObjectClass.newInstance();
			
    AnInterface2       object1 =
            (AnInterface2) myObjectClass.newInstance();

   

    //create new class loader so classes can be reloaded.
    classLoader = new MyClassLoader(parentClassLoader);
    myObjectClass = classLoader.loadClass("MyObject");

    object1 = (AnInterface2)       myObjectClass.newInstance();
    object2 = (MyObjectSuperClass) myObjectClass.newInstance();

}

}





