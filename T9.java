package leetcode;
import java.util.*;

public class T9 {
	public static boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        ArrayList<Integer> num = new ArrayList<Integer>();
        while(x>=10){
            num.add(x%10);
            x = x/10;
        }
        num.add(x);
        int len = num.size();
        System.out.println(num);
        if(len%2==0){
            int mid = len/2;
            for(int i = mid-1; i>-1; i--){
                if(num.get(i)!=num.get(len-1-i)){
                    return false;
                }
            }
        }else{
            for(int i = len/2-1; i>-1; i--){
                if(num.get(i)!=num.get(len/2+len/2-i)){
                    return false;
                }
            }
        }
        return true;
    }
	public static void main(String[] args) {
		System.out.println(isPalindrome(10));
	}
}
