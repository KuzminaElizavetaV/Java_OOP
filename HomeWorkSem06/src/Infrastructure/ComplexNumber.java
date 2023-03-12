package Infrastructure;

/**
 * Класс определяет операции над комплексными числами и формат вывода числа
 */
public class ComplexNumber {
    double real;
    double imaginary;

    /**
     * Конструктор комплексного числа с параметрами
     * @param real вещественная часть
     * @param imaginary мнимая часть
     */
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Метод позволяет получить вещественную часть комплексного числа
     * @return реальная часть типа double
     */
    public double getReal() {
        return real;
    }

    /**
     * Метод позволяет получить мнимую часть комплексного числа
     * @return мнимая часть типа double
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * Метод добавления (сложения) комплексного числа
     * @param a Комплексное число, которое нужно добавить
     * @return новое комплексное число, являющееся суммой двух чисел: this и a
     */
    public ComplexNumber addition(ComplexNumber a) {
        double real1 = a.getReal();
        double imaginary1 = a.getImaginary();
        double newReal = real + real1;
        double newImaginary = imaginary + imaginary1;
        return new ComplexNumber(newReal,newImaginary);
    }

    /**
     * Метод разности (вычитания) комплексного числа
     * @param a Комплексное число, которое нужно вычесть
     * @return новое комплексное число, являющееся разностью двух чисел: this и a
     */
    public ComplexNumber subtraction(ComplexNumber a) {
        double real1 = a.getReal();
        double imaginary1 = a.getImaginary();
        double newReal = real - real1;
        double newImaginary = imaginary - imaginary1;
        return new ComplexNumber(newReal,newImaginary);
    }

    /**
     * Метод умножения на комплексное число
     * @param a Комплексное число, на которое нужно умножить
     * @return новое комплексное число, являющееся произведением двух чисел: this и a
     */
    public ComplexNumber multiplication(ComplexNumber a) {
        double real1 = a.getReal();
        double imaginary1 = a.getImaginary();
        double newReal = real*real1 - imaginary * imaginary1;
        double newImaginary = imaginary * real1 + real * imaginary1;
        return new ComplexNumber(newReal,newImaginary);
    }

    /**
     * Метод деления на комплексное число
     * @param a Комплексное число, на которое нужно разделить
     * @return новое комплексное число, являющееся результатом деления двух чисел: this на a
     */
    public ComplexNumber division(ComplexNumber a) {
        double real1 = a.getReal();
        double imaginary1 = a.getImaginary();
        double newReal = (real * real1 + imaginary * imaginary1) / (real1*real1 + imaginary1 * imaginary1);
        double newImaginary = (imaginary * real1 - real * imaginary1) / (real1 * real1 + imaginary1 * imaginary1);
        return new ComplexNumber(newReal,newImaginary);
    }

    /**
     * Строковое представление комплексного числа
     * @return Комплексное число для вывода на печать/в консоль в формате (x+-yi)
     */
    @Override
    public String toString() {
        StringBuilder complex = new StringBuilder();
        if(imaginary > 0){
            complex.append("(").append(real).append("+").append(imaginary).append("i").append(")");
        }else if(imaginary < 0){
            complex.append("(").append(real).append(imaginary).append("i").append(")");
        }else{
            complex.append(real);
        }
        return complex.toString();
    }
}
