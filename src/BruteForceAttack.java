import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class BruteForceAttack {
    private PasswordStorage passwordStorage;
    private int tolerance;

    public BruteForceAttack(PasswordStorage passwordStorage, int tolerance) {
        this.tolerance = tolerance;
        this.passwordStorage = passwordStorage; // Use the same password storage logic
    }

    public void bruteForce(List<Point> actualPoints) {
        // Log actual quantized password points
        System.out.println("Actual quantized password points: " + passwordStorage.getQuantizedPoints(actualPoints));

        for (int x1 = 0; x1 <= 1000; x1 += tolerance) { // Expand the range as needed
            for (int y1 = 0; y1 <= 1000; y1 += tolerance) {
                for (int x2 = 0; x2 <= 1000; x2 += tolerance) {
                    for (int y2 = 0; y2 <= 1000; y2 += tolerance) {
                        List<Point> bruteForcePoints = new ArrayList<>();
                        bruteForcePoints.add(new Point(x1, y1));
                        bruteForcePoints.add(new Point(x2, y2));

                        System.out.println("Trying brute force points: " + bruteForcePoints); // Debug

                        if (passwordStorage.verifyPassword(bruteForcePoints)) {
                            System.out.println("Password cracked! Points: " + bruteForcePoints);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Failed to crack the password.");
    }
}
