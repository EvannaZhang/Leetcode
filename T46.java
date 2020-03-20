package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T46 {
	public static List<List<Integer>> permute(int[] nums) {
       return permute(nums, 0, nums.length-1);

    }
	public static List<List<Integer>> permute(int[] nums, int begin, int end) {
			if(begin>end)
				return null;
	        if(end-begin+1==1){
	            List<Integer> t = new ArrayList<Integer>();
	            t.add(nums[begin]);
	        	List<List<Integer>> ans = new ArrayList<>();
	            ans.add(t);
	            return ans;
	        }
	        else if(end-begin+1==2){
	            List<Integer> t = new ArrayList<Integer>();
	            t.add(nums[begin]);
	            t.add(nums[begin+1]);
	        	List<List<Integer>> ans = new ArrayList<>();
	            ans.add(t);
	            if(nums[begin]==nums[begin+1])
	            	return ans;
	            List<Integer> s = new ArrayList<Integer>();
	            s.add(nums[begin+1]);
	            s.add(nums[begin]);
	            ans.add(s);
	            return ans;
	        }else{
	        	List<List<Integer>> ans = new ArrayList<>();
	        	List<List<Integer>> last = permute(nums, begin+1, end);
	        	for(List<Integer> t: last) {
	        		for(int i=0; i<=t.size(); i++) {
	        			List<Integer> now = new ArrayList<Integer>();
	        			for(int j=0; j<t.size(); j++) {
	        				if(j<i)
	        					now.add(t.get(j));
	        				if(j==i)
	        					now.add(nums[begin]);
	        				if(j>i)
	        					now.add(t.get(j-1));
	        			}
	        			if(i==t.size())
	        				now.add(nums[begin]);
	        			else 
	        				now.add(t.get(t.size()-1));
	        			if(!ans.contains(now))
	        				ans.add(now);
	        		}
	        	}
	        	return ans;
	        }
	}
	public static void main(String[] args) {
		int[] tmp = {1,2,3};
		System.out.println(permute(tmp));
	}
}
