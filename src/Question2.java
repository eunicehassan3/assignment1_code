public class Question2 {
    //Question 2
    public static String commonSubstring(String text1, String text2){
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

}
