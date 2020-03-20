package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class pair{
	int a, b;
	public pair(int m, int n) {
		this.a = m;
		this.b = n;
	}
}
public class T62 {
	public static int uniquePaths(int m, int n) {
	        int ans = 0;
	        Queue<pair> tmp = new LinkedList<pair>();
	        tmp.add(new pair(0,0));
	        while(!tmp.isEmpty()) {
	        	for(int i=0; i<tmp.size(); i++) {
	        		pair now = tmp.poll();
	        		pair right = new pair(now.a+1, now.b);
	        		pair down = new pair(now.a, now.b+1);
	        		if(right.a==m-1&&right.b==n-1) {
	        			ans++;
	        		}else if(right.a<m&&right.b<n)
	        				tmp.add(right);
	        		if(down.a==m-1&&down.b==n-1) {
	        			ans++;
	        		}else if(down.a<m&&down.b<n) {
	        				tmp.add(down);
	        		}
	        	}
	        }
	        return ans;
	    }
	
	public static void main(String[] args) {
		System.out.println(uniquePaths(3,2));
	}

}
