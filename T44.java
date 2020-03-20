package leetcode;

public class T44 {
	 public static boolean isMatch(String s, String p) {
			if((s==null||s=="")&&(p==null||p=="")) {
		 		return true;
		 	}else if(s == null||s == "") {
		 		for(int i=0; i<p.length(); i++) {
		 			if(p.charAt(i)!='*') {
		 				return false;
		 			}
		 		}
		 		return true;
		 	}else if(p == null||p=="") {
		 		return false;
		 	}
	        int l1 = s.length();
	        int l2 = p.length();
	        int i = 0;
	        int j = 0;
	        while(i<l1&&j<l2){
	            if(s.charAt(i)==p.charAt(j)){
	            	if(i==l1-1&&j==l2-1) {
	            		return true;
	            	}
	                i++;
	                j++;
	            }else if(p.charAt(j)=='?'){
	            	if(i+1<l1&&j+1<l2) {
	            		return isMatch(s.substring(i+1), p.substring(j+1));
	            	}else if(i+1<l1) {
	            		return false;
	            	}else if(j+1<l2) {
	            		return isMatch(null, p.substring(j+1));
	            	}else {
	            		return true;
	            	}
	            }else if(p.charAt(j)=='*'){
	            	if(j+1<l2) {
	            		if(p.charAt(j+1)=='?') {
	            			boolean temp = false;
	            			for(int k=i; k<l1; k++) {
	            				temp = temp||isMatch(s.substring(k), p.substring(j+1));
	            				if(temp)
	            					return true;
	            			}
	            			return false;
	            		}else if(p.charAt(j+1)=='*') {
	            			return isMatch(s.substring(i), p.substring(j+1));
	            		}else {
	            			boolean temp = false;
	            			for(int k=i; k<l1; k++) {
	            				if(s.charAt(k)==p.charAt(j+1)) {
	            					temp = temp||isMatch(s.substring(k), p.substring(j+1));
	            					if(temp)
		            					return true;
	            				}
	            			}
	            			return false;
	            		}
	            	}else{
	            		return true;
	            	}
	            }else{
	                return false;
	            }
	        }
	        return false;
	        
	    }
	 
	 public static void main(String[] args) {
		 System.out.println(isMatch(""
				, "*"));
	 }

}
