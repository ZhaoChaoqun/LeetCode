import java.util.Arrays;

public class Solution {

    double radius, x_center, y_center;
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double length = Math.sqrt(Math.random()) * radius;
        double angel = Math.random() * Math.PI * 2;
        double[] result = new double[2];
        result[0] = x_center + length * Math.cos(angel);
        result[1] = y_center + length * Math.sin(angel);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(1,0,0);
        System.out.println(Arrays.toString(solution.randPoint()));
        System.out.println(Arrays.toString(solution.randPoint()));
    }
}
