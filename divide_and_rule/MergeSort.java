import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort {

    static long inversionCounter = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int number = in.nextInt();
            arr.add(number);
        }

        ArrayList<Integer> sortArray = mergeSort(arr);
        System.out.println(inversionCounter);

    }

    private static ArrayList<Integer> mergeSort(ArrayList<Integer> arr) {
        if (arr.size() == 1) {
            return arr;
        }
        int middle = arr.size() / 2;

        ArrayList<Integer> tempLeftArray = new ArrayList<>();
        ArrayList<Integer> tempRightArray = new ArrayList<>();

        for (int i = 0; i < middle; i++) {
            tempLeftArray.add(arr.get(i));
        }
        for (int i = middle; i < arr.size(); i++) {
            tempRightArray.add(arr.get(i));
        }

        ArrayList<Integer> leftArray = mergeSort(tempLeftArray);
        ArrayList<Integer> rightArray = mergeSort(tempRightArray);

        return merge(leftArray, rightArray);
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> leftArray, ArrayList<Integer> rightArray) {
        ArrayList<Integer> mergedArray = new ArrayList<>();
        int i = 0, j = 0;
        while (i < leftArray.size() && j < rightArray.size()) {
            if (leftArray.get(i) <= rightArray.get(j)) {
                mergedArray.add(leftArray.get(i));
                i++;
            } else {
                mergedArray.add(rightArray.get(j));
                inversionCounter += leftArray.size() - i;
                j++;
            }

        }
        while (i < leftArray.size()) {
            mergedArray.add(leftArray.get(i));
            i++;
        }

        while (j < rightArray.size()) {
            mergedArray.add(rightArray.get(j));
            j++;
        }

        return mergedArray;
    }


}