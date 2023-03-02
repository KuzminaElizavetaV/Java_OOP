package Infrastructure;

public interface Model <T> {
    T result(char operation) throws Exception;

    void setX(T value);

    void setY(T value);
}
