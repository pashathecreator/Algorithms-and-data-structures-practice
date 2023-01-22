import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int number = in.nextInt();
            a[i] = number;
        }
        in.nextLine();
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int number = in.nextInt();
            System.out.print(binarySearch(number,  a) + " ");
        }


    }

    public static int binarySearch(int k, int[] array) {
        int l = 0;
        int r = array.length - 1;

        while (l <= r) {
            int m = (r + l) / 2;
            if (array[m] == k) {
                return m + 1;
            }
            if (array[m] < k) {
                l = m + 1;
            } else if (array[m] > k) {
                r = m - 1;
            }
        }

        return -1;

    }
}