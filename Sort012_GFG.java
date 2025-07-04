class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public void sort012(int[] arr) {
        // code here
        int low = 0, high = arr.length - 1;
        int mid = 0;
        
        while(mid <= high){
            if(arr[mid] == 0){
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                swap(arr, mid, high);
                high--;
            }
        }
    }
}
