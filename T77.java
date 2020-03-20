package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T77 {
	 static List<List<Integer>> ans = new ArrayList<List<Integer>>();
	 
	 public static List<List<Integer>> combine(int n, int k) {
		 ans.clear();
		 for(int i=1; i<=n-k+1; i++) {
			 List<Integer> t = new ArrayList<Integer>();
			 t.add(i);
			 match(t, i+1, n, k);
		 }
		 return ans;
		 
	 }

	 public static void match(List<Integer> t, int begin, int end, int k){
		 if(t.size()==k) {
			 ans.add(t);
			 return;
		 }
		 if(t.size()>k) {
			 return;
		 }
		 else if(t.size()<k&&begin<=end) {
			 if(end-begin+1>=k-t.size()) {
				 for(int i=begin; i<=end; i++) {
					List<Integer> now = new ArrayList<Integer>();
					for(Integer j: t)
						now.add(j);
					now.add(i);
					match(now, i+1, end, k);
				 }
			 }
		}
		 
	 }
    
	 public static void main(String[] args) {
		 System.out.println(combine(4, 2));
	 }

}
