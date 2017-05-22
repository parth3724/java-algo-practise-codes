//http://www.geeksforgeeks.org/majority-element/
class MooresVoting{
	//public static int ar[];
	public static int majority_index=-1;
	public static int m_count=0;
	public static void main(String args[]){
	int ar[] = {3,3,4,2,4,4,2,4};
		int i = getMajorityIndex(ar);
		if(checkMajority(ar,i))
			System.out.println(ar[i]);
		else
			System.out.println("NONE");
	}
	
	public static int getMajorityIndex(int ar[]){		
		if(ar==null || ar.length==0)
			return -1;
		m_count=0;
		for(int i=0;i<ar.length;i++){
			if(m_count==0){
				m_count=1;
				majority_index=i;
			}
			else if(ar[majority_index]==ar[i])
				m_count++;
			else
			    m_count--;
		}
		return majority_index;
	}
	
	public static boolean checkMajority(int ar[],int index){
	    if(ar==null || ar.length==0)
			return false;
		int c=0;
		for(int i=0;i<ar.length;i++){
			if(ar[i]==ar[index])
				c++;
		}
		if(c>Math.floor(ar.length/2))
			return true;
		return false;
		
	}
	
}