package UI;

import java.io.File;

/**
 * Интерфейс Вид(Представление)
 */
public interface View {
    Double getValue(String title);

    char getOperation(String title);

    void viewResult(String result, String title);

    void viewLogger(File file);
}
