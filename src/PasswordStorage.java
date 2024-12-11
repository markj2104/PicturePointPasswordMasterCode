import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class PasswordStorage {
    private List<String> hashedPoints = new ArrayList<>();
    private int tolerance;

    public PasswordStorage(int tolerance) {
        this.tolerance = tolerance;
    }

    public void storePassword(List<Point> points) {
        hashedPoints.clear(); // Clear any previous passwords
        for (Point point : points) {
            int quantizedX = quantize(point.x, tolerance);
            int quantizedY = quantize(point.y, tolerance);
            String hash = hashPoint(quantizedX, quantizedY);
            hashedPoints.add(hash); // Store the hashed point
            System.out.println("Stored Hashed Point: " + hash);
        }
    }

    public boolean verifyPassword(List<Point> inputPoints) {
        if (inputPoints.size() != hashedPoints.size()) {
            return false;
        }
        for (int i = 0; i < inputPoints.size(); i++) {
            Point point = inputPoints.get(i);
            int quantizedX = quantize(point.x, tolerance);
            int quantizedY = quantize(point.y, tolerance);
            String hash = hashPoint(quantizedX, quantizedY);
            System.out.println("Verifying Point: " + point + " | Quantized: (" + quantizedX + ", " + quantizedY + ") | Hashed: " + hash);
            if (!hash.equals(hashedPoints.get(i))) {
                System.out.println("Point mismatch at index " + i);
                return false;
            }
        }
        return true;
    }

    public List<Point> getQuantizedPoints(List<Point> points) {
        List<Point> quantizedPoints = new ArrayList<>();
        for (Point point : points) {
            int quantizedX = quantize(point.x, tolerance);
            int quantizedY = quantize(point.y, tolerance);
            quantizedPoints.add(new Point(quantizedX, quantizedY));
        }
        return quantizedPoints;
    }

    private int quantize(int value, int tolerance) {
        return value / tolerance;
    }

    private String hashPoint(int x, int y) {
        return Integer.toHexString((x + "," + y).hashCode());
    }

    // Accessor for hashedPoints to use in brute force
    public List<String> getHashedPoints() {
        return hashedPoints;
    }
}
