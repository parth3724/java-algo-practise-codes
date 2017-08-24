import java.util.*;
import java.util.concurrent.*;
public class User{	
	public static void main(String args[]){
		int queueCapacity = 3;
		int maxProduce=18;
		ProducerConsumer tem;
		tem= new Pc3(queueCapacity);/////////create new class to experiment and just change this line
		new consumerThread(tem,maxProduce).start();
		new producerThread(tem,maxProduce).start();		
	}	
 }
 class producerThread extends Thread{
	final ProducerConsumer mPc;
	final int max;
	public void run(){
		for(int i=0;i<max;i++){
			try{
				mPc.produce(i);
				sleep(300);
			} catch(InterruptedException e){
				
			}			
		}
	}
	public producerThread(ProducerConsumer p,int m){
		mPc=p;max=m;
	}
 }
 class consumerThread extends Thread{
	final ProducerConsumer mPc;
	final int max;
	public void run(){
		for(int i=0;i<max;i++){
			try{
				mPc.consume();
				sleep(400);
			} catch(InterruptedException e){
				
			}
		}
	}
	public consumerThread(ProducerConsumer p,int m){
		mPc=p;max=m;
	}
 }
 interface ProducerConsumer{
	public void produce(int n) throws InterruptedException;
	public int consume() throws InterruptedException;
 }
 class Pc implements ProducerConsumer{//from Geeks for Geeks
	 LinkedList<Integer> list = new LinkedList();
	 final int capacity;
	 public Pc(int n){capacity=n;}
	 public void produce(int n) throws InterruptedException{
		synchronized(this){
			while(list.size()==capacity) 
				this.wait();
			list.add(n);
			System.out.println("Added "+n);
			notify();
		}
	 }
	 public int consume() throws InterruptedException{
		 synchronized(this){
			 while(list.size()==0) 
			 this.wait();
			 int ans = list.poll();
			 notify();
			 System.out.println("returned "+ans);
			 return ans;
		 }
	 }
 }
 class Pc2 implements ProducerConsumer{//using collection
	 LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue();	 
	 public Pc2(int n){queue = new LinkedBlockingQueue(n);}
	 public void produce(int n) throws InterruptedException{
		queue.put(n);
	 }
	 public int consume() throws InterruptedException{
		 return queue.take();
	 }
 }
 class Pc3 implements ProducerConsumer{//using semaphores
	 LinkedList<Integer> list = new LinkedList();
	 private final Semaphore empty,filled;
	 public Pc3(int n){ empty= new Semaphore(n,true);filled = new Semaphore(0,true);}
	 public void produce(int n) throws InterruptedException{
		empty.acquire();
		list.add(n);
		System.out.println("Added "+n);
		filled.release();
	 }
	 public int consume() throws InterruptedException{
		filled.acquire();
		int ans = list.poll();		
		System.out.println("returned "+ans);
		empty.release();
		return ans;		 
	 }
 }