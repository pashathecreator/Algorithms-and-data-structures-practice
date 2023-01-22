import java.util.Scanner;

public class LargestSuccessiveSubsequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] % a[j] == 0 && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                }
            }
        }


        System.out.println(maxInArray(d) + 1);

    }

    private static int maxInArray(int[] d) {
        int max = d[0];
        for (int i = 1; i < d.length; i++) {
            if (d[i] > max) {
                max = d[i];
            }
        }
        return max;
    }


}