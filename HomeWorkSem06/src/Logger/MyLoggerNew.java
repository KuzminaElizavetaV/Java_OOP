package Logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Класс описывает функционал логирования в проекте
 */
public class MyLoggerNew {
    Logger logger;

    /**
     * Конструктор
     * @param logger Логгер конкретной подсистемы
     */
    public MyLoggerNew(Logger logger) {
        this.logger = logger;
    }

    /**
     * Метод логирования информации
     * @param info информация для сохранения в логе
     */
    public void log(String info) {
        try {
            FileHandler fh = new FileHandler("Test\\src\\CalculatorLog.txt", true);
            //в даннном случае явно указываю путь к файлу, в идеале его нужно передавать/принимать на каком-либо этапе
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            logger.info(info);
            fh.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
