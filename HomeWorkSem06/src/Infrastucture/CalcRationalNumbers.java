package Infrastucture;

/**
 * Класс КалькуляторРациональныхЧисел
 */
public class CalcRationalNumbers extends CalcModel<Double> {
    public CalcRationalNumbers() {

    }

    @Override
    public Double result(char operation) throws Exception {
        Double result = null;
        switch (operation) {
            case '+' -> result = this.x + this.y;
            case '-' -> result = this.x - this.y;
            case '*' -> result = this.x * this.y;
            case '/' -> {
                if (this.y != 0) {
                    result = this.x / this.y;
                } else throw new Exception("ДЕЛИТЬ НА \"НОЛЬ\" НЕЛЬЗЯ!");
            }
            default -> System.out.println("ОПЕРАЦИЯ НЕ РАСПОЗНАНА! ПОВТОРИТЕ ВВОД.");
        }
        return result;
    }

    @Override
    public void setX(Double value) {
        super.x = value;
    }

    @Override
    public void setY(Double value) {
        super.y = value;
    }
}
