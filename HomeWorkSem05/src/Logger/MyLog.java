package Logger;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLog {
    Logger logger;
    File file;


    public MyLog(Logger logger) {
        this.logger = logger;
    }

    public void log(String info) {
        try {
            FileHandler fh = new FileHandler("HomeWorkSem05\\logCalc.txt", true);
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
