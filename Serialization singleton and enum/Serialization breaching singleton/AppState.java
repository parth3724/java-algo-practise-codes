//https://stackoverflow.com/questions/2958863/interview-question-about-java-serialization-and-singletons
//https://docs.oracle.com/javase/7/docs/api/java/io/ObjectOutputStream.html
// This code shows how to during serailization and deserialization, signleton is not maintained and more than one instances are created.

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class AppState implements Serializable
{
    private static AppState s_instance = null;

    public static synchronized AppState getInstance() {
        if (s_instance == null) {
            s_instance = new AppState();
        }
        return s_instance;
    }

    private AppState() {
        // initialize
		System.out.println("constructor called");
    }
    
    public static void main(String[] args) throws Throwable {
        assert(getInstance() == getInstance());

            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
            oos.writeObject(getInstance());
            oos.close();

            java.io.InputStream is = new java.io.ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(is);
            AppState s = (AppState)ois.readObject();
				System.out.println(s == getInstance());
    }
}