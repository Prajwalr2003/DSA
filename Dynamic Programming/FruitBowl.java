import java.util.*;

class FruitBowl {
    static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair p) {
            if (this.x == p.x) {
                return Integer.compare(this.y, p.y);
            }
            return Integer.compare(this.x, p.x);
        }
    }

    public static double distance(Pair p1, Pair p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    public static int crossProduct(Pair p1, Pair p2, Pair p3) {
        return (p2.x - p1.x) * (p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<4 && n>50){
            System.out.println("Invalid input");
            return;
        }

        List<Pair> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points.add(new Pair(x, y));
        }

        Collections.sort(points);

        List<Pair> bowlPoints = new ArrayList<>();
        for (Pair p : points) {
            while (bowlPoints.size() > 1 &&
                   crossProduct(bowlPoints.get(bowlPoints.size() - 2), bowlPoints.get(bowlPoints.size() - 1), p) <= 0) {
                bowlPoints.remove(bowlPoints.size() - 1);
            }
            bowlPoints.add(p);
        }

        double perimeter = 0.0;
        for (int i = 0; i < bowlPoints.size() - 1; i++) {
            perimeter += distance(bowlPoints.get(i), bowlPoints.get(i + 1));
        }

        int result = (int) Math.round(perimeter);
        System.out.println(result);
    }
}
