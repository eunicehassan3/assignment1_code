public class Question4 {
    //Question 4
    public static int whereInSequence(int num){
        //the number that your looking for has to be smaller than the maximum number on the list
        //if that number was inserted
        Long[] seq = Question3.notFibonacci(num);
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
}
