package leetcode;
import java.util.ArrayList;

public class T60 {
	public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        k=k-1;
        ArrayList<Integer> remain = new ArrayList<Integer>();
        for(int i=1; i<=n; i++){
            remain.add(i);
        }
        for(int i=n; i>-1; i--){
            int temp = total(i-1);
            int now = k/temp;
            k = k%temp;
            if(remain.size()<1)
                return sb.toString();
            sb.append(remain.get(now));
            remain.remove(now);
        }
        return sb.toString();
    }

    public static int total(int n) {
        int temp = 1;
        for(int i=n; i>0; i--){
            temp *= i;
        }
        return temp;
    }
    
    public static void main(String[] args) {
    	System.out.println(getPermutation(3,3));
    }

}
