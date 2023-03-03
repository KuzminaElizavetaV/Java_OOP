package Infrastucture;

/**
 * Класс КомлексноеЧисло
 */
public class ComplexNumber {
    double real;
    double imaginary;

    /**
     * Конструктор класса КомплексноеЧисло
     * @param real вещественная часть
     * @param imaginary мнимая часть
     */
    public ComplexNumber(double real, double imaginary) {// конструктор с параметрами
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    /**
     * Метод сложения комплесных чисел
     * @param a другое комплексное число
     * @return новое комплексное число
     */
    public ComplexNumber addition(ComplexNumber a) {
        double real1 = a.getReal();
        double imaginary1 = a.getImaginary();
        double newReal = real + real1;
        double newImaginary = imaginary + imaginary1;
        return new ComplexNumber(newReal,newImaginary);
    }

    /**
     * Метод вычитания комплесных чисел
     * @param a другое комплексное число
     * @return новое комплексное число
     */
    public ComplexNumber subtraction(ComplexNumber a) { //Вычитание комплексных чисел
        double real1 = a.getReal();
        double imaginary1 = a.getImaginary();
        double newReal = real - real1;
        double newImaginary = imaginary - imaginary1;
        return new ComplexNumber(newReal,newImaginary);
    }

    /**
     * Метод умножения комплесных чисел
     * @param a другое комплексное число
     * @return новое комплексное число
     */
    public ComplexNumber multiplication(ComplexNumber a) { //умножение комплексных чисел
        double real1 = a.getReal();
        double imaginary1 = a.getImaginary();
        double newReal = real*real1 - imaginary *imaginary1;
        double newImaginary = imaginary *real1 + real*imaginary1;
        return new ComplexNumber(newReal,newImaginary);
    }

    /**
     * Метод деления комплесных чисел
     * @param a другое комплексное число
     * @return новое комплексное число
     */
    public ComplexNumber division(ComplexNumber a) {// Деление комплексных чисел
        double real1 = a.getReal();
        double imaginary1 = a.getImaginary();
        double newReal = (real*real1 + imaginary *imaginary1)/(real1*real1 + imaginary1*imaginary1);
        double newImaginary = (imaginary *real1 - real*imaginary1)/(real1*real1 + imaginary1*imaginary1);
        return new ComplexNumber(newReal,newImaginary);
    }

    /**
     * Представление комплексного числа
     * @return коплесное число в виде строки
     */
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

