package leetcode;

public class T69 {
	public static int mySqrt(int x) {
		 	if(x==0)
	            return 0;
	        else if(x==1)
	            return 1;
	        return (int)binary(1, x/2+1, x);
    }
	
	 public static long binary(long left, long right, long target){
		 	//System.out.println(left+" "+right);
	        if(left<right-1){
	            long mid = (left+right)/2;
	            long t = mid*mid; 
//	            System.out.println(mid);
//	            System.out.println(t);
//	            System.out.println(target);
	            if(t==target)
	                return mid;
	            if(t<target)
	                return binary(mid, right, target);
	            else
	                return binary(left, mid-1, target);
	        }else {
	        	if(right*right<=target)
	        		return right;
	        	else
	        		return left;
	        }
	           
	    }
	 
	
	 public static void main(String[] args) {
		 System.out.println(mySqrt(2147395599));
	 }

}
