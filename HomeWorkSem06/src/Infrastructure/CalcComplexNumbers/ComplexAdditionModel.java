package Infrastructure.CalcComplexNumbers;

import Infrastructure.CalcModel;
import Infrastructure.ComplexNumber;

/**
 * Класс описывает модель Сложения комплексных чисел
 */
public class ComplexAdditionModel extends CalcModel<ComplexNumber> {
    /**
     * метод расчета
     * @return результат расчета
     */
    @Override
    public ComplexNumber result()  {
        return this.x.addition(this.y);
    }


}

