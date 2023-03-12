package UserInterface;


import Logger.MyLoggerNew;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Класс описывает взаимодействие с пользователем,
 * имплементируя интерфейс View
 */
public class ConsoleView implements View {
    static MyLoggerNew myLog = new MyLoggerNew(Logger.getLogger(ConsoleView.class.getName()));
    Scanner scanner;

    /**
     * В конструторе ConsoleView создается консольный экземпляр Scanner
     */
    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * метод рекурсивно обрабатывает пользовательский ввод на получение числа типа Double
     * @param title Строка запроса, что видит пользователь в консоли
     * @return число типа Double
     */
    @Override
    public Double getValue(String title) {
        System.out.println(title);
        Double num;
        if(scanner.hasNextDouble()){
            num = scanner.nextDouble();
            myLog.log(String.format("%s => %s", title, num));
        } else {
            System.out.println("ДОПУЩЕНА ОШИБКА ПРИ ВВОДЕ ЧИСЛА! ПОПРОБУЙТЕ СНОВА...");
            myLog.log(String.format("%s => ОШИБКА ВВОДА", title));
            scanner.next();
            num = getValue(title);
        }
        return num;
    }

    /**
     * Метод рекурсивно обрабатывает пользовательский ввод на получение числа типа int
     * @param title Строка запроса, что видит пользователь в консоли
     * @return число типа int
     */
    @Override
    public int getVariant(String title) {
        System.out.println(title);//"Введите пункт меню:"
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
            myLog.log(String.format("%s => ВЫБРАН %s", title, num));
        } else {
            System.out.println("ДОПУЩЕНА ОШИБКА ПРИ ВВОДЕ ЧИСЛА! ПОПРОБУЙТЕ СНОВА...");
            myLog.log(String.format("%s => ОШИБКА ВВОДА", title));
            scanner.next();
            num = getVariant(title);
        }
        return num;
    }

    /**
     * Метод выдает пользователю обратную связь
     * @param data Обратная связь: результат, ошибка или рекомендация
     * @param title Описание, подпись к обратной связи
     */
    @Override
    public void viewData(String data, String title) {
        myLog.log(String.format("ПОЛУЧЕН ОТВЕТ: %s %s", title, data));
        System.out.printf("%s %s\n", title, data);
    }

    /**
     * Метод считывает данные из указанного файла и выдает в консоль
     * @param file Файл с данными
     */
    @Override
    public void viewLog(File file) { //или прописать пусть к файлу в классе Config, как вариант
        myLog.log(String.format("%s - ВЫДАНО СОДЕРЖИМОЕ ЖУРНАЛА ЛОГГИРОВАНИЯ ПО ЗАПРОСУ ", file));
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (Exception e) {
            myLog.log(String.format("%s - ОШИБКА ЧТЕНИЯ ФАЙЛА ЖУРНАЛА ЛОГГИРОВАНИЯ ", file));
            e.printStackTrace();
        }
    }
}