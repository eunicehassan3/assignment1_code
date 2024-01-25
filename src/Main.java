import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println("Question 1:");
        System.out.println("Input: text1 = abcde, text2 = ace");
        System.out.println("Output: " + Question1.commonSubsequence("abcde","ace"));
        System.out.println();

        System.out.println("Question 2:");
        System.out.println("Input: text1 = catsarecool, text2 = arec");
        System.out.println("Output: " + Question2.commonSubstring("catsarecool", "arec"));
        System.out.println();

        System.out.println("Question 3:");
        System.out.println("Input: num = 8");
        System.out.println("Output: " + Arrays.toString(Question3.notFibonacci(8)));
        System.out.println();

        System.out.println("Question 4: ");
        System.out.println("Input: num = 11");
        System.out.println("Output: " + Question4.whereInSequence(11));
        System.out.println();

        System.out.println("Question 5: ");
        int[] arr = {2,5,8,5,9};
        System.out.println("Input: array = {2,5,8,5,9}, value = 5");
        System.out.println("Output: " + Question5.removeElement(arr,5));
        System.out.println();

    }
}