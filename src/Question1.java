public class Question1 {
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
}
