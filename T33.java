package leetcode;

public class T33 {
	 public static int search(int[] nums, int target) {
	        return fullsearch(nums, 0, nums.length-1, target);
	    }

	    public static int fullsearch(int[] nums, int begin, int end, int target){
	    		
	            if(begin<0||end<0||begin>nums.length-1||end>nums.length-1){
	                return -1;
	            }
	            if(begin<=end){
	                int mid = (begin+end)/2;
	            	
	                if(mid-1<begin||mid+1>end){
	                    for(int i= begin; i<=end; i++){
	                        if(nums[i]==target)
	                            return i;
	                    }
	                    return -1;
	                }
	                if(nums[mid]==target)
	                    return mid;
	                if(nums[begin]<nums[mid-1]){
	                	
	                    //left in order
	                    if(nums[begin]<=target&&nums[mid-1]>=target){
	                        // left in order in this scope
	                        if(nums[begin]==target)
	                            return begin;
	                        if(nums[mid-1]==target)
	                            return mid-1;
	                        return binary(nums,begin, mid-1, target);
	                    }else{
	                        // left in order not in this scope
	                        if(nums[mid+1]<nums[end]){
	                            //left on order not in this scope, right in order
	                            if(nums[mid+1]<=target&&nums[end]>=target){
	                                // left on order not in this scope, right in order,in this scope
	                                if(nums[mid+1]==target)
	                                    return mid+1;
	                                if(nums[end]==target)
	                                    return end;
	                                return binary(nums, mid+1, end, target);
	                            }else{
	                                // left in order not in this scope, right in order not in this scope
	                                return -1;  
	                            }
	                        }else{ 
	                            //left in order not in this scope, right not in order
	                            return fullsearch(nums, mid+1, end, target);
	                            }
	                        }
	                    
	                }else{
	                   //left not in order
	                    if(nums[mid+1]<nums[end]){
	                        //left not in order, right in order  	
	                        if(nums[mid+1]<=target&&nums[end]>=target){
	                            //left not in order, right in order, in this scope
	                            if(nums[mid+1]==target)
	                                return mid+1;
	                            if(nums[end]==target)
	                                return end;
	                            return binary(nums, mid+1, end, target);
	                        }else{
	                            //left not in order, right in order, not in this scope
	                            return fullsearch(nums, begin, mid-1, target);
	                        }
	                    }else{
	                        //left not in order, right not in order
	                        int a = fullsearch(nums, begin, mid-1, target);
	                        int b = fullsearch(nums, mid+1, end, target);
	                        if(a>b)
	                        return a;
	                        else
	                        return b;
	                    }
	                }
	            }else{
	                return -1;
	            }
	    }

	    public static int binary(int[] nums, int begin, int end, int target){
	    	System.out.println(begin+" "+end);
	        if(begin<0||end<0||begin>nums.length-1||end>nums.length-1){
	                return -1;
	            }
	        if(begin<=end){
	            int mid = (begin+end)/2;
	            if(mid-1<begin||mid+1>end){
	                    for(int i= begin; i<=end; i++){
	                        if(nums[i]==target)
	                            return i;
	                    }
	                    return -1;
	                }
	            if(nums[mid]==target){
	                    return mid;
	            }
	            if(nums[mid]<target)
	                return binary(nums,mid+1, end, target);
	            else if(nums[mid]>target)
	                return binary(nums, begin, mid-1, target);
	            else
	                return mid;
	        }else
	            return -1;
	    }
	    public static void main(String[] args) {
	    	int[] nums = {0,1,2,3,4};
			System.out.println(search(nums,3));
	    }

}
