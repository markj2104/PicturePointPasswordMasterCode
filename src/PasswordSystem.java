import java.awt.Point;
import java.util.List;

public class PasswordSystem {
    private PasswordStorage passwordStorage;
    private int tolerance;

    public PasswordSystem(int tolerance) {
        this.tolerance = tolerance;
        this.passwordStorage = new PasswordStorage(tolerance);
    }

    public void setPassword(List<Point> passwordPoints) {
        System.out.println("Setting password points: " + passwordPoints); // Debug
        passwordStorage.storePassword(passwordPoints);
        System.out.println("Stored quantized password points: " + passwordStorage.getQuantizedPoints(passwordPoints));
    }

    public boolean verifyPassword(List<Point> inputPoints) {
        System.out.println("Verifying points: " + inputPoints); // Debug
        boolean result = passwordStorage.verifyPassword(inputPoints);
        System.out.println("Verification result: " + result);
        return result;
    }

    // Accessor for password storage to use in brute force
    public PasswordStorage getPasswordStorage() {
        return passwordStorage;
    }
}
