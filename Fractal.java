import java.awt.*;
import java.awt.image.BufferedImage;

public class Fractal {

    public void generate(BufferedImage image) {
        int maxIterations = 1000;
        for(double i = 0; i < image.getHeight(); i++) {
            for(double j = 0; j < image.getWidth(); j++) {
                double a = (j - 500) / 250;
                double b = (i - 500) / 250;
                ComplexNumber c = new ComplexNumber(a, b);
                ComplexNumber z = new ComplexNumber(0.0, 0.0);
                int n;
                for(n = 0; n < maxIterations; n++){
                    z = z.pow(2).add(c);
                    if(z.norm() > 16) break;
                    n++;
                }
                int pixel = 0;
                if(n == maxIterations) {
                    pixel = 0;
                }
                else pixel = color(n, maxIterations);
                image.setRGB((int)j, (int)i, pixel);
            }
        }
    }

    public int color(int n, int maxIterations) {
        return Color.HSBtoRGB((float) n / maxIterations, 0.7f, 1.1f);
    }
}