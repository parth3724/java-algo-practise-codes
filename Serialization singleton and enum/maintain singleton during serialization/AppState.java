//https://stackoverflow.com/questions/2958863/interview-question-about-java-serialization-and-singletons
//https://docs.oracle.com/javase/7/docs/api/java/io/ObjectOutputStream.html
// This code shows how to prevent singleton in case of serializatoin.

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

	public static void simulateDestruction(){
	s_instance=null;
	}
	
    private AppState() {
        // initialize
		System.out.println("constructor called");
    }
    /*
	 This function is called by deserialization process. When this function is called, stream is read, object is initialized (created).
	 this is equivalent to constructor and hence constructor is not called.
	*/
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
	// our "pseudo-constructor"
	System.out.println("readObject " + (s_instance == this));//however for a shorter period of time, more than one instances are created even in case of singleton.
        ois.defaultReadObject();//Read the non-static and non-transient fields of the current class from this stream. This may only be called from the readObject method of the class being deserialized. It will throw the NotActiveException if it is called otherwise.
        
    }

    // this function must not be called other than by the deserialization runtime
    private Object readResolve() throws ObjectStreamException {//if not override this function, new instance is returned.	
        synchronized (AppState.class) {
            if (s_instance == null) {//make sure at least one instance is created re-initialize if needed.
                s_instance = this; // only if everything succeeds
            }
        }		
		System.out.println("resolve called");
        return s_instance;
    }

    public static void main(String[] args) throws Throwable {
        assert(getInstance() == getInstance());

            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
            oos.writeObject(getInstance());
            oos.close();
			
			simulateDestruction();
            java.io.InputStream is = new java.io.ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(is);
            AppState s = (AppState)ois.readObject();
				System.out.println(s == getInstance());
    }
}