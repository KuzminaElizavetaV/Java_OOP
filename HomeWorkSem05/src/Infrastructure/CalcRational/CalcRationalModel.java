package Infrastructure.CalcRational;

import Infrastructure.CalcModel;

public class CalcRationalModel extends CalcModel<Double> {

    public CalcRationalModel() {

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
                } else throw new Exception("Деление на --0--!");
            }
            default -> System.out.println("Операция не распознана. Повторите ввод.");
//здесь не должно быть вывода на экран, делать это в Презентере в случае если возвращается null
            //result = calc(getOperation());//рекурсия. но т.к.следуя паттерну Модель не видит Вью, надо
            //организовать как-то через Презентер, н-р, возвращая null?
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
