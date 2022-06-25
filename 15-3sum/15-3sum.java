class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array
        Arrays.sort(nums);
        // the value in first positon can only be used once each time to prevennt duplicate sets 
        // if we encounter a set, we move first position afterwards 
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        // outer loop determines the first value in the set and then we run twoSum inside of that with the remaining items 
        // i.e if the array has 10 elements and index i = 4, we use twosum for indexes 5-9 + nums[i] to determine if the condition is met 
        for(int i = 0; i < nums.length; i++) {
            // if this has already been used for first position, we continue to next distinct value to avoid duplicate sets
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // solve twoSum with the remaining subArray, find all sets with start position at i that are not duplicates. 
            int first = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = first + nums[left] + nums[right];
                // found triplet, add and shrink remaining subarray 
                if(sum > 0) {
                    right--;
                }
                if(sum < 0) {
                    left++;
                }
                // found triplet, add to results. 
                
                if(sum == 0) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(first);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    // update pointer so we can find next triplet without duplicates. we want to get rid of duplicate values on one side that 
                    // we have already used, so we dont add a duplicate triplet.
                    int curLeft = nums[left];
                    while(nums[left] == curLeft && left < right) {
                        left++;
                        
                    }
                    
                }
                
            }
            
        }
        return result;
    }
}