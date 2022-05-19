class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // three pointers 
        // create a copy 
        int[] copyNums1 = new int[m];
        for(int i = 0; i < m; i++) {
            copyNums1[i] = nums1[i];
        }
        
        // read from copyNums1 and nums2
        int readPoint1 = 0;
        int readPoint2 = 0;
        for(int i = 0; i < m + n; i++) {
            if(readPoint2 >= n || (readPoint1 < m && copyNums1[readPoint1] <                               nums2[readPoint2])) {
                nums1[i] = copyNums1[readPoint1];
                readPoint1++;
            }
            else {
                nums1[i] = nums2[readPoint2];
                readPoint2++;
            }
            
        }
        
    }
}