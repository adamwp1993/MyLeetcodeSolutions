class Solution {
    public int[] sortArray(int[] nums) {
        //Merge Sort
        sort(nums, 0, nums.length - 1);
        return nums;
    }
    
    public void sort(int[] arr, int left, int right) {
        // main function 
        // find middle 
        if(left < right) {
            int middle = left + (right - left) / 2;

            // recusively call to sort until we are at atomic level 
            sort(arr, left, middle);
            sort(arr, middle + 1, right);

            // merge subArrays 
            merge(arr, left, middle, right);
        }
        
    }
    
    public void merge(int[] arr, int left, int middle, int right) {
        // determine subArray sizes 
        int size1 = middle - left + 1;
        int size2 = right - middle;
        // create temp arrays 
        int[] leftArr = new int[size1];
        int[] rightArr = new int[size2];
        // copy vals to temp arrs 
        for(int i = 0; i < size1; i++) {
            leftArr[i] = arr[left + i];
        }
        for(int j = 0; j < size2; j++) {
            rightArr[j] = arr[middle + 1 + j];
        }
        
        // merge the subArrays 
        int k = left, i = 0, j = 0;
        while(i < size1 && j < size2) {
            if(leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            }
            else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        // merge remaining vals 
        while(i < size1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while(j < size2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}