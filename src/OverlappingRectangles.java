public class OverlappingRectangles {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int calculateAreaOverlap(Point r1B, Point r1T, Point r2B, Point r2T) {
        int overlapX1 = r1B.x > r2B.x ? r1B.x : r2B.x;
        int overlapX2 = r1T.x < r2T.x ? r1T.x : r2T.x;
        int overlapW = overlapX2 - overlapX1;
        int overlapY1 = r1B.y > r2B.y ? r1B.y : r2B.y;
        int overlapY2 = r1T.y < r2T.y ? r1T.y : r2T.y;
        int overlapH = overlapY2 - overlapY1;
        if (overlapW > 0 && overlapH > 0) {
            return overlapW * overlapH;
        }
        return -1;
    }

    public static void main(String args[]) {
        Point r1B = new Point(2, 1);
        Point r1T = new Point(5, 5);
        Point r2B = new Point(7, 2);
        Point r2T = new Point(9, 7);

        int overlapArea = calculateAreaOverlap(r1B, r1T, r2B, r2T);
        if (overlapArea > 0)
            System.out.println("Overlapping Area = " + overlapArea);
        else
            System.out.println("No overlapping Area");
    }
}
