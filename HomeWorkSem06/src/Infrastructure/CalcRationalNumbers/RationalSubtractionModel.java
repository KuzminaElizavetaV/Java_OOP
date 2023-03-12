package Infrastructure.CalcRationalNumbers;

import Infrastructure.CalcModel;

/**
 * Класс описывает модель Разности рациональных чисел
 */
public class RationalSubtractionModel extends CalcModel<Double> {
    /**
     * метод расчета
     * @return результат расчета
     */
    @Override
    public Double result() {
        return x - y;
    }
}
