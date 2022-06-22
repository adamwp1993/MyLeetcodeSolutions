class Solution {
    public int maxArea(int[] height) {
        // two pointers 
        // increment the side with the smaller height. 
        int max = 0;
        int right = height.length - 1, left = 0;
        int current = 0;
        
        while(left < right) {
            current = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(current, max);
            if(height[left] <= height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return max;
    }
}