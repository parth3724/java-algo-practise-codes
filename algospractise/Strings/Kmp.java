class Kmp{// complexity = O(2n); ~ O(n).
	/*
	KMP typically has an inner loop and an outer loop. The pattern string pointer or longest matching 
	prefix variable i is initialized with 0 and it is incremented in steps of 1 in the outer loop at 
	most n times (the length of the text string). The inner loop iteratively decreases i by some 
	non-zero amount, but it stops at 0 and it never increases i. Hence the inner loop can 
	only decrease i when the outer loop has previously incremented it which can happen at most n times.
You can think of the value of i
as a resource that is produced by the outer loop in steps of 1 and consumed by the 
		inner loop in steps of ?1 until it is exhausted. The worst case thus takes 2n 
		loop iterations (n increments and n decrements) and hence KMP runs in O(n) 
		(disregarding the construction of the prefix table which takes O(m) by a similar argument).
	*/
	public static void main(String args[]){
		String p="aaa";
		String s="aaabaaa";
		preProcessPattern(p);
		findPatternInString(s,p);
	}
	static int pi[];
	public static void preProcessPattern(String s){
		pi=new int[s.length()];
		pi[0]=-1;
		int k=-1;
		for(int i=1;i<s.length();i++){
			char c = s.charAt(i);
			while(k>=0 && s.charAt(k+1)!=c){
				k=pi[k];
			}
			if(s.charAt(k+1)==c){
				k++;
			}
			pi[i]=k;
		}
		for(int i=0;i<pi.length;i++)
			System.out.print(pi[i]+" ");
		System.out.println();
	}
	public static void findPatternInString(String s,String p){
	    int k=-1;
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			while(k>=0 && s.charAt(k+1)!=c){
				k=pi[k];
			}
			if(p.charAt(k+1)==c){
				k++;
				if(k==(pi.length-1)){
					System.out.println("pattern match ending at "+i);
					k=pi[k];
				}
			}
		}
	}
	
}