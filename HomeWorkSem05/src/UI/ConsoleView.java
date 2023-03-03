package UI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Logger;
import Logger.MyLog;

public class ConsoleView implements View {
    static MyLog myLog = new MyLog(Logger.getLogger(ConsoleView.class.getName()));
    Scanner scanner;
    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Double getValue(String title) {
        System.out.println(title);//"Введите число:"
        Double num;
        if(scanner.hasNextDouble()){
            num = scanner.nextDouble();
            myLog.log(String.format("%s - %s", title, num));
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            myLog.log(String.format("%s - ошибка ввода", title));
            scanner.next();//рекурсия
            num = getValue(title);
        }
        return num;
    }

    @Override
    public char getOperation(String title) {
        System.out.println(title);//"Введите операцию:"
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
            myLog.log(String.format("%s - %s", title, operation));
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            myLog.log(String.format("%s - ошибка ввода", title));
            scanner.next();//рекурсия
            operation = getOperation(title);
        }
        return operation;    }

    @Override
    public void viewResult(String result, String title) {
        myLog.log(String.format("Выдан результат %s %s", title, result));
        System.out.printf("%s %s\n", title, result);
    }

    @Override
    public void viewLog(File file) {//или прописать пусть к файлу в классе Config, как вариант
        myLog.log(String.format("%s - выдано содержание файла логирования по запросу", file));
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
            myLog.log(String.format("%s - ошибка выдачи лог-файла", file));
            e.printStackTrace();
        }
    }
}
