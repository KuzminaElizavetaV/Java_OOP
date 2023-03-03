package Infrastucture;

/**
 * Класс КалькуляторКомплексныхЧисел
 */
public class CalcComplexNumbers extends CalcModel<ComplexNumber> {
    @Override
    public ComplexNumber result(char operation) throws Exception {
        ComplexNumber result = null;
        switch (operation) {
            case '+' -> result = this.x.addition(this.y);
            case '-' -> result = this.x.subtraction(this.y);
            case '*' -> result = this.x.multiplication(this.y);
            case '/' -> {
                if (this.y.getReal() == 0 && this.y.getImaginary()==0) {
                    throw new Exception("ДЕЛИТЬ НА \"НОЛЬ\" НЕЛЬЗЯ!");
                } else result = this.x.division(this.y);
            }
            default -> System.out.println("ОПЕРАЦИЯ НЕ РАСПОЗНАНА! ПОВТОРИТЕ ВВОД.");
        }
        return result;    }

    @Override
    public void setX(ComplexNumber value) {
        this.x = value;
    }

    @Override
    public void setY(ComplexNumber value) {
        this.y = value;
    }
}
