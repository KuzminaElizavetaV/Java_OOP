package Infrastructure.CalcComplexNumbers;

import Infrastructure.CalcModel;
import Infrastructure.ComplexNumber;

/**
 * Класс описывает модель Разности комплексных чисел
 */
public class ComplexSubtractionModel extends CalcModel<ComplexNumber> {
    /**
     * метод расчета
     * @return результат расчета
     */
    @Override
    public ComplexNumber result()  {
        return this.x.subtraction(this.y);
    }
}
