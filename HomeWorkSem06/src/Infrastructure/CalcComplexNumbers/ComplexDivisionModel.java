package Infrastructure.CalcComplexNumbers;

import Infrastructure.CalcModel;
import Infrastructure.ComplexNumber;

/**
 * Класс описывает модель Деления комплексных чисел
 */
public class ComplexDivisionModel extends CalcModel<ComplexNumber> {
    /**
     * Метод расчета
     * @return результат расчета
     */
    @Override
    public ComplexNumber result() {
        if (this.y.getReal() == 0 && this.y.getImaginary() == 0) {
            return null;
        } else return this.x.division(this.y);
    }
}


