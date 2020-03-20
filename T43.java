package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class T43 {
	 public static String multiply(String num1, String num2) {
	        int l1 = num1.length();
	        int l2 = num2.length();
	        Queue<Integer>[] add = new LinkedList[l2];
	        for(int i=0; i<l2; i++){
	            Queue<Integer> now = new LinkedList<Integer>();
	            int last_add = 0;
	            for(int j=l1-1; j>-1; j--){
	                //j of num1, i of num2
	                int temp = ((int)num2.charAt(l2-1-i)-48)*((int)num1.charAt(j)-48)+last_add;
	                last_add = temp/10;
	                now.offer(temp%10);
	            }
	            if(last_add!=0)
	                now.offer(last_add);
	            add[i] = now;
	        }
	        int i = 0;
	        int last = 0;
	        Stack<Integer> ans = new Stack<Integer>();
	        while(true){
	            boolean con = false;
	            int now = last;
	            for(int j=0; j<=i&&j<l2; j++){
	                if(!add[j].isEmpty()){
	                    now += add[j].poll();
	                    con = true;
	                }
	            }
	            last = now/10;
	            ans.add(now%10);
	            if(con==false){
	                if(last>0){
	                    ans.add(last);
	                }
	                break;
	            }
	            i++;
	        }
	        StringBuilder sb = new StringBuilder();
	        boolean first = true;
	        while(!ans.isEmpty()){
	        	int n = ans.pop();
	        	if(first==true&&n==0) {
	        		continue;
	        	}
	            sb.append(n);
	            first = false;
	        }
	        if(first==true)
	        	return "0";
	        return sb.toString();
	    }
	 public static void main(String[] args) {
		 System.out.println(multiply("123", "45"));
	 }

}
