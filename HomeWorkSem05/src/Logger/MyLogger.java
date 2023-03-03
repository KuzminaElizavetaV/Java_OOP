package Logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Класс МойЖурнал (Логгирование)
 */
public class MyLogger {
    Logger logger;

    /**
     * Конструктор класса МойЖурнал
     * @param logger запись лога конкретной подсистемы
     */
    public MyLogger(Logger logger) {
        this.logger = logger;
    }

    /**
     * Метод логирования информации
     * @param info информация для сохранения в журнале логгирования
     */
    public void log(String info) {
        try {
            FileHandler fh = new FileHandler("HomeWorkSem05\\src\\CalculatorLog.txt", true);
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
