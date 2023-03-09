package Infrastucture;

/**
 * Интерфейс МоделиКалькулятора
 * @param <T> обобщенный тип
 */
public abstract class CalcModel <T> implements Model<T> {
    protected T x, y;
}