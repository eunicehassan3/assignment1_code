public class Question5 {
    //Question 5
    public static int removeElement(int[] nums, int val){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){ //where the value in the array doesn't equal know value
                nums[count] = nums[i];  //assign next available index to that value & increase count
                count ++;
            }
        }
        return count;
    }

}
