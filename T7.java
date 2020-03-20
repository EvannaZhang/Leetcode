package leetcode;
import java.util.*;

public class T7 {
	 public static int myAtoi(String str) {
	        int len = str.length();
	        int i = 0;
	        int flag = 0;
	        int position = 0;
	        int fir = 0;
	        while(i<len){
	        	//System.out.println(i);
	            char c = str.charAt(i);
	            //System.out.println(c);
	            int value = (int)c - 48;
	            //System.out.println(value);
	            if(c ==' '||value==0){
	                i++;
	                position++;
	                continue;
	            }
	            else{
	                if(c=='+'||c=='-'){
	                    if(c=='-'){
	                        flag = 1;
	                    }
	                    position = i+1;
	                    break;
	                }
	                else if(value>-1&&value<10){
	                    position = i;
	                    break;
	                }
	                else{
	                    return 0;
	                }
	            }
	            
	        }
	        if(len>0){
	        if(position==len&&(int)str.charAt(len-1)-48>-1&&(int)str.charAt(len-1)-48<10)
	            return (int)str.charAt(len-1) - 48;
	   }
	       // System.out.println(position);
	        Queue<Integer> ans = new LinkedList<Integer>();
	        int count = 0;
	        for(int j = position; j<len; j++){
	        	//System.out.println((int)str.charAt(j)-48);
	            if((int)str.charAt(j)-48>-1&&(int)str.charAt(j)-48<10){
	                if((int)str.charAt(j)-48 == 0){
	                	if(fir == 0)
	                		continue;
	                }
	                ans.offer((int)str.charAt(j)-48);
	              //  System.out.println(ans);
	              if ((int)str.charAt(j)-48 != 0){
	                  fir = 1;
	              }
	               count++;
	                
	            }
	            else{
	                break;
	            }
	        }
	       // System.out.println(count);
	        if(count>10){
	            if(flag == 0)
	                return 2147483647;
	            else
	                return -2147483648;
	        }
	        int answer = 0;
	       // System.out.println(ans);
	        while(!ans.isEmpty()){
	            answer = answer*10+ans.poll();
	            //System.out.println(answer);
	            if(flag==0&&answer>214748363){
	            	if(ans.peek()!=null) {
	            		//System.out.println(ans.peek());
	                	if(ans.peek()>7||answer>214748364)
	                		return 2147483647;
	                }
	            }
	            if(flag==1&&answer>214748363){
	                if(ans.peek()!=null) {
	                	if(ans.peek()>8||answer>214748364){
	                		return -2147483648;
	                	}
	                }
	                    
	            }
	        }
	        if(flag==0)
	            return answer;
	        else
	            return -answer;
	    }
	public static void main(String[] args) {
		System.out.println(myAtoi("2147483800"));
	}
}
