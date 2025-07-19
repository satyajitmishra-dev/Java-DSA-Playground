public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i<n; i++){
            for(int j= i+1; j<n;j++){
                if(nums[i] + nums[j] == target){
                   return new int[]{i,j};
                }
            }
        } 
        return new int[]{};
    } 
    public static void main(String[] args) {
        int[] arr = {2, 5, 12, 5, 7, 9};
        int target = 17;

        int[] ans = twoSum(arr, target);

        for (int ele : ans) {
            System.out.print(ele+ " ");
        }
    }
}
