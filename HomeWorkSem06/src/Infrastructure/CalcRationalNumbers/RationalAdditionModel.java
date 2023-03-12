package Infrastructure.CalcRationalNumbers;

import Infrastructure.CalcModel;

/**
 * Класс описывает модель Сложения рациональных чисел
 */
public class RationalAdditionModel extends CalcModel<Double> {

    /**
     * метод расчета
     * @return результат расчета
     */
    @Override
    public Double result()  {
        return x + y;
    }
}