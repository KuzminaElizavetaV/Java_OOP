package Infrastucture;

/**
 * Интерфейс Модели
 * @param <T> обобщенный возвращаемый тип результата операции
 */
public interface Model <T> {
    T result(char operation) throws Exception;


    void setX(T value);

    void setY(T value);
}
