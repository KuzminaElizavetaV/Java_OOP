package Client;

import Logger.MyLog;
import Infrastructure.CalcComplex.CalcComplexModel;
import Infrastructure.CalcRational.CalcRationalModel;
import Presentor.Presenter;

import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;


public class App {
    static Scanner in = new Scanner(System.in);
    static MyLog myLog = new MyLog(Logger.getLogger(App.class.getName()));

    static View view = new ConsoleView();
    static Presenter presenter = new Presenter<>(new CalcRationalModel(), view);

    public static void start() {
        while (true) {
            System.out.println("""
                    ***** ДЛЯ ВЫБОРА ОПЕРАЦИИ ВВЕДИТЕ ЧИСЛО *****
                        1 => ОПЕРАЦИИ С РАЦИОНАЛЬНЫМИ ЧИСЛАМИ
                        2 => ОПЕРАЦИИ С КОМПЛЕКСНЫМИ ЧИСЛАМИ
                        3 => ПОСМОТРЕТЬ ФАЙЛ ЛОГИРОВАНИЯ
                        4 => ВЫХОД ИЗ ПРОГРАММЫ
                    """);
            switch (in.nextInt()) {
                case 1 -> {
                    myLog.log("ВЫБРАН ПУНКТ МЕНЮ => ОПЕРАЦИИ С РАЦИОНАЛЬНЫМИ ЧИСЛАМИ ");
                    presenter = new Presenter<>(new CalcRationalModel(), view);
                    presenter.buttonClick();//или сразу так? presenter.buttonClickRational();
                }
                case 2 -> {
                    myLog.log("ВЫБРАН ПУНКТ МЕНЮ => ОПЕРАЦИИ С КОМПЛЕКСНЫМИ ЧИСЛАМИ");
                    presenter = new Presenter<>(new CalcComplexModel(), view);
                    presenter.buttonClick(); //или так? buttonClickComplex();
                }
                case 3 -> {
                    myLog.log("ВЫБРАН ПУНКТ МЕНЮ => ПОСМОТРЕТЬ ФАЙЛ ЛОГИРОВАНИЯ");
                    view.viewLog(new File("HomeWorkSem05\\src\\logCalc.txt"));
                }
                case 4 -> {
                    myLog.log("ВЫБРАН ПУНКТ МЕНЮ => ВЫХОД ИЗ ПРОГРАММЫ");
                    return;
                }
                default -> myLog.log("Введен некорректный пункт меню. Повторите ввод");
            }
        }
    }
}
