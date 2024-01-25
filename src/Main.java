import java.util.Arrays;

public class Main {
    //Question 1
    public int commonSubsequence(String text1, String text2) {
        int[][] grid = new int[text1.length() + 1][text2.length() + 1];
        for (int i = text1.length() - 1; i >= 0; i--) { //start from bottom of grid and work way up
            for (int j = text2.length() - 1; j >= 0; j--) { //start from bottom of grid and work way up
                if (text1.charAt(i) == text2.charAt(j)) { //if the values are equal
                    grid[i][j] = 1 + grid[i + 1][j + 1]; //add up and move up the grid diagonally
                } else {
                    //else see if row across or row below has match and move accordingly
                    grid[i][j] = Math.max(grid[i][j + 1], grid[i + 1][j]);
                }
            }
        }
        return grid[0][0]; //return top grid which should contain the highest substring
    }
    //Question 2
    public String commonSubstring(String text1, String text2){
        int max = 0;
        int start = 0;

        for(int i=0; i < text1.length(); i++){
            for(int j=0; j < text2.length(); j++){ // O(n) * O(1) = O(n)
                int length = 0;
                int count1 = i;
                int count2 = j;
                //making sure the counts are within the word lengths [avoids error] and also checking if values match
                while (count1 < text1.length() && count2 < text2.length() && text1.charAt(count1) == text2.charAt(count2)){
                    length ++;
                    count1 ++;
                    count2 ++;
                }
                //trying to establish maximum length
                if(max < length){
                    max = length;
                    start = i;
                }
            }
        }
        return text1.substring(start, start + max);
    }

    //Question 3
    public Long[] notFibonacci(int num){
        Long[] ans = new Long[num];
        ans[0] = 0L;
        ans[1] = 1L;
        //to find every other value in sequence
        for(int i = 2; i < num; i++){
            ans[i] = (3 * ans[i - 1]) + (2 * ans[i-2]);
        }
        return ans;
    }


    //Question 4
    public int whereInSequence(int num){
        //the number that your looking for has to be smaller than the maximum number on the list
        //if that number was inserted
        Long[] seq = notFibonacci(num);
        int left = 0;
        int right = seq.length;
        //binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (seq[mid] == num) {
                return (mid + 1);
            }
            if (seq[mid] < num) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return (left);
    }

    //Question 5
    public int removeElement(int[] nums, int val){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){ //where the value in the array doesn't equal know value
                nums[count] = nums[i];  //assign next available index to that value & increase count
                count ++;
            }
        }
        return count;
    }

    //Question 6
    // On separate document

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println("Question 1:");
        System.out.println("Input: text1 = abcde, text2 = ace");
        System.out.println("Output: " + m.commonSubsequence("abcde","ace"));
        System.out.println();

        System.out.println("Question 2:");
        System.out.println("Input: text1 = catsarecool, text2 = arec");
        System.out.println("Output: " + m.commonSubstring("catsarecool", "arec"));
        System.out.println();

        System.out.println("Question 3:");
        System.out.println("Input: num = 8");
        System.out.println("Output: " + Arrays.toString(m.notFibonacci(8)));
        System.out.println();

        System.out.println("Question 4: ");
        System.out.println("Input: num = 11");
        System.out.println("Output: " + m.whereInSequence(11));
        System.out.println();

        System.out.println("Question 5: ");
        int[] arr = {2,5,8,5,9};
        System.out.println("Input: array = {2,5,8,5,9}, value = 5");
        System.out.println("Output: " + m.removeElement(arr,5));
        System.out.println();

    }
}