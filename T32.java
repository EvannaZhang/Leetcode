package leetcode;

import java.util.Stack;

public class T32 {
	public static int longestValidParentheses(String s) {
		int ans = 0;
		Stack<Integer> string = new Stack<>();
		int position = 0;
		while(position<s.length()) {
			if(s.charAt(position)=='(') {
				string.add(0);
				break;
			}
			position++;
		}
		int dis = 0;
		int i = position+1;
		int temp = 0;
		boolean justdis = false;
		while(i<s.length()) {
			if(s.charAt(i)=='(') {
				if(justdis == false)
					temp = 0;
				string.add(0);
				i++;
				justdis = false;
			}else if(s.charAt(i)==')'){
				if(string.isEmpty()) {
					dis = 0;
					temp = 0;
					i++;
					justdis = false;
					continue;
				}
				if(string.peek()==0) {
					//()
					i++;
					if(string.size()==1) {
						temp=0;
						dis++;
						justdis = true;
						string.pop();
						if(dis>ans)
							ans = dis;
					}
					else{
						dis++;
						justdis = true;
						string.pop();
						temp++;
						if(temp>ans)
							ans = temp;
					}
				}else{
					dis = 0;
					justdis = false;
					temp = 0;
					i++;
					//))	
				}
			}
		}
		return ans*2;
        
    }
	public static void main(String[] args) {
		System.out.println(longestValidParentheses(")(((((()())()()))()(()))("));
	}


}
