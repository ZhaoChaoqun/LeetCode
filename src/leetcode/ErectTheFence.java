package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhaochaoqun on 2017/6/21.
 */
public class ErectTheFence {

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }

        public String toString() {
            return "[" + x + "," + y + "]";
        }

    }

    public static List<Point> outerTrees(Point[] points) {
        if (points.length <= 3) return Arrays.asList(points);
        List<Point> result = new ArrayList<>();
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.y < o2.y) {
                    return -1;
                } else if (o1.y > o2.y) {
                    return 1;
                }
                return o1.x - o2.x;
            }
        });
        Point zero = points[0];
        Point[] copy = new Point[points.length - 1];
        System.arraycopy(points, 1, copy, 0, points.length - 1);

        Arrays.sort(copy, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int x1 = o1.x - zero.x;
                int y1 = o1.y - zero.y;
                int x2 = o2.x - zero.x;
                int y2 = o2.y - zero.y;
                double diff = 1.0 * x1 * Math.abs(x1) / (x1 * x1 + y1 * y1) - 1.0 * x2 * Math.abs(x2) / (x2 * x2 + y2 * y2);
                if (diff > 0) {
                    return 1;
                } else if (diff < 0) {
                    return -1;
                } else {
                    return o2.x - o1.x;
                }
            }
        });
        result.add(zero);
        result.add(copy[0]);
        Point last = copy[0];
        Point lastLast = zero;
        for (int i = 1; i < copy.length; i++) {
            while ((copy[i].y - last.y) * (last.x - lastLast.x) - (copy[i].x - last.x) * (last.y - lastLast.y) > 0) {
                result.remove(result.size() - 1);
                last = lastLast;
                lastLast = result.get(result.size() - 2);
            }
            lastLast = last;
            last = copy[i];
            result.add(copy[i]);
        }
        return result;
    }

    public static void main(String[] args) {
//        [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
//        [[3,0],[4,0],[5,0],[6,1],[7,2],[7,3],[7,4],[6,5],[5,5],[4,5],[3,5],[2,5],[1,4],[1,3],[1,2],[2,1],[4,2],[0,3]]
        Point[] points = new Point[]{
//            new Point(3, 0), new Point(4, 0), new Point(5, 0), new Point(6, 1), new Point(7, 2), new Point(7, 3), new Point(7, 4), new Point(6, 5), new Point(5, 5), new Point(4, 5), new Point(3, 5), new Point(2, 5), new Point(1, 4), new Point(1, 3), new Point(1, 2), new Point(2, 1), new Point(4, 2), new Point(0, 3)
            new Point(0,0), new Point(0,1), new Point(0,2), new Point(1,2), new Point(2,2), new Point(3,2), new Point(3,1), new Point(3,0), new Point(2,0), new Point(1,0), new Point(1,1), new Point(3,3)
        };
        System.out.println(outerTrees(points));
    }
}
