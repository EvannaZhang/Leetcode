package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T54 {
	 static List<Integer> ans = new ArrayList<Integer>();
	 	static int[][] m;
     static boolean[][] check;
     static int count = 0;
	    public static List<Integer> spiralOrder(int[][] matrix) {
	        ans.clear();
	        m = matrix;
         count = 0;
         if(matrix.length<1)
             return ans;
         else if(matrix.length==1){
             for(int i=0; i<matrix[0].length; i++){
                 ans.add(matrix[0][i]);
             }
             return ans;
         }
         check = new boolean[matrix.length][matrix[0].length];
         for(int i=0; i<matrix.length; i++){
             for(int j=0; j<matrix[0].length; j++){
                 check[i][j] = false;
             }
         }
	        right(0, 0);
	        
	        return ans;
	        
	    }
	    public static void right(int row, int column) {
	    	int c = 0;
	    	for(int i=column; i<m[0].length; i++) {
	    		if(check[row][i]==false) {
	    			ans.add(m[row][i]);
	    			check[row][i] = true;
	    			c = i;
	    		}else {
	    			if(i==column){
                     count++;
                     if(count>=4)
	    				    return;
	    			}
	    		 	down(row, c);
	    			return;
	    		}
	    	}
	    	down(row, c);
	    	return;
	    }
	    
	    private static void down(int row, int column) {
	    	System.out.println(row+""+column);
	    	int c = 0;
			for(int i = row+1; i<m.length; i++) {
				if(check[i][column]==false) {
					ans.add(m[i][column]);
					check[i][column] = true;
					c = i;
					System.out.println("EDfrdd"+i);
				}else {
					if(i==row+1){
                     count++;
                     if(count>=4)
	    				    return;
                 }
					left(c, column);
					return;
				}
			}
			left(c, column);
			return;
			
		}
		private static void left(int row, int column) {
			int c = 0;
			for(int i=column-1; i>-1; i--) {
				if(check[row][i]==false) {
					ans.add(m[row][i]);
					check[row][i] = true;
					c = i;
				}else {
					if(i==column-1){
                     count++;
                     if(count>=4)
	    				    return;
                 }
					up(row, c);
					return;
				}
			}
			up(row, c);
			return;
			
		}
		private static void up(int row, int column) {
		 
			int c = 0;
			for(int i=row-1; i>-1; i--) {
				if(check[i][column]==false) {
					ans.add(m[i][column]);
					check[i][column] = true;
					c = i;
				}else {
					if(i==row-1){
                     count++;
                     if(count>=4)
	    				    return;
                 }
					right(c, column+1);
					return;
				}
			}
			right(c, column+1);
			return;
			
		}
		public static void main(String[] args) {
	    	int[][] t = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	    	System.out.println(spiralOrder(t));
	    }

}
