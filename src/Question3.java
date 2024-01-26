public class Question3 {
    //Question 3
    public static Long[] notFibonacci(int num){
        Long[] ans = new Long[num];
        ans[0] = 0L;
        ans[1] = 1L;
        //to find every other value in sequence
        for(int i = 2; i < num; i++){
            ans[i] = (3 * ans[i - 1]) + (2 * ans[i-2]);
        }
        return ans;
    }

}
