package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class T40 {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;
    private ArrayList<Integer> after;

    private void findCombinationSum(int residue, int start, Stack<Integer> pre) {
        if (residue == 0) {
        	List<Integer> now = new ArrayList<>(pre);
        	if(!res.contains(now)) {
        		 res.add(now);
        	}
            return;
        }
        for (int i = start; i < len && residue - candidates[i] >= 0; i++) {
            pre.add(candidates[i]);
            // 【关键】因为元素可以重复使用，这里递归传递下去的是 i 而不是 i + 1
            findCombinationSum(residue - candidates[i], i+1, pre);
            pre.pop();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        // 优化添加的代码1：先对数组排序，可以提前终止判断
        Arrays.sort(candidates);
        this.len = len;
        this.candidates = candidates;
        findCombinationSum(target, 0, new Stack<>());
        return res;
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        T40 solution = new T40();
        List<List<Integer>> combinationSum = solution.combinationSum(candidates, target);
        System.out.println(combinationSum);
    }
}