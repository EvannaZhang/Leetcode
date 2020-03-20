package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T51 {
	static List<List<String>> ans = new ArrayList<>();
	 	static int[][] temp;
	 	static int[] down;
	 	static int[] up;
		public static List<List<String>> solveNQueens(int n) {
			 	ans.clear();
		        temp = new int[n+1][n+1];
		        down = new int[2*n-1];
		        up = new int[2*n-1];
		        backtrack(n, 1, 0);
		        return ans;
		        
		    }
	 	public static boolean ava(int i, int j, int n) {
	 	
	 		if(temp[i][j]==0 && temp[i][0] == 0&& temp[0][j]==0) {
	 			if(up[i+j-2]==0&&down[n-1-i+j]==0) {
	 				return true;
	 			}
	 		}
	 		return false;
	 	}
	 	
	    public static void backtrack(int n, int column, int count){
//	    	for(int i=1; i<=n; i++) {
//	    		for(int j=1; j<=n; j++) {
//	    			//System.out.print(temp[i][j]+" ");
//	    		}
//	    		//System.out.println();
//	    	}
	    	 if(column==n+1){
	                List<String> ttt = describe(temp,n);
	                if(!ans.contains(ttt))
	                   ans.add(describe(temp,n));
	                return;
	         }
	    	 
	    	for(int i=1; i<=n; i++) {
	    		// 1 5 4
	    		if(ava(i, column, n)) {
	    			put(i, column, n);
	    			backtrack(n, column+1, count+1);
	    			remove(i, column, n);
	    		}
	    	}
	       
	        	
	    }
	    
	    private static void remove(int i, int j, int n) {
			temp[i][j] = 0;
			temp[i][0] = 0;
			temp[0][j] = 0;
			up[i+j-2] = 0;
			down[n-1-i+j] = 0;
			
		}
		public static void put(int i, int j, int n) {
	    	temp[i][j] = 1;
	    	temp[i][0] = -1;
	    	temp[0][j] = -1;
	    	up[i+j-2] = -1;
	    	down[n-1-i+j] = -1;;
	    	
	    }
	    

	    public static List<String> describe(int[][] temp, int n){
	        List<String> ans = new ArrayList<>();
	        for(int i=1; i<=n; i++){
	            StringBuilder sb = new StringBuilder();
	            for(int j=1; j<=n; j++){
	                if(temp[i][j]==1)
	                    sb.append('Q');
	                else
	                    sb.append('.');
	            }
	            ans.add(sb.toString());
	        }
	        return ans;
	    }
	    
	    public static void main(String[] args) {
	    	System.out.println(solveNQueens(8)); 
	    }

}
