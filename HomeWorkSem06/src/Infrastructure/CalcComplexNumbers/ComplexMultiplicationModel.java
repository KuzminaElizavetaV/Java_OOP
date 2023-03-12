package Infrastructure.CalcComplexNumbers;

import Infrastructure.CalcModel;
import Infrastructure.ComplexNumber;

/**
 * Класс описывает модель Умножения комплексных чисел
 */
public class ComplexMultiplicationModel extends CalcModel<ComplexNumber> {
    /**
     * Метод расчета
     * @return результат расчета
     */
    @Override
    public ComplexNumber result()  {
        return this.x.multiplication(this.y);
    }
}
