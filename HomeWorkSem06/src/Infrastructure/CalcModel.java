package Infrastructure;

/**
 * Абстрактный класс - Модель расчета - расширяется интерфейсом Model
 * @param <T> Обобщение для выбора типа данных, с которыми может работать та или иная модель-наследник
 */
public abstract class CalcModel <T> implements Model<T> {
    protected T x, y;

    //переопределяю методы здесь, чтобы не описывать много раз одно и тоже -
    // они везде универсальны для наследников CalcModel

    /**
     * Метод записывает в Модель расчетов принимаемое в параметре значение
     * @param value значение для записи в поле
     */
    @Override
    public void setX(T value) {
        this.x = value;
    }

    /**
     * Метод записывает в Модель расчетов принимаемое в параметре значение
     * @param value значение для записи в поле
     */
    @Override
    public void setY(T value) {
        this.y = value;
    }
}
