

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
            for(int j=0; j < text2.length(); j++){
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
    public int[] notFibbonacci(int num){
        int[] ans = new int[num];
        ans[0] = 0;
        ans[1] = 1;
        for(int i= 2; i<num; i++){
            ans[i] = (3 * ans[i-1]) + (2 * ans[i-2]);
            //System.out.println(ans[i]);
        }
        return ans;
    }

    //Question 4
    public int whereInSequence(int num){
        int[] seq = notFibbonacci(num);
        int left = 0;
        int right = seq.length;

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
            if(nums[i] != val){
                nums[count] = nums[i];
                count ++;
            }
        }
        return count;
    }


    /* Question 6
    Question 1:
    Question 2: O(n^3) because of the nested for loops and  while loop
    Question 3: O(n)
    Question 4: O(logn) because it's a binary search
    Question 5: O(n) because it's a for loop
     */
    public static void main(String[] args) {
        Main m = new Main();
//        int[] seq = m.notFibbonacci(10);
//        System.out.println(Arrays.asList(seq));
        int ans = m.whereInSequence(11);
        int[] arr = {2,5,8,5,9};
        System.out.println(ans);
        System.out.println(m.commonSubstring("catsarecool", "arec"));
        System.out.println(m.commonSubsequence("abcde","acde"));
        System.out.println(m.removeElement(arr,5));
    }
}