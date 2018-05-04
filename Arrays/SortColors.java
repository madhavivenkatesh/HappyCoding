class Solution {
    
    public void sortColors(int[] A) {
        int start = 0, mid = 0, end=A.length-1,pivot=1,temp;
        
        	while (mid <= end)
		{
			if (A[mid] < pivot)			// current element is 0
			{
				// swap(A[start], A[mid])

				temp = A[start];
				A[start] = A[mid];
				A[mid] = temp;

				++start;
				++mid;
			}
			else if (A[mid] > pivot)	// current element is 2
			{
				// swap (A[mid], A[end])

				temp = A[mid];
				A[mid] = A[end];
				A[end] = temp;

				--end;
			}
			else						// current element is 1
				++mid;
		}
	}
    
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
