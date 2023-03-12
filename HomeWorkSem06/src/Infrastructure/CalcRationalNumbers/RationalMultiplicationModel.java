package Infrastructure.CalcRationalNumbers;

import Infrastructure.CalcModel;

/**
 * Класс описывает модель Умножения рациональных чисел
 */
public class RationalMultiplicationModel extends CalcModel<Double> {

    /**
     * метод расчета
     * @return результат расчета
     */
    @Override
    public Double result()  {
        return x * y;
    }
}
