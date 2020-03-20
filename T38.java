package leetcode;

public class T38 {
	  public static String countAndSay(int n) {
	        if(n==1)
	            return "1";
	        else if(n==2)
	            return "11";
	        else if(n==3)
	            return "21";
	        else if(n==4)
	            return "1211";
	        else if(n==5)
	            return "111221";
	        else
	            return describe(n);
	    }
	    public static String describe(int n){
	        String last = countAndSay(n-1);
	        String ans = "";
	        int i = 0;
	        int current = 0;
	        int count = 0;
	        while(i<last.length()){
	            if(i==0){
	                current = (int)last.charAt(i)-48;
	                count = 1;
	                if(i==last.length()-1) {
	                	StringBuilder stringBuilder = new StringBuilder(ans);
		            	stringBuilder.append(count);
		            	stringBuilder.append(current);
		            	ans = stringBuilder.toString();
		            	return ans;
	                }
	                i++;
	                continue;
	            }
	            if((int)last.charAt(i)-48==current) {
	            	count++;
	            	if(i==last.length()-1) {
	            		StringBuilder stringBuilder = new StringBuilder(ans);
		            	stringBuilder.append(count);
		            	stringBuilder.append(current);
		            	ans = stringBuilder.toString();
		            	return ans;
	            	}
	            	i++;
	            	continue;
	            }else {
	            	StringBuilder stringBuilder = new StringBuilder(ans);
	            	stringBuilder.append(count);
	            	stringBuilder.append(current);
	            	ans = stringBuilder.toString();
	            	current = (int)last.charAt(i)-48;
	            	count = 1;
	            	if(i==last.length()-1) {
	            		StringBuilder s = new StringBuilder(ans);
		            	s.append(count);
		            	s.append(current);
		            	ans = s.toString();
		            	i++;
		            	return ans;
	            	}
	            	i++;
	            	continue;
	            }
	            
	        }
	        return ans;
	    }
	    public static void main(String[] args) {
	    	System.out.println(countAndSay(6));
	    }

}
