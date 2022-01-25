public class ComplexNumber {
    private double real, imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber z) {
        return new ComplexNumber(this.real + z.real, this.imaginary + z.imaginary);
    }

    public ComplexNumber sub(ComplexNumber z) {
        return new ComplexNumber(this.real - z.real, this.imaginary - z.imaginary);
    }

    public ComplexNumber mul(ComplexNumber z) {
        return new ComplexNumber(this.real * z.real - this.imaginary * z.imaginary,
                                 this.real * z.imaginary + this.imaginary * z.real);
    }

    public ComplexNumber div(ComplexNumber z) {
        ComplexNumber temp = this.mul(conj(z));
        double d = Math.pow(z.real, 2) + Math.pow(z.imaginary, 2);
        return new ComplexNumber(temp.real / d, temp.imaginary / 2);
    }

    public ComplexNumber conj(ComplexNumber z) {
        return new ComplexNumber(z.real, -1.0 * z.imaginary);
    }

    public ComplexNumber pow(int n) {
        ComplexNumber temp = new ComplexNumber(this.real, this.imaginary);
        for(int i = 0; i < n - 1; i++) {
            temp = temp.mul(temp);
        }
        return temp;
    }

    public double norm() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
    }

    public double getReal() {
        return this.real;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    public String print() {
        return this.real + " + " + this.imaginary + " * i";
    }
}