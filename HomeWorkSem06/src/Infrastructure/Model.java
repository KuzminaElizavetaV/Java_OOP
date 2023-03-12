package Infrastructure;

/**
 * Интерфейс описывает стандартное поведение основной логики проекта
 * @param <T>
 */
public interface Model <T> {
    /**
     * Формирует результат операции
     * @return результат вычислений
     */
    T result();

    /**
     * Устанавливает значения поля
     * @param value значение для записи в поле
     */
    void setX(T value);

    /**
     * Устанавливает значения поля
     * @param value значение для записи в поле
     */
    void setY(T value);
}
