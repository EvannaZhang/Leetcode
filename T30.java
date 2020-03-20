package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T30 {
	 public static List<Integer> findSubstring(String s, String[] words) {
	        List<Integer> ans = new ArrayList<Integer>();
	        int len = words.length;
	        if(words.length<1)
	        	return ans;
	        int length = words[0].length();
	        int[] search = new int[s.length()];
	        HashMap<String, Integer> store = new HashMap<String, Integer>();
	        for(int i = 0; i<words.length; i++) {
	        	if(store.containsKey(words[i])) {
	        		int tmp = store.get(words[i]);
	        		store.replace(words[i], tmp, tmp+1);
	        	}
	        	else {
	        		store.put(words[i], 1);
	        	}
	        }
	        HashMap<String, Integer> tmp;
	        for(int i=0; i<=s.length()-len*length; i++) {
	        	boolean add = true;
	        	tmp = (HashMap<String, Integer>) store.clone();
	        	for(int j=0; j<len; j++) {
	        		String sub = s.substring(i+j*length, i+length+j*length);
	        		if(i==9) {
	        			System.out.println(sub);
	        		}
	        		if(tmp.containsKey(sub)) {
	        			int t = tmp.get(sub);
	                    if(t<=0){
	                        add = false;
	                        break;
	                    }
	            		tmp.replace(sub, t, t-1);
	        		}else {
	        			add = false;
	        			break;
	        		}
	        		
	        	}
	        	for(Integer n:tmp.values()) {
	        		if(n>0) {
	        			add = false;
	        		}
	        	}
	        	if(add) {
	        		ans.add(i);
	        	}
	        }
	       
	        return ans;
	    }
	public static void main(String[] args) {
		String[] words = {"foo","bar"}; 
		System.out.println(findSubstring("barfoothefoobarman", words));
	}

}
