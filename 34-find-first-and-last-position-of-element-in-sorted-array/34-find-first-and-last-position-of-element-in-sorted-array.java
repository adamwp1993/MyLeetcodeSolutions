class Solution {
    // 1. use binary search to find an instance of target, if it exists
    // 2. Once we've found an instance, expand out from the instance to find beginning and end, using two pointers  
    
    public int[] searchRange(int[] nums, int target) {
        // use Binary Search to find instance 
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int instance = -1;
        
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] > target) {
                end = mid - 1;
            }
            else if(nums[mid] < target) {
                start = mid + 1;
            }
            else if(nums[mid] == target) {
                instance = mid;
                break;
            }
        }
        
        // return default if no instance exists 
        if(instance == -1) return result;
        // use two pointers to expand out to find beginning and end 
        result[0] = instance;
        result[1] = instance;
        boolean flag = true;
        int high = instance + 1;
        int low = instance - 1;
        
        while(flag) {
            flag = false;
            if(high < nums.length && nums[high] == target) {
                flag = true;
                result[1] = high;
                high++;
            }
            if(low >= 0 && nums[low] == target) {
                flag = true;
                result[0] = low;
                low--;
            }
        }
        return result;
    }
}