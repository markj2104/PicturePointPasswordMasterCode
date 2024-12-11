import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PicturePointPassword extends JFrame {
    private JLabel imageLabel;
    private ArrayList<Point> selectedPoints;
    private ImageIcon image;

    public PicturePointPassword(String title, String imagePath) {
        setTitle(title);
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Allow the main program to continue after closing
        selectedPoints = new ArrayList<>();

        // Load and display the image
        image = new ImageIcon(imagePath);
        imageLabel = new JLabel(image);
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point clickedPoint = e.getPoint();
                selectedPoints.add(clickedPoint);
                System.out.println("Point added: " + clickedPoint);
            }
        });

        add(imageLabel);
        setVisible(true);
    }

    public ArrayList<Point> getSelectedPoints() {
        return selectedPoints;
    }
}

