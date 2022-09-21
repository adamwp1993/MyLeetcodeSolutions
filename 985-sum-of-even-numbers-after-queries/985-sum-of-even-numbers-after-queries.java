class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        // create int array to hold the sums 
        // loop through and find the current sum of evens in nums, before we even start.
        // start evaluating queries. 
            // if the query takes an even number and makes it NOT even, we just subtract original value from the                sum. 
            // if the query takes a non even number and makes it even, we add the new value to the sum. 
            // if the query modifies an even number, subtract sum by original value, and then add the new value.
            // if the sum takes an even number and makes it even dont do anything. 
        
        // O(N * M) where n = size of nums and where m = size of queries 
        int[] result = new int[queries.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) {
                sum += nums[i];
            }
        }
        for(int j = 0; j < queries.length; j++) {
            int index = queries[j][1];
            int add = queries[j][0];
            int originalVal = nums[index];
            int newVal = originalVal + add;
            if(originalVal % 2 == 0 && newVal % 2 != 0) {
                sum -= originalVal;
            }
            else if(originalVal % 2 != 0 && newVal % 2 == 0) {
                sum += newVal;
            }
            else if(originalVal % 2 == 0 && newVal % 2 == 0) {
                sum -= originalVal;
                sum += newVal;
            }
            result[j] = sum;
            nums[index] = newVal;
        }
        
        return result;
    }
}