package UserInterface;

import java.io.File;

/**
 * Интерфейс взаимодействия с пользователем содержит методы для описания поведения получения/выдачи данных
 */
public interface View {
    /**
     * Метод получения числа типа Double
     * @param title Строка запроса к пользователю
     * @return число типа Double
     */
    Double getValue(String title);

    /**
     * Метод получения числа типа int
     * @param title Строка запроса к пользователю
     * @return число типа int
     */
    int getVariant(String title);

    /**
     * Метод отправки данных пользователю
     * @param data данные
     * @param title описание к данным
     */
    void viewData(String data, String title);

    /**
     * Метод выдачи записей лог-файла
     * @param file файл записей лога
     */
    void viewLog(File file);
}

