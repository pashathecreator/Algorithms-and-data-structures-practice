import java.util.Arrays;
import java.util.Scanner;

public class LevenshteinDistance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < b.length() + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < a.length() + 1; i++) {
            for (int j = 1; j < b.length() + 1; j++) {
                int c = difference(a.charAt(i - 1), b.charAt(j - 1));
                dp[i][j] = Arrays.stream(new int[]{
                        dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + c
                }).summaryStatistics().getMin();
            }
        }

        System.out.println(dp[a.length()][b.length()]);
    }

    public static int difference(char a, char b) {
        return a == b ? 0 : 1;
    }

}