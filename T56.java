package leetcode;

import java.util.ArrayList;

public class T56 {
	public int[][] merge(int[][] intervals) {
        int count = 1;
        if(intervals.length<2)
            return intervals;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(intervals[0][0]);
        ans.add(intervals[0][1]);
        for(int i=1; i<intervals.length; i++){
            int a = intervals[i][0];
            int b = intervals[i][1];
            for(int j=0; j<count; j++){
                int x = ans.get(count*2);
                int y = ans.get(count*2+1);
                if(a>=x){
                	if(a<=y) {
                		if(b>y) {
                			ans.set(count*2+1, b);
                		}
                	}else{
                		count++;
                		ans.add(a);
                		ans.add(b);
                	}
                }else {
                	//a<x
                	if(b<x) {
                		count++;
                		ans.add(a);
                		ans.add(b);
                	}
                	else if(b<=y) {
                		ans.set(count*2, a);
                	}
                	else {
                		ans.set(count*2, a);
                		ans.set(count*2+1, b);
                	}
                }
            }
        }
        int[][] answer = new int[count][2];
        for(int i=0; i<count; i++) {
        	answer[i][0] = ans.get(i*2);
        	answer[i][1] = ans.get(i*2+1);
        }
        return answer;
    }

}
