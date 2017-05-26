//https://stackoverflow.com/questions/2958863/interview-question-about-java-serialization-and-singletons
//https://docs.oracle.com/javase/7/docs/api/java/io/ObjectOutputStream.html
// This code shows how to during serailization and deserialization, only single instance of enum is maintained and hence making it
// best way to implement singleton.
//https://docs.google.com/document/d/1uZ7flC1HQuaEUSQ_iTiQygn_HN94J6dNf87OYkIiB0s/edit#
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
    
    public static void main(String[] args) throws Throwable {
        Season s = Season.Winter;
		Days d = Days.today;
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
            oos.writeObject(s);
			oos.writeObject(d);
            oos.close();

            java.io.InputStream is = new java.io.ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(is);
			Season s2 = (Season)ois.readObject();
			Days d2 = (Days)ois.readObject();
            
				
		System.out.println(s == s2);
		System.out.println(d == d2);		
    }
	enum Season{
		Winter,
		Summer
	}
	enum Days{
		today(10),
		Yesterday(20);
		int value;
		Days(int i){
			value=i;
		}
	}
}