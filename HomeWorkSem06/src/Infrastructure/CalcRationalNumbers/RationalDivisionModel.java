package Infrastructure.CalcRationalNumbers;

import Infrastructure.CalcModel;

/**
 * Класс описывает модель Деления рациональных чисел
 */
public class RationalDivisionModel extends CalcModel<Double> {

    /**
     * метод расчета
     * @return результат расчета
     */
    @Override
    public Double result()  {
        if (y != 0) return x / y;
        return null;
    }
}
