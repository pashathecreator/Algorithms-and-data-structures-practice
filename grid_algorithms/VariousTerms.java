import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class VariousTerms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 1; i < n + 1; i++) {
            if (n - i >= i + 1) {
                numbers.add(i);
            } else {
                numbers.add(n)  ;
                break;
            }
            n -= i;
        }
        System.out.println(numbers.size());
        for (Integer i : numbers) {
            System.out.print(i + " ");
        }
    }
}
