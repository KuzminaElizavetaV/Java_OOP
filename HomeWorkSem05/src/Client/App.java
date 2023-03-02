package Client;

import Logger.MyLog;
import MVP.CalcComlex.CalcComplexModel;
import MVP.CalcRational.CalcRationalModel;
import MVP.Model;
import MVP.Presenter;
import MVP.View;

import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;


public class App {
    static Scanner in = new Scanner(System.in);
    static MyLog myLog = new MyLog(Logger.getLogger(App.class.getName()));

    static View view = new ConsoleView();
    static Model model;
    static Presenter presenter = new Presenter<>(new CalcRationalModel(), view);

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
                case 1 -> {
                    myLog.log("Выбран пункт меню: 1 - операции с рац.числами ");
                    presenter = new Presenter<>(new CalcRationalModel(), view);
                    presenter.buttonClick();//или сразу так? presenter.buttonClickRational();
                }
                case 2 -> {
                    myLog.log("2 - операции с комплекс.числами");
                    presenter = new Presenter<>(new CalcComplexModel(), view);
                    presenter.buttonClick(); //или так? buttonClickComplex();
                }
                case 3 -> {
                    myLog.log("3 - посмотреть лог файл");
                    view.viewLog(new File("HomeWorkSem05\\logCalc.txt"));
                }
                case 4 -> {
                    myLog.log("4 - выход из программы");
                    return;
                }
                default -> myLog.log("Выбран некорректный пункт меню. Повторите ввод");
            }
        }
    }
}
