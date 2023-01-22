import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Segment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Segment> a = new ArrayList<>();

        int start, end;

        for (int i = 0; i < n; i++) {
            start = sc.nextInt();
            end = sc.nextInt();

            a.add(new Segment(start, end));
        }

        HashSet<Integer> result = pointsCover(a);
        System.out.println(result.size());
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

    public static HashSet<Integer> pointsCover(ArrayList<Segment> segments) {
        HashSet<Integer> points = new HashSet<>();
        segments.sort(Segment::compareTo);

        for (Segment segment : segments) {
            int rightLine = segment.end;
            if (!isPointAlreadyInSet(points, segment)) {
                points.add(rightLine);
            }
        }

        return points;
    }

    public static boolean isPointAlreadyInSet(HashSet<Integer> points, Segment segment) {
        for (Integer i : points) {
            if (i >= segment.start && i <= segment.end) {
                return true;
            }
        }
        return false;
    }

}

class Segment implements Comparable<Segment> {
    Segment(int start, int end) {
        this.start = start;
        this.end = end;
    }

    int start;
    int end;


    @Override
    public int compareTo(Segment o) {
        return Integer.compare(this.end, o.end);
    }
}
