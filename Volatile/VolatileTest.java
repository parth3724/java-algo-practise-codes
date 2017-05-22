public class VolatileTest {


    private static volatile int MY_INT = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {
        @Override
        public void run() {
		int local_value=0;
			while (MY_INT <100){ 
			    if(local_value != MY_INT){
                local_value = MY_INT;          
                    System.out.println("listener = "+local_value);
                     local_value= MY_INT;
				}
            }
        }
    }

    static class ChangeMaker extends Thread{
        @Override
        public void run() {         
            while (MY_INT <100){ 
                MY_INT = ++MY_INT;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }
}