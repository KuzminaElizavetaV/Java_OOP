package Infrastructure;

public class Complex {
    double real; // реальная часть
    double imaginary; // мнимая часть

    public Complex(double real, double image) {// конструктор с параметрами
        this.real = real;
        this.imaginary = image;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public Complex add (Complex a) {// Сумма комплексных чисел
        double real2 = a.getReal();
        double imaginary2 = a.getImaginary();
        double newReal = real + real2;
        double newImaginary = imaginary + imaginary2;
        return new Complex(newReal,newImaginary);
    }

    public Complex sub (Complex a) {// Вычитание комплексных чисел
        double real2 = a.getReal();
        double imaginary2 = a.getImaginary();
        double newReal = real - real2;
        double newImaginary = imaginary - imaginary2;
        return new Complex(newReal,newImaginary);
    }

    public Complex mul (Complex a) {// Умножение комплексных чисел
        double real2 = a.getReal();
        double imaginary2 = a.getImaginary();
        double newReal = real*real2 - imaginary *imaginary2;
        double newImaginary = imaginary *real2 + real*imaginary2;
        return new Complex(newReal,newImaginary);
    }

    public Complex div (Complex a) {// Деление комплексных чисел
        double real2 = a.getReal();
        double imaginary2 = a.getImaginary();
        double newReal = (real*real2 + imaginary *imaginary2)/(real2*real2 + imaginary2*imaginary2);
        double newImaginary = (imaginary *real2 - real*imaginary2)/(real2*real2 + imaginary2*imaginary2);
        return new Complex(newReal,newImaginary);
    }

    @Override
    public String toString() {
        StringBuilder complex = new StringBuilder();
        if(imaginary > 0){
            complex.append(real).append(" + ").append(imaginary).append("i");
        }else if(imaginary < 0){
            complex.append(real).append(imaginary).append("i");
        }else{
            complex.append(real);
        }
        return complex.toString();
    }
}
