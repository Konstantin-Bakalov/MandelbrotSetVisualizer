import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Visualizer extends JFrame {

    private BufferedImage image;

    public Visualizer(Fractal fractal, int width, int height) {
        super("Mandelbrot set");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(width, height);
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        fractal.generate(image);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}