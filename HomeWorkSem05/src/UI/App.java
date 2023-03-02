package UI;

import MVP.*;

import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;
import Logger.MyLog;

public class App {
    static Scanner in = new Scanner(System.in);
    static MyLog myLog = new MyLog(Logger.getLogger(App.class.getName()));

    static View view = new ConsoleView();
    static Model model;
    static Presenter presenter;

    public static void start() {
        while (true) {
            System.out.println("""
                    Выберите пункт меню:
                        1 - операции с рац.числами
                        2 - операции с комплекс.числами
                        3 - посмотреть лог файл
                        4 - выход из программы
                    """);
            switch (in.nextInt()) {
                case 1:
                    myLog.log("Выбран пункт меню: 1 - операции с рац.числами ");
                    presenter = new Presenter<>(new CalcRational(),view);
                    presenter.buttonClick();//или сразу так? presenter.buttonClickRational();
                    break;
                case 2:
                    myLog.log("2 - операции с комплекс.числами");
                    presenter = new Presenter<>(new CalcComplex(),view);
                    presenter.buttonClick(); //или так? buttonClickComplex();
                    break;
                case 3:
                    myLog.log("3 - посмотреть лог файл");
                    view.viewLog(new File("HomeWorkSem05\\src\\CalculatorLog.txt"));
                    break;
                case 4:
                    myLog.log("4 - выход из программы");
                    return;
                default:
                    myLog.log("Выбран некорректный пункт меню. Повторите ввод");
                    break;

            }
        }
    }
}

