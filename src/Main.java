import java.awt.Point;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int tolerance = 20; // Example tolerance value
        PasswordSystem passwordSystem = new PasswordSystem(tolerance);

        // Step 1: Setup password
        System.out.println("Select points to set the password...");
        PicturePointPassword setupFrame = new PicturePointPassword("Setup Password", "C:\\Users\\marki\\Downloads\\JPEG_007.jpg");

        // Wait for the setup window to close
        while (setupFrame.isShowing()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Retrieve the selected points for the password
        List<Point> passwordPoints = setupFrame.getSelectedPoints();
        if (passwordPoints == null || passwordPoints.isEmpty()) {
            System.out.println("No points selected. Exiting.");
            return;
        }
        passwordSystem.setPassword(passwordPoints);

        // Step 2: Verify password
        System.out.println("Select points to verify the password...");
        PicturePointPassword verifyFrame = new PicturePointPassword("Verify Password", "C:\\Users\\marki\\Downloads\\JPEG_007.jpg");

        // Wait for the verification window to close
        while (verifyFrame.isShowing()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Retrieve the selected points for verification
        List<Point> inputPoints = verifyFrame.getSelectedPoints();
        if (inputPoints == null || inputPoints.isEmpty()) {
            System.out.println("No points selected. Exiting.");
            return;
        }

        boolean isAuthenticated = passwordSystem.verifyPassword(inputPoints);
        System.out.println("Authentication result: " + (isAuthenticated ? "Successful" : "Failed"));

        // Step 3: Brute force attack
        System.out.println("\nStarting brute force attack...");
        BruteForceAttack bruteForce = new BruteForceAttack(passwordSystem.getPasswordStorage(), tolerance);
        bruteForce.bruteForce(passwordPoints); // Pass the actual password points for validation
    }
}
